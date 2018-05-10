package eu.webdude.dsa.mitopencourseware;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.isOneOf;

class PeakFindingTest {

  @Test
  void findAPeak() {
    int[] input = {1, 16, 3, 15, 5, 8, 7, 10, 9, 2};
    var actual = PeakFinding.findAPeak(input);
    assertThat(actual, isOneOf(15, 16, 8, 10));
  }
}
