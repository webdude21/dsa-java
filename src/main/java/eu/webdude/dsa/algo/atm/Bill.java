package eu.webdude.dsa.algo.atm;

import java.util.List;
import java.util.Objects;

public class Bill implements Comparable<Bill> {

  private final int amount;
  private final int count;

  private Bill(int amount, int count) {
    this.amount = amount;
    this.count = count;
  }

  public static Bill of(int amount, int count) {
    return new Bill(amount, count);
  }

  public static int sum(List<Bill> billList) {
    return billList.stream().mapToInt(Bill::getTotal).sum();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Bill)) return false;
    Bill bill = (Bill) o;
    return getAmount() == bill.getAmount() &&
      getCount() == bill.getCount();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getAmount(), getCount());
  }

  private int getTotal() {
    return amount * count;
  }

  @Override
  public int compareTo(Bill o) {
    if (o == null) {
      return 1;
    }

    return Integer.compare(o.amount, this.amount);
  }

  @Override
  public String toString() {
    return String.format("%dx%d", amount, count);
  }

  Bill subtract(int amountToSubstract) {
    return new Bill(getAmount(), getCount() - amountToSubstract);
  }

  int getAmount() {
    return amount;
  }

  private int getCount() {
    return count;
  }
}
