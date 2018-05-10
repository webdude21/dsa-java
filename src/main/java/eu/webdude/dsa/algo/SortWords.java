package eu.webdude.dsa.algo;

import java.util.Arrays;
import java.util.Scanner;

class SortWords {

  public static void main(String[] args) {
    var scanner = new Scanner(System.in);
    var input = scanner.nextLine().split("\\s+");
    Arrays.sort(input);
    System.out.println(String.join(" ", input));
  }
}
