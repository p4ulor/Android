# How does tailrec work?

A function marked as **`tailrec`** (if it meets the requirements) will be transformed by the compiler into a version based on loops.

A tail recursive function is a special kind of recursive function where the last operation of the function is the recursive call. This property allows the compiler to optimize the recursion to a simple loop, preventing the stack overflow that might occur in traditional recursion.

For instance, let's look at the factorial calculation:

```kotlin
fun factorial(n: Int): Int {
    return if (n == 1) n else n * factorial(n - 1)
}
```

The above function is recursive but not tail recursive because the last operation is not the recursive call, but the multiplication operation.

However, if we refactor the function to make the recursive call as the last operation, it becomes a tail-recursive function:

```kotlin
tailrec fun factorial(n: Int, accumulator: Int = 1): Int {
    return if (n == 1) accumulator else factorial(n - 1, accumulator * n)
}
```

In this case, the multiplication is carried out before making the recursive call, making it tail recursive. The **`tailrec`** keyword tells the Kotlin compiler to optimize this recursion to a loop, resulting in a more efficient code.

Read more about Kotlin tailrec in [**Jorge Castillo's blog post**](https://jorgecastillo.dev/tail-recursion-and-how-to-use-it-in-kotlin).