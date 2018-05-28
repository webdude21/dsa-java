package eu.webdude.dsa.projecteuler;

class LargestPrimeFactor {

  static long solve(long n) {
    for (int i = 2; i < Math.sqrt(n); i++) {
      if (n % i == 0) {
        n /= i;
      }
    }

    return n;
  }
}
