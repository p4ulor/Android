# What is Kotlin Flow?

Kotlin Flow is a component of the Kotlin Coroutines library that makes handling streams of data, like lists or sequences, much easier and more efficient. **`Flow`** is a type that can emit multiple values sequentially, similar to how a **`Sequence`** operates, but with **`Flow`**, these values can be generated asynchronously.

Flow is built on top of coroutines and can provide multiple values. You can think of a **`Flow`** as an asynchronous version of a **`Sequence`** – a sequence of multiple values, emitted over time. For example, a **`Flow<Int>`** could emit a stream of integers.

In terms of APIs, **`Flow`** is a fairly rich feature. It includes numerous transformation operators such as **`map`**, **`filter`**, **`transform`**, etc. that you would typically find in other stream-based libraries or languages.

Here is a simple example of a **`Flow`**:

```kotlin
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are asynchronously waiting 100 ms
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    // Collect the flow
    simple().collect { value -> println(value) }
}

```

In this example, **`simple()`** is a **`Flow`** that emits integers from 1 to 3, with a delay of 100ms between each. The **`collect`** function is used to collect the values emitted by the Flow. Note that **`collect`** is a suspending function: it waits for the flow to emit all of its values.

Flow also has exceptional support for cancellation and exceptions, making error handling and resource management in a complex stream of data much easier to control.

It's worth noting that flows are cold, meaning that the code inside a flow builder does not run until the flow is collected. This is similar to sequences: the code for a sequence doesn't run until you start iterating over it.