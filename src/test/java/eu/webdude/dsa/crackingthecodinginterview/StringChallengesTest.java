package eu.webdude.dsa.crackingthecodinginterview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
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

  @ParameterizedTest
  @ValueSource(strings = {"anna", "Civic", "kayak", "level", "madam", "noon", "racecar", "radar", "redder",
    "refer", "repaper", "rotator", "rotor", "sagas", "solos", "stats", "tenet", "wow"})
  void positiveTestForPalindrome(String palindromeCandidate) {
    assertTrue(StringChallenges.isPalindrome(palindromeCandidate));
  }

  @Test
  void positiveTestForPermutationOfAPalindrome() {
    assertTrue(StringChallenges.isPermutationOfPalindrome("Tact Coa"));
  }

  @Test
  void negativeTestForPalindrome() {
    assertFalse(StringChallenges.isPalindrome("testing"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"abcd", "abcdABCDФГфг", "abcdABCDФГфг"})
  void positiveTestWithAllUniqueCharacters(String input) {
    allCharsImplementations.forEach(allChars -> assertTrue(allChars.apply(input)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"abcda", "abcdABCDФГфгa"})
  void negativeTestWithAllRepeatingCharacters(String input) {
    allCharsImplementations.forEach(allChars -> assertFalse(allChars.apply(input)));
  }
}
