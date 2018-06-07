package eu.webdude.dsa.projecteuler;

class SpecialPythagoreanTriplet {

  static long solve(int sum) {
    for (long a = 1; a <= sum / 3; a++) {
      for (long b = a + 1; b <= sum / 2; b++) {
        long c = sum - a - b;
        if (a * a + b * b == c * c) {
          return a * b * c;
        }
      }
    }

    return -1;
  }
}
