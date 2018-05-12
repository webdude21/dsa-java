package eu.webdude.dsa.algo.atm;

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

  public Bill substract(int amountToSubstract) {
    return new Bill(getAmount(), getCount() - amountToSubstract);
  }

  public int getAmount() {
    return amount;
  }

  public int getCount() {
    return count;
  }

  @Override
  public int compareTo(Bill o) {
    if (o == null) {
      return 1;
    }

    return Integer.compare(o.amount, this.amount);
  }
}
