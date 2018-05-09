package eu.webdude.dsa.algo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

class OccurencesCount {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String[] input = scanner.nextLine().split("\\s+");

    String result = Arrays.stream(input)
      .map(Long::parseLong)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
      .entrySet()
      .stream()
      .map(x -> String.format("%d -> %d times", x.getKey(), x.getValue()))
      .collect(Collectors.joining(System.lineSeparator()));

    System.out.print(result);
  }
}
