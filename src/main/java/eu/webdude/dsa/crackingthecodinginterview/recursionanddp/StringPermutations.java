package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.ArrayList;

class StringPermutations {

  static ArrayList<String> permutationsWithoutDuplicates(String input) {
    ArrayList<String> perms = new ArrayList<>();

    if (input.length() == 0) {
      perms.add("");
      return perms;
    }

    char firstChar = input.charAt(0);
    String remainingString = input.substring(1);

    ArrayList<String> words = permutationsWithoutDuplicates(remainingString);
    for (String permutations : words) {
      for (int i = 0; i < input.length(); i++) {
        String s = insertCharAt(permutations, firstChar, i);
        perms.add(s);
      }
    }

    return perms;
  }

  private static String insertCharAt(String word, char toInsert, int position) {
    return word.substring(0, position) + toInsert + word.substring(position);
  }
}
