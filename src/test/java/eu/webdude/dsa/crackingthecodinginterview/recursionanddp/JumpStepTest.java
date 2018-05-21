package eu.webdude.dsa.crackingthecodinginterview.recursionanddp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JumpStepTest {

  private static final int MAX_JUMP_SIZE = 3;

  @Test
  void tripleStep() {
    assertEquals(7, JumpStep.jumpStep(4, MAX_JUMP_SIZE));
    assertEquals(927, JumpStep.jumpStep(12, MAX_JUMP_SIZE));
  }
}
