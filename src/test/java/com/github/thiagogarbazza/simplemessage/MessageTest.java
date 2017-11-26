package com.github.thiagogarbazza.simplemessage;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.simplemessage.MessageType.INFORMATION;
import static org.junit.Assert.assertEquals;

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
  public void verifyHascode() {
    assertEquals(-1874554447, messageA.hashCode());
  }

  @Test
  public void verifySimpleConstructor() {
    assertEquals(INFORMATION, messageA.getType());
    assertEquals("my.key-a", messageA.getKey());
    assertEquals("My message for the key A.", messageA.getContent());
  }

  @Test
  public void verifyToString() {
    assertEquals("my.key-a", messageA.toString());
  }
}
