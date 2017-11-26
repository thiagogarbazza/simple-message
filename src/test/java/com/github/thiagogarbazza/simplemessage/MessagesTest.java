package com.github.thiagogarbazza.simplemessage;

import org.junit.Before;
import org.junit.Test;

import static com.github.thiagogarbazza.simplemessage.MessageType.CUSTOM;
import static com.github.thiagogarbazza.simplemessage.MessageType.ERROR;
import static com.github.thiagogarbazza.simplemessage.MessageType.INFORMATION;
import static com.github.thiagogarbazza.simplemessage.MessageType.SUCCESS;
import static com.github.thiagogarbazza.simplemessage.MessageType.WARNING;
import static org.junit.Assert.assertEquals;

public class MessagesTest {

  private Messages messages;

  @Before
  public void beforeTest() {
    messages = new Messages();
    messages.add(new Message(CUSTOM, "key.a", "Message to key a"));
    messages.add(new Message(INFORMATION, "key.b", "Message to key b"));
    messages.add(new Message(ERROR, "key.c", "Message to key c"));
    messages.add(new Message(SUCCESS, "key.d", "Message to key d"));
    messages.add(new Message(WARNING, "key.e", "Message to key e"));
  }

  @Test
  public void verifyToExtractByType() {
    Messages mErrors = messages.extractByType(ERROR);

    assertEquals(1, mErrors.size());
    assertEquals("key.c", mErrors.first());
  }
}
