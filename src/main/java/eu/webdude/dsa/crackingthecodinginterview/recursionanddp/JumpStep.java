package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.stream.IntStream;

class JumpStep {

  static int jumpStep(int n, int maxJumpSize) {
    if (n < 0) {
      return 0;
    } else if (n == 0) {
      return 1;
    } else {
      return IntStream.rangeClosed(1, maxJumpSize)
        .map(i -> jumpStep(n - i, maxJumpSize))
        .sum();
    }
  }
}
