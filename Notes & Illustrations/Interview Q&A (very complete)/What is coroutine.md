# What is coroutine?

A coroutine in Kotlin is a feature that allows writing asynchronous and non-blocking code in a sequential manner. They provide a way to write non-blocking code that's easy to understand and reason about.

Coroutines simplify the way we handle asynchronous programming, such as network calls, database transactions, or any operations that might block the main thread. They transform asynchronous callbacks into sequential code, making it much simpler.

Here's an example of a coroutine in Kotlin:

```kotlin
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}

```

In this example, **`launch`** is used to start a new coroutine. **`delay`** is a special suspending function that doesn't block a thread, but suspends the coroutine and it gets resumed after a specified time.

It's important to note that Kotlin's coroutines are a cooperative version of multitasking, where the control of the CPU is yielded voluntarily by the executing task. This approach allows complex operations and I/O to run in the background while ensuring the UI remains smooth and responsive.

Keep in mind that, while coroutines are a powerful tool for simplifying asynchronous programming, they should be used judiciously and in appropriate contexts.