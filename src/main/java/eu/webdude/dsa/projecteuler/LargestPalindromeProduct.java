package eu.webdude.dsa.projecteuler;

class LargestPalindromeProduct {

  static long solve(int digitsInProduct) {
    var upperBound = (long) Math.pow(10, digitsInProduct) - 1;
    var lowerBound = (long) (upperBound - Math.pow(10, digitsInProduct - 1)) - 1;
    long maxPalindrome = -1;

    for (var a = upperBound; a >= lowerBound; a--) {
      for (var b = upperBound; b >= lowerBound; b--) {
        var product = a * b;
        if (isPalindrome(String.valueOf(product))) {
          maxPalindrome = Math.max(maxPalindrome, product);
        }
      }
    }

    return maxPalindrome;
  }

  private static boolean isPalindrome(String input) {
    for (var i = 0; i < input.length() / 2; i++) {
      if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }
}
