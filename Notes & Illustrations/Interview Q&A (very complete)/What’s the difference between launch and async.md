# What’s the difference between launch and async?

**`launch`** and **`async`** are both coroutine builders in Kotlin, but they serve different purposes and return different types:

1. **`launch`**: This coroutine builder is used when we don't need any result to be returned from the coroutine. It just fires and forgets. The **`launch`** coroutine builder returns a **`Job`** that can be used to manage the coroutine's lifecycle, such as cancelling it. The **`Job`** doesn't hold any meaningful result, it's simply a handle to the launched coroutine.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = launch {
        delay(1000L)
        println("World!")
    }
    println("Hello,")
    job.join() // Wait until the coroutine completes
}

```

1. **`async`**: This coroutine builder is used when we need to compute some result. It creates a coroutine and returns a **`Deferred<T>`**, which is a light-weight non-blocking future that represents a promise to deliver a result later. You can await on a **`Deferred`** to get its eventual result, but **`Deferred`** is also a **`Job`**, so you can cancel it if needed.

```kotlin
import kotlinx.coroutines.*

fun main() = runBlocking {
    val deferred = async {
        delay(1000L)
        "World!"
    }
    println("Hello, ${deferred.await()}")
}

```

In the **`async`** example, **`async`** is used to create a coroutine that computes a result (**`"World!"`**). We then use **`deferred.await()`** to get the result of the coroutine.

You would typically use **`launch`** when you have a fire-and-forget operation that does some work and doesn't need to return anything, while **`async`** is used when you have an asynchronous computation that needs to produce a result. 

Remember to choose the right coroutine builder based on the use case at hand to correctly structure your asynchronous code in Kotlin.