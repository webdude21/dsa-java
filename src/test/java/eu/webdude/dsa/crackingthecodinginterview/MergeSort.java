package eu.webdude.dsa.crackingthecodinginterview;

import java.util.Arrays;
import java.util.function.Consumer;

class MergeSort {

  static <T extends Comparable<T>> T[] sort(T[] input) {
    return sort(input, t -> {
    });
  }

  static <T extends Comparable<T>> T[] sort(T[] input, Consumer<T> inversionConsumer) {
    if (input.length <= 1) {
      return input;
    }

    T[] left = sort(Arrays.copyOfRange(input, 0, input.length / 2));
    T[] right = sort(Arrays.copyOfRange(input, input.length / 2, input.length));

    return merge(left, right, inversionConsumer);
  }

  private static <T extends Comparable<T>> T[] merge(T[] left, T[] right, Consumer<T> inversionConsumer) {
    @SuppressWarnings("unchecked")
    T[] result = (T[]) new Comparable[left.length + right.length];

    int leftIndex = 0;
    int rightIndex = 0;

    for (int i = 0; i < result.length; i++) {
      if (leftIndex < left.length && rightIndex < right.length) {
        if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
          result[i] = left[leftIndex++];
        } else {
          result[i] = right[rightIndex++];
        }
      } else if (leftIndex < left.length) {
        result[i] = left[leftIndex++];
      } else {
        result[i] = right[rightIndex++];
      }
    }

    return result;
  }
}
