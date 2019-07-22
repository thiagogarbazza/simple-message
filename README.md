# simple-message
A library to simple-message custom, fatal error, error, information, success and warning.

[![Build Status](https://travis-ci.org/thiagogarbazza/simple-message.svg?branch=master)](https://travis-ci.org/thiagogarbazza/simple-message)
[![Coverage Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.thiagogarbazza:simple-message&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.github.thiagogarbazza:simple-message)
[![Coverage Status](https://sonarcloud.io/api/project_badges/measure?project=com.github.thiagogarbazza:simple-message&metric=coverage)](https://sonarcloud.io/dashboard?id=com.github.thiagogarbazza:simple-message)

## Install

Available in the [Maven Central repository].

Add a dependency to `com.github.thiagogarbazza:simple-message` in your project.

Example using maven:
```xml
<dependency>
  <groupId>com.github.thiagogarbazza</groupId>
  <artifactId>simple-message</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage samples

Simple usage:
```java
public SimpleMessage example() {
  return new SimpleMessage(SimpleMessageType.INFORMATION, "key.a", "Message to key a");
}
```

Simple usage using `java.text.MessageFormat`:
```java
public SimpleMessage exampleUsingMessageFormat() {
  return new SimpleMessage(SimpleMessageType.INFORMATION, "key.a", "Message to key {0} by {1}", "a", "Thiago");
}
```

[Maven Central repository]: http://mvnrepository.com/artifact/com.github.thiagogarbazza/simple-message
