# On which thread coroutines run?

Coroutines in Kotlin can run on different threads, and you can control which thread a coroutine runs on by specifying a **`CoroutineDispatcher`** when launching the coroutine.

Here are the different types of dispatchers:

1. **Main (Dispatchers.Main)**: This dispatcher confines the coroutine to the Main Thread. It's mostly used for UI related tasks in an Android app, such as updating the UI, observing LiveData, etc.
2. **IO (Dispatchers.IO)**: This dispatcher is optimized for disk and network IO off the main thread. It's used for tasks such as database operations, reading/writing files, networking tasks, etc.
3. **Default (Dispatchers.Default)**: This dispatcher is optimized for CPU-intensive tasks and utilizes a shared pool of threads on the JVM. It's used for tasks such as sorting large lists, complex calculations, etc.
4. **Unconfined (Dispatchers.Unconfined)**: This dispatcher is not confined to any specific thread. It executes the initial continuation of a coroutine in the current call-frame and lets the coroutine resume in whatever thread that is used by the corresponding suspending function, without mandating any specific threading policy. It's a highly advanced option that's not typically used unless you really understand its behavior and have a specific use case for it.
5. **New Single Thread (Dispatchers.newSingleThreadContext)**: This dispatcher creates a new thread for the coroutine to run. Each new coroutine will get a new thread.