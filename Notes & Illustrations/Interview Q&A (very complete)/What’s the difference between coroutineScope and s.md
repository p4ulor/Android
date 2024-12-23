# What’s the difference between coroutineScope and supervisorScope?

The **`coroutineScope`** and **`supervisorScope`** are both Kotlin scope functions that control the lifetime of coroutines. However, they handle exceptions and child coroutine failures differently:

1. **`coroutineScope`**: When a child coroutine fails (throws an exception), **`coroutineScope`** will cancel all the other child coroutines and it will also re-throw the exception. This is often used when it's important that all child operations either complete successfully or fail altogether.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    try {
        coroutineScope {
            launch {
                throw Exception("Failed child")
            }
            launch {
                delay(1000) // will get cancelled due to sibling failure
                println("This will not be printed!")
            }
        }
    } catch (e: Exception) {
        println(e.message) // Prints "Failed child"
    }
}

```

1. **`supervisorScope`**: With **`supervisorScope`**, if a child coroutine fails, it does not cancel the other child coroutines. Each child is treated independently; failure of one does not imply the failure of the others. **`supervisorScope`** is useful when you have a group of largely independent tasks and want to make sure they all have the chance to complete, regardless of the success or failure of the others.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    try {
        supervisorScope {
            launch {
                throw Exception("Failed child")
            }
            launch {
                delay(1000) // continues running despite sibling failure
                println("This will be printed!")
            }
        }
    } catch (e: Exception) {
        println(e.message) // Prints "Failed child"
    }
}

```

Both scopes have their use cases and their choice depends on how you want to handle failures in your coroutines. While **`coroutineScope`** promotes structured concurrency and failure propagation, **`supervisorScope`** allows for more independence and resilience among the child coroutines.