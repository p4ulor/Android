# What’s the difference between val and const val?

The **`val`** keyword in Kotlin is used to declare a variable as a constant value, meaning its value **cannot be changed during program execution**.

On the other hand, the **`const`** keyword is used to declare a variable as a constant whose value is **calculated at compile-time**. This means that the value of a **`const`** variable must be known and computable during the compilation process.

Here's an example to illustrate the difference between **`val`** and **`const`** in Kotlin:

```kotlin
val PI = 3.14159  // `val` declares a runtime constant
const val VERSION_CODE = 1  // `const` declares a compile-time constant

```

In this example, **`PI`** is declared as a **`val`** and represents a runtime constant. Its value is known at runtime and cannot be changed during program execution. On the other hand, **`VERSION_CODE`** is declared as a **`const`** and represents a compile-time constant. Its value is known and fixed during the compilation process and cannot be changed at runtime.

It's important to note that **`const`** is more restrictive than **`val`**. While **`val`** allows for runtime constants, **`const`** is limited to compile-time constants. Additionally, **`const`** variables can only hold primitive types or **`String`** values, whereas **`val`** variables can hold any type.