# How to cancel coroutine?

When a coroutine is launched using **`launch`** or **`async`**, it returns a **`Job`** that you can use to manage the lifecycle of the coroutine.

Here's an example of how to cancel a coroutine:

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("Coroutine execution $i")
            delay(500L)
        }
    }

    delay(2500L) // delay a bit
    println("main: Tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")
}

```

In this example, a coroutine is launched that prints a line every 500 milliseconds. After 2.5 seconds, the **`main`** function cancels the coroutine with **`job.cancel()`**.

It's important to note that cancellation is cooperative. A coroutine code has to cooperate to be cancellable. Most of the suspending functions in the Kotlinx Coroutines library, such as **`delay`**, **`yield`**, and all I/O functions in **`Dispatchers.IO`**, are cancellable. If you're making your function or running a computation, you need to check the cancellation status with **`isActive`** property in the **`CoroutineScope`**, or use **`ensureActive()`**, to make the computation cancellable.

Remember, always try to make your coroutines cancellable if they're doing a long-running or potentially infinite operation. It's a good practice to prevent resource leaks in your application.