package eu.webdude.dsa.algo;

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
}