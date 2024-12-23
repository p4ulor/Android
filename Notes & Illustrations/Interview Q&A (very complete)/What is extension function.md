# What is extension function?

An extension function in Kotlin is a feature that allows developers to extend the functionality of classes without having to inherit from the class or use any type of design pattern such as Decorator. This is done via the special declaration called an extension function.

Extension functions behave interestingly:

For an extension function as a top-level declaration:

```kotlin
// Helpers.kt
fun String.isPhoneNumber(): Boolean = this.matches(PHONE_REGEX);

```

This is an example of an extension function in Kotlin. The function **`isPhoneNumber()`** is being added to the **`String`** class. This function checks if the string matches the pattern of a phone number as specified by **`PHONE_REGEX`**.

This Kotlin feature essentially enables you to add methods to existing classes without extending them or changing their source code.

It's worth noting that under the hood, Kotlin compiles this to a static method, thus leading to the behavior explained in your Kotlin-to-Java interop example.

A class will be generated again with a static method, this time accepting the extended type as a parameter:

```java
public class CheckKotlin {
  void check(){
    String phone = "+48 123 123 123";
    HelpersKt.isPhoneNumber(phone);
  }
}

```

In the Java code, **`HelpersKt.isPhoneNumber(phone);`** is the Java interop form of the Kotlin extension function. The function isn't being called as a method of the String (like in Kotlin), but as a static method from the **`HelpersKt`** class, because Java does not have a concept equivalent to Kotlin's extension functions.