# What’s the difference between Thread and a Coroutine?

Coroutine in Kotlin is a mechanism that allows for **asynchronous execution of code**. Coroutines allow for the execution of multiple tasks at the same time, but unlike threads, **they do not require multiple processor cores**, making them less burdensome for the system.

A thread is a mechanism that allows for parallel execution of code. **Each thread is executed on a separate processor core**, allowing many tasks to be executed simultaneously. If the number of threads exceeds the number of available cores, threads will "share" cores between themselves and execute on them in the order in which they were created.

Coroutines, on the other hand, allow for **"simulating" concurrency by switching between different tasks**. This does not require multiple processor cores and is less burdensome for the system.

In summary, the main difference between coroutines and threads is that **coroutines allow for asynchronous execution of code without the need to create multiple threads**, making them less burdensome for the system.

[https://piotrminkowski.com/2020/06/23/kotlin-coroutines-vs-java-threads/](https://piotrminkowski.com/2020/06/23/kotlin-coroutines-vs-java-threads/)