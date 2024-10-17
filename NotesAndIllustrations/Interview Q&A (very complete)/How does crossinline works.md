# How does crossinline works?

The **`crossinline`** keyword in Kotlin is used in conjunction with lambda expressions. It informs the compiler that a given function cannot be called with a **`return`** statement.

```kotlin
fun doSomething(operation: () -> Unit) {
    // Do something
    operation()
    // Do something else
}

// The lambda passed to "operation" cannot contain a "return" statement
doSomething(crossinline {
    // Code here cannot contain a "return" statement
})

```

By using **`crossinline`**, we restrict the lambda expression from containing a **`return`** statement. This is because lambdas that are passed as parameters to functions can potentially be executed at a later point in the program flow, making it ambiguous or problematic to handle **`return`** statements within them. The **`crossinline`** keyword ensures that the lambda is inline with the calling code and doesn't disrupt the flow of execution.

You can read more about the **`crossinline`** keyword and its usage in the following article: [**Inline and Crossinline**](https://medium.com/tompee/idiomatic-kotlin-noinline-and-crossinline-e51014408ff0)