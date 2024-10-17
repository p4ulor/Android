# What’s the difference between remember and by remember?

The difference between **`remember`** and **`by remember`** in Jetpack Compose lies in the syntax and usage: **`remember`** is used directly to retain state across recompositions, while **`by remember`** combines Kotlin's property delegation with **`remember`**, allowing for a more concise syntax and **direct variable-like access** and modification of the remembered mutable state.

### **`remember`**

**`remember`** is a function used in Jetpack Compose to retain state across recompositions. When a composable function recomposes, the values created within it are recalculated. Using **`remember`** allows you to retain the state of a value across these recompositions, ensuring that it persists and maintains its data.

```kotlin
val counter = remember { mutableStateOf(0) }

```

In this example, **`counter`** is a mutable state that will be remembered across recompositions, ensuring that its value persists.

### **`by remember`**

**`by remember`** is a combination of Kotlin's property delegation and Compose's **`remember`**. It allows for more concise syntax when remembering mutable state. The **`by`** keyword in Kotlin is used for property delegation.

```kotlin
var counter by remember { mutableStateOf(0) }

```

In this example, **`counter`** is a mutable state remembered across recompositions, and due to the use of **`by`**, it can be accessed and modified directly as a variable.

### **Conclusion**

- **`remember`** is used to retain state across recompositions in Jetpack Compose.
- **`by remember`** combines **`remember`** with Kotlin's property delegation for a more concise syntax, allowing direct access and modification of the remembered mutable state.