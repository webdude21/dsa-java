package eu.webdude.dsa.algo.atm;

import java.util.*;

public class AtmMachine {
  private List<Bill> bills;

  public AtmMachine(List<Bill> inputBills) {
    bills = new ArrayList<>(inputBills);
    Collections.sort(bills);
  }

  public List<Bill> takeOut(int amount) {
    Deque<Bill> availableBills = new LinkedList<>(this.bills);
    List<Bill> resultBills = new ArrayList<>();
    takeOut(availableBills, resultBills, amount, amount);
    return resultBills;
  }

  private void takeOut(Deque<Bill> availableBills, List<Bill> results, int remainingAmount, int totalAmount) {
    if (isSumComplete(results, totalAmount)) {
      return;
    }

    if (availableBills.size() == 0) {
      return;
    }

    Bill currentBill = availableBills.pop();

    int coveredCount = remainingAmount / currentBill.getAmount();

    while (coveredCount > 0) {
      int newRemainingAmount = remainingAmount - coveredCount * currentBill.getAmount();
      var newResultEntry = Bill.of(currentBill.getAmount(), coveredCount);
      results.add(newResultEntry);

      if (newRemainingAmount == 0) {
        return;
      }

      takeOut(new LinkedList<>(availableBills), results, newRemainingAmount, remainingAmount);

      if (isSumComplete(results, totalAmount)) {
        break;
      }

      results.remove(newResultEntry);
      coveredCount--;
    }

    if (availableBills.size() > 0) {
      takeOut(new LinkedList<>(availableBills), results, remainingAmount, totalAmount);
    }
  }

  private boolean isSumComplete(List<Bill> results, int totalAmount) {
    return Bill.sum(results) == totalAmount;
  }
}
