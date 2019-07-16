package com.github.thiagogarbazza.simplemessage;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.CUSTOM;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.ERROR;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.FATAL_ERROR;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.INFORMATION;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.SUCCESS;
import static com.github.thiagogarbazza.simplemessage.SimpleMessageType.WARNING;
import static org.junit.Assert.assertEquals;

public class SimpleMessagesTest {

  private SimpleMessages simpleMessages;

  @Before
  public void beforeTest() {
    simpleMessages = new SimpleMessages();
    simpleMessages.add(new SimpleMessage(CUSTOM, "key.a", "SimpleMessage to key a"));
    simpleMessages.add(new SimpleMessage(INFORMATION, "key.b", "SimpleMessage to key b"));
    simpleMessages.add(new SimpleMessage(ERROR, "key.c", "SimpleMessage to key c"));
    simpleMessages.add(new SimpleMessage(FATAL_ERROR, "key.d", "SimpleMessage to key d"));
    simpleMessages.add(new SimpleMessage(SUCCESS, "key.e", "SimpleMessage to key e"));
    simpleMessages.add(new SimpleMessage(WARNING, "key.g", "SimpleMessage to key g"));
  }

  @Test
  public void verifyToExtractByType() {
    SimpleMessages mErrors = simpleMessages.extractByType(ERROR);

    assertEquals(1, mErrors.size());
    assertEquals("key.c", mErrors.get(0).getKey());
  }
}
