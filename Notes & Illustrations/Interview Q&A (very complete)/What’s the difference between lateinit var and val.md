# What’s the difference between lateinit var and val by lazy{}?

With `lateinit var,` we must assign a value directly before using the variable.

The value of `val by lazy` will be evaluated only when we use that value.

Firstly, let's understand lateinit var.

It tells the compiler that the variable will be initialized later.

However, it needs to be assigned a value before you use it, otherwise, it throws an `UninitializedPropertyAccessException`.

```kotlin
class Example {
	lateinit var a: String

	fun test1(){
		print(a) // kotlin.UninitializedPropertyAccessException
	}
	
	fun test2(){
		a = "Something"
		print(a) // "Something"
	}
}
```

`lateinit var` is great for variables that:

- cannot be initialized in the constructor
- are assured to have a value before we use them.

For example, in Android, we often use it for views that are inflated after the creation of an activity or fragment.

Now, let's talk about `val by lazy{}`

This syntax in Kotlin is used to declare a variable as lazy.

What does it mean? The variable will only be evaluated or initialized when we use it for the first time.

```kotlin
class Example {
	val b: String by lazy {
		"Other thing"
	}
	
	fun test(){
		print(b) // "Other thing"
	}
}
```

`val by lazy{}` is often used when:

- the initialization of a variable is expensive
- we want to defer it until necessary

This way, we can optimize the runtime performance by avoiding unnecessary computation.

`lateinit var` and `val by lazy{}` are both used to handle late initialization in Kotlin.

The key difference is in the way they behave: one throws an exception if not initialized before use, while the other initializes on first use.

```kotlin
class Example {
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