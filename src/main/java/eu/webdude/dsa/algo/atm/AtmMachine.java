package eu.webdude.dsa.algo.atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AtmMachine {
  private List<Bill> bills;

  public AtmMachine(List<Bill> inputBills) {
    bills = new ArrayList<>(inputBills);
    Collections.sort(bills);
  }

  private static List<Bill> takeOut(List<Bill> availableBills, int amount) {
    List<Bill> result = new ArrayList<>();
    var resultAmount = 0;
    var remainingAmount = amount;

    for (int i = 0, billsSize = availableBills.size(); i < billsSize; i++) {
      var bill = availableBills.get(i);

      var billCountToTake = (int) Math.floor(((double) remainingAmount) / ((double) bill.getAmount()));
      billCountToTake = Math.min(billCountToTake, bill.getCount());

      if (remainingAmount / bill.getAmount() > 0) {
        var newBill = Bill.of(bill.getAmount(), billCountToTake);
        result.add(newBill);
        availableBills.set(i, bill.subtract(billCountToTake));
        remainingAmount -= newBill.getTotal();
      }
    }

    if (resultAmount == remainingAmount) {
      return result;
    } else {
      availableBills.removeIf(bill -> bill.getAmount() == 5);
      return takeOut(availableBills, amount);
    }
  }

  public List<Bill> takeOut(int amount) {
    return takeOut(new ArrayList<>(bills), amount);
  }
}
