# What is external keyword in Kotlin?

The **`external`** keyword is used to mark declarations as implemented "not in Kotlin" - that is, for example, in JavaScript or C++.

[**Use JavaScript code from Kotlin**](https://kotlinlang.org/docs/js-interop.html)

[data:image/svg+xml,%3csvg%20xmlns=%27http://www.w3.org/2000/svg%27%20version=%271.1%27%20width=%2738%27%20height=%2738%27/%3e](data:image/svg+xml,%3csvg%20xmlns=%27http://www.w3.org/2000/svg%27%20version=%271.1%27%20width=%2738%27%20height=%2738%27/%3e)

Here's an example of how to use **`external`** in Kotlin to call JavaScript code:

```kotlin
external fun alert(message: Any?): Unit

fun main() {
    alert("Hello, JavaScript!")
}

```

In this example, **`alert`** is a JavaScript function that we're calling from Kotlin. It's declared as **`external`** in Kotlin, meaning it's implemented elsewhere, specifically in JavaScript. This function takes a parameter, **`message`**, of any type and returns no meaningful result (**`Unit`**).

When you run this Kotlin code in a JavaScript environment, it will call the JavaScript **`alert`** function, causing a dialog box to appear with the message "Hello, JavaScript!". The actual implementation of the **`alert`** function is provided by the JavaScript environment, not by the Kotlin code.

This is a simple example, but **`external`** declarations can be used to interact with more complex JavaScript APIs, too. Keep in mind that all **`external`** declarations in Kotlin/JS have to correspond to actual existing declarations in JavaScript.