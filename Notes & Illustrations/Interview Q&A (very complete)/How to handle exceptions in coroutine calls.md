# How to handle exceptions in coroutine calls?

**Try/Catch**: You can use the try/catch block in the usual way inside a coroutine. This is the recommended way of handling exceptions for individual coroutines.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        try {
            // code that might throw an exception
        } catch (e: Exception) {
            println("Caught $e")
        }
    }
    job.join()
}

```

In this example, the exception thrown inside the coroutine is caught and handled inside the coroutine itself.

**CoroutineExceptionHandler**: For handling uncaught exceptions, Kotlin provides **`CoroutineExceptionHandler`** which can be specified in the coroutine context.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    val handler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception in CoroutineExceptionHandler")
    }

    val job = launch(handler) {
        throw AssertionError("Something went wrong!")
    }

    job.join()
}

```

In this example, an uncaught exception thrown inside the coroutine is caught by the **`CoroutineExceptionHandler`**.

However, it's important to note that **`CoroutineExceptionHandler`** is used only on coroutines created using **`launch`**. It won't catch exceptions in coroutines created with **`async`**.

**Structured Concurrency**: One of the benefits of structured concurrency is that it provides a way to handle exceptions systematically. When a coroutine throws an unhandled exception, its parent coroutine is cancelled as well. Furthermore, if an unhandled exception is thrown in a scope, it gets propagated to the parent scope. You can handle such exceptions in the outermost scope where the coroutine was launched.