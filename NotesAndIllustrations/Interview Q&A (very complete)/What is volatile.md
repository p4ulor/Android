# What is volatile?

The **`volatile`** keyword in Java is used to mark variables that can be **shared between multiple threads** and can be modified during program execution. **`volatile`** variables are read and written directly to memory, bypassing the thread's cache, ensuring that all threads see the most up-to-date value of the variable.

💡 In Kotlin, we do not use the `volatile` keyword, but rather the `@Volatile` annotation.

In multithreaded environments, using the **`volatile`** keyword ensures that changes made to a volatile variable are immediately visible to other threads. It establishes a happens-before relationship, meaning that changes made by one thread are guaranteed to be visible to other threads accessing the same volatile variable. This can be useful in scenarios where multiple threads need to access and modify a shared variable without running into issues like stale values or inconsistent reads.

Here's an example demonstrating the use of the **`volatile`** keyword in Java:

```java
class SharedData {
    volatile int counter = 0;
}

class MyThread extends Thread {
    private final SharedData sharedData;

    public MyThread(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            sharedData.counter++; // Increment the counter
            System.out.println(sharedData.counter);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread thread1 = new MyThread(sharedData);
        Thread thread2 = new MyThread(sharedData);
        thread1.start();
        thread2.start();
    }
}

```

In this example, we have a **`SharedData`** class with a **`volatile`** counter variable. Two threads are created, and each thread increments and prints the value of the counter variable. By using **`volatile`**, we ensure that changes made to the counter variable by one thread are immediately visible to the other thread, allowing them to synchronize their access to the shared variable correctly.