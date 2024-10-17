# What is Runnable?

The **`Runnable`** interface in Java is used to define code that will be executed in a thread. This interface contains one abstract method called **`run`** that contains the code to be executed in the thread. To create a **`Runnable`** object, you need to create a class that implements this interface and implement the **`run`** method containing the code to be executed in the thread.

A simple example of using the **`Runnable`** interface in Java could be to print a message on the screen in a separate thread. We can create a class **`PrintRunnable`** that implements the **`Runnable`** interface and contains a **`run`** method that will print the given message on the screen:

```
public class PrintRunnable implements Runnable {
    private String message;

    public PrintRunnable(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(message);
    }
}

```

Then, we create a **`Thread`** object, passing the **`PrintRunnable`** object with the message as an argument:

```
Thread thread = new Thread(new PrintRunnable("Hello, World!"));

thread.start();

```

Only after executing `thread.start()` the thread will be started and will begin to execute our code from the **`Runnable`** interface, i.e., printing the message "Hello, World!" on the screen.

In summary, we use the **`Runnable`** interface mainly to pass actions to be executed in threads.