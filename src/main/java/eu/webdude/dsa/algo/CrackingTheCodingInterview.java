package eu.webdude.dsa.algo;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CrackingTheCodingInterview {
    static boolean allUniqueCharacters(String input) {
        for (int i = 0; i < input.length() - 1; i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean allUniqueCharactersWithStream(String input) {
        return input.chars().distinct().count() == input.length();
    }

    static boolean isPermutation(String a, String b) {
        char[] aCharArr = a.toCharArray();
        char[] bCharArr = b.toCharArray();
        Arrays.sort(aCharArr);
        Arrays.sort(bCharArr);

        return Arrays.equals(aCharArr, bCharArr);
    }

    public static boolean isPalindrome(String input) {
        String processedInput = input.replaceAll("\\W", "").toLowerCase();

        for (int i = 0; i < processedInput.length() / 2; i++) {
            if (processedInput.charAt(i) != processedInput.charAt(processedInput.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPermutationOfPalindrome(String input) {
        String processedInput = input.replaceAll("\\W", "").toLowerCase();
        Predicate<Long> isEven = val -> val / 2 == 0;

        long unevenOccurrences = processedInput
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .filter(isEven)
                .count();

        return unevenOccurrences == 0 || unevenOccurrences == 1 && !isEven.test((long) processedInput.length());
    }
}