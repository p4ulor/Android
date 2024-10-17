# What is SAM conversion?

SAM stands for Single Abstract Method. If a Java interface we want to implement as an anonymous class has only one method, for example:

```kotlin
val clickListener = object : View.OnClickListener{
  override fun onClick(v: View?) {
    TODO("Not yet implemented")
  }
}
```

We can use a lambda expression as follows:

```kotlin
val clickListener = View.OnClickListener {
  TODO("Not yet implemented")
}
```

The good news is that IntelliJ and Android Studio will suggest that you can make such a conversion, offering a convert to lambda suggestion. This mechanism works for interfaces created in Java - what does it look like in the case of SAM in Kotlin?

Let's assume that we create our own Actionable interface with one method:

```kotlin
interface Actionable{
  fun performAction()
}
```

In this case, we won't be able to use SAM conversion when creating an Actionable instance:

```kotlin
val action = object : Actionable {
  override fun performAction() {
    //
  }
}
```

However, if we add the keyword fun to our interface, we create a functional interface and we can use simplified syntax:

```kotlin
fun interface Actionable{
  fun performAction()
}

val action = Actionable {
  //
}
```

In this example, by defining **`Actionable`** as a **`fun interface`**, we enable SAM conversions in Kotlin. Now, an instance of **`Actionable`** can be created with a lambda, providing a more concise and readable way to define objects of functional interfaces.