package eu.webdude.dsa.mitopencourseware;

class PeakFinding {

  public static int findAPeak(int[] input) {
    return findAPeak(input, input.length / 2);
  }

  private static int findAPeak(int[] input, int peakCandidateIndex) {
    if (input.length <= 1) {
      return input[0];
    }

    var peakCandidate = input[peakCandidateIndex];
    var aNeighbourIsOutOfBounds = peakCandidateIndex + 1 >= input.length || peakCandidateIndex - 1 <= 0;

    if (aNeighbourIsOutOfBounds) {
      return peakCandidate;
    }

    var arrSize = input.length - 1;
    var left = input[peakCandidateIndex - 1];
    var right = input[peakCandidateIndex + 1];


    if (peakCandidate >= left && peakCandidate >= right) {
      return peakCandidate;
    } else if (peakCandidate >= left) {
      return findAPeak(input, (arrSize + peakCandidate) / 2);
    } else {
      return findAPeak(input, (arrSize - peakCandidate) / 2);
    }
  }
}
