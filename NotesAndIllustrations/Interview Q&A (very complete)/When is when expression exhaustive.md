# When when expression is exhaustive?

It's when all possible cases are handled:

When we're operating on a finite set, for example, on enums or sealed classes:

```kotlin
sealed class State{
  object Loading: State()
  data class Items(val content: Any): State()
  object Error: State()
}

fun handleState(state: State){
  val message = when(state){
    is State.Items -> "data is here"
    State.Loading -> "loading..."
    State.Error -> "error occurred"
  }
}

```

Or when we don't explicitly handle all cases, but add else to the expression:

```kotlin
fun handleState(state: State){
  val message = when(state){
    is State.Items -> "data is here"
    else -> "data is not here"
  }
}

```

Or in case of operations on other sets:

```kotlin
fun handleInt(int: Int){
  val grade = when(int){
    in 0..25  -> "bad"
    in 26..69 -> "nice"
    in 70..100 -> "good"
    else -> "you cheated"
  }
}

```

When the **`when`** expression is exhaustive, we can assign its result to a variable.

Being exhaustive, or covering all possible cases, is important because it ensures that our program can handle any input it is given. It provides a form of safety because we know that no matter what happens, there's a plan in place to handle it. With sealed classes, the compiler can enforce exhaustiveness, thus avoiding potential issues in runtime. With regular classes or primitive types, we must manually ensure exhaustiveness by including an **`else`** branch in the **`when`** expression. The **`else`** branch serves as a "catch-all" scenario for any cases we didn't specifically handle.