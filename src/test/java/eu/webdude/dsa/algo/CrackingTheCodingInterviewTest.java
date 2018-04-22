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