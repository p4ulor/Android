# How to use synchronized in Kotlin?

To use **`synchronized`** in Kotlin, you can apply it to a block of code using the **`synchronized`** keyword followed by the object you want to synchronize on. The synchronized block ensures that only one thread can access the block at a time, providing thread-safety for the shared resource.

Here's an example of using **`synchronized`** in Kotlin:

```kotlin
class Counter {
    private var count = 0

    fun increment() {
        synchronized(this) {
            count++
        }
    }

    fun getCount(): Int {
        synchronized(this) {
            return count
        }
    }
}

fun main() {
    val counter = Counter()

    // Multiple threads incrementing the counter
    val thread1 = Thread { repeat(1000) { counter.increment() } }
    val thread2 = Thread { repeat(1000) { counter.increment() } }
    thread1.start()
    thread2.start()
    thread1.join()
    thread2.join()

    // Print the final count
    println("Final count: ${counter.getCount()}")
}

```

In this example, the **`Counter`** class maintains a private count variable. The **`increment()`** and **`getCount()`** methods are synchronized using the **`synchronized`** keyword followed by the **`this`** reference, which refers to the instance of the **`Counter`** class.

Two threads are created that concurrently increment the counter using the **`increment()`** method. By applying synchronization to the critical sections of the code, we ensure that only one thread can access the block at a time, preventing race conditions and maintaining the correctness of the count.

Finally, the **`getCount()`** method is also synchronized to safely retrieve the final count value.