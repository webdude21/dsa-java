package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class StringChallengesTest {

    private ArrayList<Function<String, Boolean>> allCharsImplementations = new ArrayList<>();

    public StringChallengesTest() {
        allCharsImplementations.add(StringChallenges::allUniqueCharacters);
        allCharsImplementations.add(StringChallenges::allUniqueCharactersWithStream);
    }

    @Test
    public void positiveTestForPermutation() {
        assertTrue(StringChallenges.isPermutation("aba", "baa"));
    }

    @Test
    public void negativeTestForPermutation() {
        assertFalse(StringChallenges.isPermutation("cba", "afa"));
    }

    @Test
    public void oneAway() {
        assertTrue(StringChallenges.isOneAway("pale", "ple"));
        assertTrue(StringChallenges.isOneAway("pales", "pale"));
        assertTrue(StringChallenges.isOneAway("pale", "bale"));
        assertFalse(StringChallenges.isOneAway("pale", "bake"));
    }

    @Test
    public void stringCompression() {
        assertEquals("a2b1c5a3", StringChallenges.compress("aabcccccaaa"));
        assertEquals("a2b1c5a2b1", StringChallenges.compress("aabcccccaab"));
    }

    @Test
    public void positiveTestForPalindrome() {
        List<String> testInputs = Arrays.asList("anna", "Civic", "kayak", "level", "madam", "noon", "racecar",
                "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats", "tenet", "wow");

        testInputs.forEach(s -> assertTrue(StringChallenges.isPalindrome(s)));
    }

    @Test
    public void positiveTestForPermutationOfAPalindrome() {
        assertTrue(StringChallenges.isPermutationOfPalindrome("Tact Coa"));
    }

    @Test
    public void negativeTestForPalindrome() {
        assertFalse(StringChallenges.isPalindrome("testing"));
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