package com.github.thiagogarbazza.simplemessage;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.INFORMATION;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.WARNING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SimpleMessageTest {

  private static final String MESSAGE_CONTENT = "My message for the key {0}.";
  private SimpleMessage simpleMessageA;
  private SimpleMessage simpleMessageB;

  @Before
  public void beforeTest() {
    simpleMessageA = new SimpleMessage(INFORMATION, "my.key-a", MESSAGE_CONTENT, "A");
    simpleMessageB = new SimpleMessage(WARNING, "my.key-b", MESSAGE_CONTENT, "B");
  }

  @Test
  public void verifyCompareToEqual() {
    assertEquals(0, simpleMessageA.compareTo(simpleMessageA));
  }

  @Test
  public void verifyCompareToEqualNull() {
    assertEquals(-1, simpleMessageA.compareTo(null));
  }

  @Test
  public void verifyCompareToGreater() {
    assertTrue(simpleMessageB.compareTo(simpleMessageA) > 0);
  }

  @Test
  public void verifyCompareToLesser() {
    assertTrue(simpleMessageA.compareTo(simpleMessageB) < 0);
  }

  @Test
  public void verifyCompareToNull() {
    assertEquals(-1, simpleMessageA.compareTo(null));
  }

  @Test
  public void verifyEgualsFalse() {
    assertFalse(simpleMessageA.equals(simpleMessageB));
    assertFalse(simpleMessageA.equals(MESSAGE_CONTENT));
  }

  @Test
  public void verifyEgualsTrue() {
    assertTrue(simpleMessageA.equals(simpleMessageA));
    assertTrue(simpleMessageA.equals(new SimpleMessage(INFORMATION, "my.key-a", MESSAGE_CONTENT, "A")));
  }

  @Test
  public void verifySimpleConstructor() {
    assertEquals(INFORMATION, simpleMessageA.getType());
    assertEquals("my.key-a", simpleMessageA.getKey());
    assertEquals("My message for the key A.", simpleMessageA.getContent());
  }
}
