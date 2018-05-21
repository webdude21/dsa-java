package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import java.util.stream.IntStream;

class MagicIndex {

  static int findMagicIndex(int[] input) {
    return IntStream
      .range(0, input.length)
      .filter(i -> i == input[i])
      .findFirst()
      .orElse(-1);
  }

  static int findMagicIndexWithBinarySearch(int[] input) {
    return findMagicIndexWithBinarySearch(input, 0, input.length - 1);
  }

  private static int findMagicIndexWithBinarySearch(int[] input, int start, int end) {
    if (end < start) {
      return -1;
    }

    var midPoint = (start + end) / 2;
    var midValue = input[midPoint];

    if (midPoint == midValue) {
      return midPoint;
    }

    var leftIndex = Math.min(midPoint - 1, midValue);
    var left = findMagicIndexWithBinarySearch(input, start, leftIndex);

    if (left >= 0) {
      return left;
    }

    var rightIndex = Math.max(midPoint + 1, midValue);
    var right = findMagicIndexWithBinarySearch(input, rightIndex, end);

    if (right >= 0) {
      return right;
    }

    return -1;
  }
}
