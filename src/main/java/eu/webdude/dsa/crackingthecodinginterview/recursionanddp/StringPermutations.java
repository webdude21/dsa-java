package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.ArrayList;

class StringPermutations {

  private static StringBuilder stringBuilder;

  static ArrayList<String> permutationsWithoutDuplicates(String input) {
    ArrayList<String> result = new ArrayList<>();
    stringBuilder = new StringBuilder();

    permutationsWithoutDuplicates(input, result, 0);
    return result;
  }

  private static void permutationsWithoutDuplicates(String input, ArrayList<String> strings, int startIndex) {
    if (stringBuilder.length() == input.length()) {
      strings.add(stringBuilder.toString());
      stringBuilder.setLength(0);
      return;
    }

    for (int i = startIndex; i < input.length(); i++) {
      stringBuilder.append(input.charAt(i));
      permutationsWithoutDuplicates(input, strings, i + 1);
    }
  }
}
