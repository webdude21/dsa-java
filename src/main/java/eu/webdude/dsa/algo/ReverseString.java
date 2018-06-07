package eu.webdude.dsa.algo;

class ReverseString {
  static String reverseString(String input) {
    if (input.length() <= 1) {
      return input;
    }

    return reverseString(input.substring(1)) + input.charAt(0);
  }
}
