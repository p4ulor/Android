# What is Jetpack Compose and how it’s different from traditional UI system?

Jetpack Compose is a new approach to building user interfaces on Android that differs from the traditional Android UI system in several ways.

First, it's important to understand what the traditional Android UI system is. Also known as the View system, it relies on a hierarchy of view objects that are created, measured, laid out, and drawn in the lifecycle of activities and fragments. These view objects are typically created through XML inflation and are mutable, meaning they can be modified throughout the application's lifecycle.

Jetpack Compose, on the other hand, introduces an entirely new approach. Instead of using XML to define the UI, it uses Kotlin functions called composables. Unlike traditional views that are mutable, composables are immutable. This means that instead of modifying existing views, you create new composables that describe how the user interface should look.

The key difference is that Jetpack Compose focuses on a declarative coding style, as opposed to the imperative style dominant in the traditional UI system. In a declarative approach, you state "what" you want to achieve rather than "how" to do it. This makes the code more concise, readable, and maintainable.

For example, instead of modifying a view by changing its state (e.g., setting text on a TextView), you create a composable that describes how the user interface should look in a given state. When the state changes, Compose automatically "recomposes" the UI by creating new composables that correspond to the new state.