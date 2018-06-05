package eu.webdude.dsa.projecteuler;

class LargestProductInaSeries {

  static long solve(String input, int seriesLength) {
    char[] chars = input.toCharArray();
    long maxProduct = 1;

    for (int i = 0; i < chars.length - seriesLength; i++) {
      long currentProduct = 1;

      for (int j = 0; j < seriesLength; j++) {
        currentProduct *= (chars[i + j] - '0') ;
      }

      maxProduct = Math.max(currentProduct, maxProduct);
    }

    return maxProduct;
  }
}
