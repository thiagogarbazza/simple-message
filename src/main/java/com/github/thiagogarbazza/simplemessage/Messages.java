package com.github.thiagogarbazza.simplemessage;

import java.util.TreeSet;

/**
 * Represent a collection of the messages.
 */
public class Messages extends TreeSet<Message> {

  /**
   * @param type the desired type to extract.
   *
   * @return a new collection with messages of the desired type
   */
  public Messages extractByType(MessageType type) {
    Messages messages = new Messages();

    for (Message message : this) {
      if (message.getType().equals(type)) {
        messages.add(message);
      }
    }

    return messages;
  }
}
