package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

public class StringsTest {

    private ArrayList<Function<String, Boolean>> allCharsImplementations = new ArrayList<>();

    public StringsTest() {
        allCharsImplementations.add(Strings::allUniqueCharacters);
        allCharsImplementations.add(Strings::allUniqueCharactersWithStream);
    }

    @Test
    public void positiveTestForPermutation() {
        assertTrue(Strings.isPermutation("aba", "baa"));
    }

    @Test
    public void negativeTestForPermutation() {
        assertFalse(Strings.isPermutation("cba", "afa"));
    }

    @Test
    public void oneAway() {
        assertTrue(Strings.isOneAway("pale", "ple"));
        assertTrue(Strings.isOneAway("pales", "pale"));
        assertTrue(Strings.isOneAway("pale", "bale"));
        assertFalse(Strings.isOneAway("pale", "bake"));
    }

    @Test
    public void stringCompression() {
        assertEquals("a2b1c5a3", Strings.compress("aabcccccaaa"));
        assertEquals("a2b1c5a2b1", Strings.compress("aabcccccaab"));
    }

    @Test
    public void positiveTestForPalindrome() {
        List<String> testInputs = Arrays.asList("anna", "Civic", "kayak", "level", "madam", "noon", "racecar",
                "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats", "tenet", "wow");

        testInputs.forEach(s -> assertTrue(Strings.isPalindrome(s)));
    }

    @Test
    public void positiveTestForPermutationOfAPalindrome() {
        assertTrue(Strings.isPermutationOfPalindrome("Tact Coa"));
    }

    @Test
    public void negativeTestForPalindrome() {
        assertFalse(Strings.isPalindrome("testing"));
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