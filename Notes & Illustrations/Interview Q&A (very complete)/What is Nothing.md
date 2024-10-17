# What is Nothing?

**`Nothing`** is a special type that you can use to represent a non-existent value. A function of type **`Nothing`** returns nothing - it throws an exception.

Example of a **`Nothing`** function: TODO() function:

```kotlin
/**
 * Always throws [NotImplementedError] stating that operation is not implemented.
 */

@kotlin.internal.InlineOnly
public inline fun TODO(): Nothing = throw NotImplementedError()

```

The Nothing type can be useful when modeling generic types - [**check out the article at Kt. Academy**](https://blog.kotlin-academy.com/kotlins-nothing-its-usefulness-in-generics-5076a6a457f7)

One significant use case for **`Nothing`** type is in control flow. Kotlin's type inference can use **`Nothing`** to determine if a statement is unreachable. If a function has a **`Nothing`** return type, the compiler knows that the function will never successfully complete. Therefore, any code written after calling that function is unreachable, and hence, the compiler will mark it as an error. For example:

```kotlin
fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}

fun main() {
    val x: String? = null
    val y: String = x ?: fail("x was null") // If x is null, the fail() function will throw an exception
    print(y) // This line is only reachable if x is not null
}

```

In the above example, the **`fail()`** function has a return type of **`Nothing`**. When it is used in the Elvis operator (**`?:`**), if **`x`** is null, it will call the **`fail()`** function, which always throws an exception. The **`print(y)`** statement is only reachable if **`x`** is not null, as inferred by the Kotlin compiler.

Moreover, **`Nothing`** is a subtype of all types. It means you can use **`Nothing`** where any other type is required, without any type mismatch. This feature comes in handy especially in case of working with generic classes or functions, where the type parameter could be any possible type. For instance, in a generic **`Result`** class, you could use **`Nothing`** to denote an unsuccessful operation, where there's no meaningful value to return. This way, you get more type-safety and can avoid nullable types or exceptions.