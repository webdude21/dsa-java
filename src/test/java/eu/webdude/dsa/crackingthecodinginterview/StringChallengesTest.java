package eu.webdude.dsa.crackingthecodinginterview;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class StringChallengesTest {

  private ArrayList<Function<String, Boolean>> allCharsImplementations = new ArrayList<>();

  StringChallengesTest() {
    allCharsImplementations.add(StringChallenges::allUniqueCharacters);
    allCharsImplementations.add(StringChallenges::allUniqueCharactersWithStream);
  }

  @Test
  void stringRotation() {
    assertTrue(StringChallenges.isRotation("waterbottle", "erbottlewat"));
  }

  @Test
  void positiveTestForPermutation() {
    assertTrue(StringChallenges.isPermutation("aba", "baa"));
  }

  @Test
  void negativeTestForPermutation() {
    assertFalse(StringChallenges.isPermutation("cba", "afa"));
  }

  @Test
  void oneAway() {
    assertTrue(StringChallenges.isOneAway("pale", "ple"));
    assertTrue(StringChallenges.isOneAway("pales", "pale"));
    assertTrue(StringChallenges.isOneAway("pale", "bale"));
    assertFalse(StringChallenges.isOneAway("pale", "bake"));
  }

  @Test
  void stringCompression() {
    assertEquals("a2b1c5a3", StringChallenges.compress("aabcccccaaa"));
    assertEquals("a2b1c5a2b1", StringChallenges.compress("aabcccccaab"));
  }

  @Test
  void positiveTestForPalindrome() {
    List<String> testInputs = Arrays.asList("anna", "Civic", "kayak", "level", "madam", "noon", "racecar",
      "radar", "redder", "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats", "tenet", "wow");

    testInputs.forEach(s -> assertTrue(StringChallenges.isPalindrome(s)));
  }

  @Test
  void positiveTestForPermutationOfAPalindrome() {
    assertTrue(StringChallenges.isPermutationOfPalindrome("Tact Coa"));
  }

  @Test
  void negativeTestForPalindrome() {
    assertFalse(StringChallenges.isPalindrome("testing"));
  }

  @Test
  void positiveTestWithAllUniqueCharacters() {
    List<String> testInputs = Arrays.asList("abcd", "abcdABCDФГфг", "abcdABCDФГфг");
    allCharsImplementations.forEach(allChars -> testInputs.forEach(input -> assertTrue(allChars.apply(input))));
  }

  @Test
  void negativeTestWithAllRepeatingCharacters() {
    List<String> testInputs = Arrays.asList("abcda", "abcdABCDФГфгa");
    allCharsImplementations.forEach(allChars -> testInputs.forEach(input -> assertFalse(allChars.apply(input))));
  }
}
