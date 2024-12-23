# Describe let, run, apply, also functions

In Kotlin, **`let`**, **`apply`**, **`run`**, and **`also`** are part of the standard library functions that operate on the context object in a very convenient way. These are called scope functions. Here is a brief description of each:

1. **`let`**: The **`let`** function is used to avoid checking nullability of values. It executes a block of code only when the object reference isn’t null and returns the last expression in the lambda. It also allows renaming the object reference within the scope of the function.

```kotlin
val listWithNulls: List<String?> = listOf("Kotlin", null)
for (item in listWithNulls) {
   item?.let { println(it) }  // prints Kotlin and ignores null
}

```

1. **`apply`**: The **`apply`** function is used when you need to make changes on an object and then return that object. It's particularly useful when configuring objects, as it lets you perform various operations on an object and then return the object itself.

```kotlin
val myArray = ArrayList<String>().apply {
    add("Kotlin")
    add("Java")
    add("Python")
} // Now myArray contains ["Kotlin", "Java", "Python"]

```

1. **`run`**: The **`run`** function is similar to **`apply`**, but it doesn't return the object. Instead, it returns the result of the lambda function provided to it.

```kotlin
val text: String = "Hello, Kotlin"
val result = text.run {
    println(this)  // Prints "Hello, Kotlin"
    length   // This value is returned
}  // result will be 13, which is the length of "Hello, Kotlin"

```

1. **`also`**: The **`also`** function is very similar to **`let`**, but the difference is that it returns the context object. The object reference in the lambda is named 'it' unless declared otherwise.

```kotlin
val numbers = mutableListOf("one", "two", "three")
numbers.also { it.add("four") }
println(numbers)  // prints [one, two, three, four]

```

In these examples, the lambda argument is the object the function is invoked upon. Depending on the function, the object is either the lambda receiver (**`this`**) as in **`apply`** and **`run`**, or the lambda argument (**`it`**) as in **`let`** and **`also`**.