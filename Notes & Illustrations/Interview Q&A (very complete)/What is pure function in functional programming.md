# What is pure function in functional programming?

A pure function in functional programming is a function that meets the following criteria:

- Returns **the same value for a given set of arguments**. In other words, for a given argument, the function always returns the same value, **regardless of the context in which it was called**.
- Has **no side effects**. The function **does not change external state** and does not modify arguments in an implicit way.

An example of a pure function in Kotlin could be a function that calculates the product:

```kotlin
fun multiply(a: Int, b: Int): Int {
    return a * b
}

```

This function always returns the same value for a given set of arguments (numbers **`a`** and **`b`**), and its invocation has no side effects - it does not change external state and does not modify arguments in an implicit way. Therefore, it can be considered a pure function.