# What is the purpose of companion object?

The creators of Kotlin did not want to use Java's `static` concept directly, but in order to maintain compatibility with Java, they provided a construct called `companion object`.

`companion object` is defined inside a class and everything we place in it (methods, properties) will be associated with the class itself, not its instance.

For full compatibility with Java, there is also the `JvmStatic` annotation.

In this case, from Java code, we will be able to access the field in the companion object without using the Companion object:

```
class SomeClass {
  companion object{
    val something = "Asd"
    @JvmStatic
    val otherthing = "Fgh"
  }
}

```

```
private void run(){
  SomeClass.getOtherthing();
  SomeClass.Companion.getSomething();
  SomeClass.Companion.getOtherthing();
}

```

When can `JvmStatic` be useful? When we create a library in Kotlin and want its users to be able to use it nicely in Java.