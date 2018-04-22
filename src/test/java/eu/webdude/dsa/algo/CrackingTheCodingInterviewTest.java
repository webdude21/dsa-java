package eu.webdude.dsa.algo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CrackingTheCodingInterviewTest {

    private ArrayList<Function<String, Boolean>> allCharsImplementations = new ArrayList<>();

    public CrackingTheCodingInterviewTest() {
        allCharsImplementations.add(CrackingTheCodingInterview::allUniqueCharacters);
        allCharsImplementations.add(CrackingTheCodingInterview::allUniqueCharactersWithStream);
    }

    @Test
    public void positiveTestForPermutation() {
        assertTrue(CrackingTheCodingInterview.isPermutation("aba", "baa"));
    }

    @Test
    public void negativeTestForPermutation() {
        assertFalse(CrackingTheCodingInterview.isPermutation("cba", "afa"));
    }

    @Test
    public void positiveTestForPalindrome() {
        List<String> testInputs = Arrays.asList("anna", "Civic", "kayak", "level", "madam", "noon", "racecar",
                "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats", "tenet", "wow");

        testInputs.forEach(s -> assertTrue(CrackingTheCodingInterview.isPalindrome(s)));
    }

    @Test
    public void positiveTestForPalindromeWithWhiteSpace() {
        assertTrue(CrackingTheCodingInterview.isPalindrome("Tact Coa"));
    }

    @Test
    public void negativeTestForPalindrome() {
        assertFalse(CrackingTheCodingInterview.isPalindrome("testing"));
    }

    @Test
    public void positiveTestWithAllUniqueCharacters() {
        List<String> testInputs = Arrays.asList("abcd", "abcdABCDФГфг", "abcdABCDФГфг");
        allCharsImplementations.forEach(allChars -> testInputs.forEach(input -> assertTrue(allChars.apply(input))));
    }

    @Test
    public void negativeTestWithAllRepeatingCharacters() {
        List<String> testInputs = Arrays.asList("abcda", "abcdABCDФГфгa");
        allCharsImplementations.forEach(allChars -> testInputs.forEach(input -> assertFalse(allChars.apply(input))));
    }
}