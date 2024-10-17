# What is GlobalScope?

**`GlobalScope`** in Kotlin is a coroutine scope that's tied to the lifetime of the whole application. It means any **coroutine launched in this scope is active as long as the application is running**, or until you cancel the coroutine's job explicitly.

Coroutines launched using **`GlobalScope`** are independent, meaning they are not tied to any lifecycle, and will run until their completion even if the part of the application that started them is no longer running. This can lead to potential resource leaks if not handled properly.

Here's an example of usage:

```kotlin
import kotlinx.coroutines.*

fun main() {
    GlobalScope.launch {
        // Coroutine code...
    }
    // Rest of the application code...
}

```

While **`GlobalScope`** is available, its usage should be limited. It's generally better to use structured concurrency and launch coroutines in specific scopes tied to the lifecycle of application parts, such as activities or view models. This way, the running coroutines will be automatically cancelled when they are no longer needed, minimizing the risk of resource leaks.

While **`GlobalScope`** can be useful for long-running operations that should continue even if the rest of the application stops, it must be used judiciously and carefully to avoid unintended consequences. Remember that **structured concurrency, not global scope, should be the default in most situations**.