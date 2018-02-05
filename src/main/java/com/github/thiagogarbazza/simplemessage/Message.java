package com.github.thiagogarbazza.simplemessage;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

import static java.text.MessageFormat.format;

/**
 * Simple message with type and key.
 */
@Getter
@EqualsAndHashCode(doNotUseGetters = true, of = {"key"})
public class Message implements Comparable<Message>, Serializable {

  private final String content;
  private final String key;
  private final MessageType type;

  /**
   * @param type message type can be custom, error, information, success and warning.
   * @param key the key for message.
   * @param content the Message Content
   */
  public Message(final MessageType type, final String key, final String content) {
    this.type = type;
    this.key = key;
    this.content = content;
  }

  /**
   * Create a new message using {@link java.text.MessageFormat} to format the content.
   *
   * @param type message type can be custom, error, information, success and warning.
   * @param key the key for message.
   * @param pattern the pattern for this message format
   * @param arguments an array of objects to be formatted and substituted.
   *
   * @throws IllegalArgumentException if the pattern is invalid, or if an argument in the <code>arguments</code> array is not of the type expected
   * by the format element(s) that use it.
   */
  public Message(final MessageType type, final String key, final String pattern, final Object... arguments) {
    this(type, key, format(pattern, arguments));
  }

  @Override
  public int compareTo(final Message that) {
    if (that == null) {
      return 1;
    }

    return this.key.compareTo(that.key);
  }

  @Override
  public String toString() {
    return this.key;
  }
}
