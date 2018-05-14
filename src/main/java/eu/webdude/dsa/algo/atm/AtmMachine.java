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
    var result = new ArrayList<Bill>();
    var remainingAmount = amount;

    for (var i = 0; i < availableBills.size(); i++) {
      var bill = availableBills.get(i);

      var billCountToTake = remainingAmount / bill.getAmount();
      billCountToTake = Math.min(billCountToTake, bill.getCount());

      if (remainingAmount / bill.getAmount() > 0) {
        var newBill = Bill.of(bill.getAmount(), billCountToTake);
        result.add(newBill);
        availableBills.set(i, bill.subtract(billCountToTake));
        remainingAmount -= newBill.getTotal();
      }
    }

    return result;
  }

  public List<Bill> takeOut(int amount) {
    ArrayList<Bill> availableBills = new ArrayList<>(this.bills);
    List<Bill> bills = takeOut(availableBills, amount);

    if (amount == Bill.sum(bills)) {
      return bills;
    }

    for (int i = 0; i < availableBills.size(); i++) {
      Bill removedBill = availableBills.remove(i);
      List<Bill> resultBills = takeOut(availableBills, amount);
      if (Bill.sum(resultBills) == amount) {
        return resultBills;
      } else {
        availableBills.add(i, removedBill);
      }
    }

    return bills;
  }
}
