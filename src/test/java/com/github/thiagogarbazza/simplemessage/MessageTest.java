package com.github.thiagogarbazza.simplemessage;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.simplemessage.MessageType.INFORMATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MessageTest {

  private static final String MESSAGE_CONTENT = "My message for the key {0}.";
  private Message messageA;
  private Message messageB;

  @Before
  public void beforeTest() {
    messageA = new Message(INFORMATION, "my.key-a", MESSAGE_CONTENT, "A");
    messageB = new Message(INFORMATION, "my.key-b", MESSAGE_CONTENT, "B");
  }

  @Test
  public void verifyCompareToEqualNull() {
    assertEquals(1, messageA.compareTo(null));
  }

  @Test
  public void verifyCompareToEqual() {
    assertEquals(0, messageA.compareTo(messageA));
  }

  @Test
  public void verifyCompareToGreater() {
    assertEquals(1, messageB.compareTo(messageA));
  }

  @Test
  public void verifyCompareToLesser() {
    assertEquals(-1, messageA.compareTo(messageB));
  }

  @Test
  public void verifyCompareToNull() {
    assertEquals(1, messageA.compareTo(null));
  }

  @Test
  public void verifyEgualsFalse() {
    assertFalse(messageA.equals(messageB));
    assertFalse(messageA.equals(MESSAGE_CONTENT));
  }

  @Test
  public void verifyEgualsTrue() {
    assertTrue(messageA.equals(messageA));
    assertTrue(messageA.equals(new Message(INFORMATION, "my.key-a", MESSAGE_CONTENT, "A")));
  }

  @Test
  public void verifySimpleConstructor() {
    assertEquals(INFORMATION, messageA.getType());
    assertEquals("my.key-a", messageA.getKey());
    assertEquals("My message for the key A.", messageA.getContent());
  }
}
