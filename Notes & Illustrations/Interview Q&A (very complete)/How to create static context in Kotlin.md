# How to create static context in Kotlin?

Kotlin does not have the concept of "static" like Java, but it is possible to achieve similar behavior and create properties or methods that are not tied to an object instance, but to its class. To understand Kotlin's approach to static, let's see how Kotlin code will be used in Java:

### Companion object

```kotlin
class PeopleTable{
  companion object{
    const val TABLE_NAME = "people"
  }
}

```

```java
public class CheckKotlin {
  void check(){
    String tableName = PeopleTable.TABLE_NAME;
  }
}

```

From Java's perspective, `TABLE_NAME` looks like a `public static final` field in the `PeopleTable` class.

### object class

An object class acts like a Singleton - there is only one instance:

```kotlin
object DbHandler{
  val connection: Connection = ...
}

```

To use `connection` in Java, we need to use `INSTANCE`:

```java
public class CheckKotlin {
  void check(){
    DbHandler.INSTANCE.getConnection();
  }
}

```

### Top-level declaration

```kotlin
// Helpers.kt
fun isEmail(input: String): Boolean = input.matches(EMAIL_REGEX)

```

A function declared at the file level, rather than in a class, can also be used in Java. An additional class, `Helpers.kt`, will be generated:

```java
public class CheckKotlin {
  void check(){
    String email = "jarek@kotlintesting.com";
    HelpersKt.isEmail(email);
  }
}

```

### Extension functions

Extension functions behave interestingly:

For an extension function as a top-level declaration:

```kotlin
// Helpers.kt
fun String.isPhoneNumber(): Boolean = this.matches(PHONE_REGEX);

```

Another class with a static method will be generated, this time accepting the extended type as a parameter:

```java
public class CheckKotlin {
  void check(){
    String phone = "+48 123 123 123";
    HelpersKt.isPhoneNumber(phone);
  }
}

```