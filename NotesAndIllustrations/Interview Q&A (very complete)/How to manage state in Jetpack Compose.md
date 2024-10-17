# How to manage state in Jetpack Compose?

Managing state in Jetpack Compose differs from the traditional Android approach. In Compose, we don't tell views what to do; instead, we describe how the UI should look in a given state. It's like creating a "picture" of our user interface, and Compose ensures that this picture is always up to date.

The primary tool for managing state in Compose is the State object. The value stored in a State object can be read by a composable function, and when that value changes, Compose automatically triggers recomposition to reflect those changes in the user interface.

That's why in Jetpack Compose, we often talk about "lifting state up." This means that state that affects multiple composables is stored in one place, typically in the composable higher up in the hierarchy. This way, state changes are propagated to all the composables that depend on that state, and Compose takes care of making those changes visible to the user.

For example, consider a movie list in a movie browsing application. The state in this case would be the list of movies. This list is "lifted up" to the composable responsible for displaying the entire screen. When the movie list changes (e.g., when the user adds a new movie), Compose triggers recomposition to make those changes visible on the screen.

In Jetpack Compose, state management is not limited to just State objects. We can also leverage tools provided by the Kotlin Coroutines library, such as StateFlow and SharedFlow.

StateFlow is a type of Flow that represents state. Each new value emitted by a StateFlow triggers recomposition in the composable functions that observe it. This is especially useful when dealing with complex state that is used by multiple different composables.

For example, if we have application state represented as StateFlow in a ViewModel, we can observe it in a composable function using the collectAsState() function. When the value of the StateFlow changes, Compose automatically triggers recomposition, allowing for immediate reflection of state changes in the user interface.