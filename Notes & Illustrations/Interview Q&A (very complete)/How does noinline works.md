# How does noinline works?

The **`noinline`** keyword in Kotlin is used in conjunction with lambda expressions. It tells the compiler not to insert the lambda code directly into the place where it was called.

```
fun doSomething(a: Int, b: Int, operation: (Int, Int) -> Int) {
    val result = operation(a, b)
}

doSomething(5, 7, noinline { x, y -> x + y })
```

In this example, the lambda function **`{ x, y -> x + y }`** will not be inserted directly into the place of call (`val result = …`), because it has been marked as **`noinline`**. Instead, it will be called in a normal way, allowing for greater control over when and how it is executed.

This can avoid problems related to code optimization and prevent unwanted effects, such as premature execution of the function or its multiple calls. However, it is worth remembering that using **`noinline`** may also mean lower code efficiency, as it prevents the compiler from inserting the lambda code directly into the call site.