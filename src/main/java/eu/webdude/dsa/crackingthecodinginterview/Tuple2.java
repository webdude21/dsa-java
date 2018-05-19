package eu.webdude.dsa.crackingthecodinginterview;

class Tuple2<T, K> {

  public final T first;

  public final K second;

  public static <T, K> Tuple2 of(T first, K second) {
    return new Tuple2<>(first, second);
  }

  public Tuple2(T first, K second) {
    this.first = first;
    this.second = second;
  }
}
