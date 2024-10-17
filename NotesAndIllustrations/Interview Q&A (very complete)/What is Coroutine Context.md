# What is Coroutine Context?

Coroutine Context in Kotlin is a set of various elements that define the behavior of a coroutine. It's a collection of rules and configurations which are used when the coroutine is created and while it's executing.

In a Coroutine Context, you can specify elements such as:

1. **Job**: This represents the lifecycle of the coroutine, and can be used to cancel the coroutine. All coroutines have a Job associated with them, and a parent coroutine can cancel all of its children by cancelling its own Job.
2. **Dispatcher**: This determines the thread or threads on which the coroutine runs. For example, you might use **`Dispatchers.Main`** to run a coroutine on the main thread, or **`Dispatchers.IO`** to run a coroutine on a thread that's optimized for I/O work.
3. **CoroutineExceptionHandler**: This can catch unhandled exceptions thrown by coroutines.

Here's an example:

```kotlin
import kotlinx.coroutines.*

fun main() {
    val job = Job()
    val dispatcher = Dispatchers.IO
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        println("Caught $exception")
    }

    val coroutineContext: CoroutineContext = job + dispatcher + exceptionHandler

    GlobalScope.launch(coroutineContext) {
        // Coroutine code...
    }
}

```

In this example, the **`coroutineContext`** is composed of a **`Job`**, a **`Dispatcher`**, and an **`ExceptionHandler`**. The coroutine launched with **`GlobalScope.launch(coroutineContext)`** will use these configurations.