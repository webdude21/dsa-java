package eu.webdude.dsa.algo;

import java.util.Arrays;

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
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        for (int i = 0; i < processedInput.length() / 2; i++) {
            if (processedInput.charAt(i) != processedInput.charAt(processedInput.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}