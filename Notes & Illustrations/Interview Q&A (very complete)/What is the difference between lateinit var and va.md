# What is the difference between lateinit var and val by lazy{}?

We need to directly assign a value to lateinit var before we use the variable.
The value of val by lazy will be evaluated only when we use the value.

Here's a Kotlin class as an example:

```kotlin
class Example{
    lateinit var a: String

    val b: String by lazy {
        "Other thing"
    }
    
    fun c(){
        print(b) // "Other thing"
        print(a) // kotlin.UninitializedPropertyAccessException
    }

    fun d(){
        print(b) // "Other thing"
        a = "Something"
        print(a) // "Something"
    }
}

```

In this class, **`a`** is a **`lateinit var`** which means it is a non-null type and has to be initialized before its first access, else it throws **`kotlin.UninitializedPropertyAccessException`**.

On the other hand, **`b`** is a **`val`** with a **`by lazy`** delegate. It gets its value from the specified initialization block (here **`"Other thing"`**) and this initialization happens only when the variable is accessed for the first time. Subsequent accesses return the same value without re-evaluating the initialization block.