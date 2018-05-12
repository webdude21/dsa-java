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

  public List<Bill> takeOut(int amount) {
    return takeOut(bills, amount);
  }

  private List<Bill> takeOut(List<Bill> bills, int amount) {
    List<Bill> result = new ArrayList<>();
    var resultAmount = 0;

    for (int i = 0, billsSize = bills.size(); i < billsSize; i++) {


      Bill bill = bills.get(i);
      int billCount = (int) Math.floor(amount / bill.getAmount());
      billCount = Math.min(billCount, bill.getCount());

      if (amount / bill.getAmount() >= 0) {
        result.add(Bill.of(bill.getAmount(), billCount));
        bills.set(i, bill.substract(billCount));
      }
    }

    if (resultAmount == amount) {
      return result;
    } else {
      bills.remove(bills.size() - 1);
      return takeOut(bills, amount);
    }
  }
}
