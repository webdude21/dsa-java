package eu.webdude.dsa.mitopencourseware;

public class PeakFinding {

    public static void main(String[] args) {
        int[] input = {1, 16, 3, 15, 5, 8, 7, 10, 9, 2};
        System.out.println(findAPeak(input, input.length / 2));
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
