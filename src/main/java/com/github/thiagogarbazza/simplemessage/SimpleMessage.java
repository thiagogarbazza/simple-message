package com.github.thiagogarbazza.simplemessage;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

import static java.text.MessageFormat.format;

/**
 * Simple message with type and key.
 */
@Getter
@ToString(of = {"type", "key"})
@EqualsAndHashCode(of = {"type", "key"})
public class SimpleMessage implements Comparable<SimpleMessage>, Serializable {

  private final String content;
  private final String key;
  private final SimpleMessageType type;

  /**
   * @param type message type can be custom, error, information, success and warning.
   * @param key the key for message.
   * @param content the SimpleMessage Content
   */
  public SimpleMessage(final SimpleMessageType type, final String key, final String content) {
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
  public SimpleMessage(final SimpleMessageType type, final String key, final String pattern, final Object... arguments) {
    this(type, key, format(pattern, arguments));
  }

  @Override
  public int compareTo(final SimpleMessage that) {
    if (that == null) {
      return -1;
    }

    int compare = this.type.compareTo(that.type);

    if (compare == 0) {
      compare = this.key.compareTo(that.key);
    }

    return compare;
  }
}
