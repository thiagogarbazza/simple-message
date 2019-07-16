package com.github.thiagogarbazza.simplemessage;

import java.util.ArrayList;

/**
 * Represent a collection of the messages.
 */
public class SimpleMessages extends ArrayList<SimpleMessage> {

  /**
   * @param type the desired type to extract.
   *
   * @return a new collection with messages of the desired type
   */
  public SimpleMessages extractByType(SimpleMessageType type) {
    SimpleMessages simpleMessages = new SimpleMessages();

    for (SimpleMessage simpleMessage : this) {
      if (simpleMessage.getType().equals(type)) {
        simpleMessages.add(simpleMessage);
      }
    }

    return simpleMessages;
  }
}
