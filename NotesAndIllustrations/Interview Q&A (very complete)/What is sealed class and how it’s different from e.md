# What is sealed class and how it’s different from enum?

A sealed class is an abstract class whose all subclasses must be specified at compile time.

Some call sealed class an "enum on steroids". What does that mean? Because there is a finite set of sealed class subclasses, a Kotlin switch, or when made on its instance, will be exhaustive - sufficient.

### Enum

```kotlin
enum class Placement {
    TOP, BOTTOM, START, END
}

fun doOnPlacement(placement: Placement) {
    val output = when (placement) {
        Placement.TOP -> TODO()
        Placement.BOTTOM -> TODO()
        Placement.START -> TODO()
        Placement.END -> TODO()
    }
}

```

An else statement is not needed in the when expression - all cases are considered.

### Abstract class

```kotlin
abstract class Animal {
    abstract fun makeSound()
}

class Dog : Animal() {
    override fun makeSound() {
        println("Hau hau")
    }
}

class Cat : Animal() {
    override fun makeSound() {
        println("Miau miau")
    }
}

fun doOnAnimal(animal: Animal) {
    val output = when (animal) {
        is Dog -> TODO()
        is Cat -> TODO()
        else -> {}
    }
}

```

An else statement is needed in the when expression to make it exhaustive.

### Sealed class

Example for modeling screen state:

```kotlin
sealed class ViewState {
    object Loading : ViewState()
    data class Result(val elements: List<Any>) : ViewState()
    sealed class Error : ViewState() {
        data class ConnectionError(val message: String) : Error()
        object GenericError : Error()
    }
}

```

Sealed classes are most often created as inner classes.

In this case, the when on ViewState will take the form:

```kotlin
fun render(viewState: ViewState) {
    when (viewState) {
        ViewState.Loading -> TODO()
        is ViewState.Result -> TODO()
        is ViewState.Error.ConnectionError -> TODO()
        ViewState.Error.GenericError -> TODO()
    }
}

```

Or with an additional when on ViewState.Error:

```kotlin
fun render(viewState: ViewState) {
    when (viewState) {
        ViewState.Loading -> TODO()
        is ViewState.Result -> TODO()
        is ViewState.Error -> {
            when (viewState) {
                is ViewState.Error.ConnectionError -> TODO()
                ViewState.Error.GenericError -> TODO()
            }
        }
    }
}

```

If necessary, a method or abstract method can be added to the sealed class:

```kotlin
sealed class Error {
    abstract fun createReadableMessage()
    data class ConnectionError(val message: String) : Error() {
        override fun createReadableMessage() {
            TODO("Not yet implemented")
        }
    }
    object GenericError : Error() {
        override fun createReadableMessage() {
            TODO("Not yet implemented")
        }
    }
}

```

What to remember?

- A subclass of a sealed class can be an ordinary class, data class, object, abstract class, or even another sealed class!
- An enum class cannot be a subclass of a sealed class because an enum cannot inherit from classes.
- A sealed class is useful for modeling state - it allows more information to be passed than an enum.
- A sealed class can have methods and abstract methods.

In addition, Kotlin version 1.5 introduced the sealed interface structure.