# simple-message
A library to simple-message custom, error, information, success and warning.

[![Build Status](https://travis-ci.org/thiagogarbazza/simple-message.svg?branch=master)](https://travis-ci.org/thiagogarbazza/simple-message)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.github.thiagogarbazza:simple-message)](https://sonarcloud.io/dashboard/index/com.github.thiagogarbazza:simple-message)

## Install

Available in the [Maven Central repository].

Add a dependency to `com.github.thiagogarbazza:simple-message` in your project.

Example using maven:
```xml
<dependency>
  <groupId>com.github.thiagogarbazza</groupId>
  <artifactId>simple-message</artifactId>
  <version>0.1.0</version>
</dependency>
```

# Usage

Simple usage:
```java
public Message example() {
  return new Message(MessageType.INFORMATION, "key.a", "Message to key a");
}
```

Simple usage using `java.text.MessageFormat`:
```java
public Message exampleUsingMessageFormat() {
  return new Message(MessageType.INFORMATION, "key.a", "Message to key {0} by {1}", "a", "Thiago");
}
```

[Maven Central repository]: http://mvnrepository.com/artifact/com.github.thiagogarbazza/simple-message