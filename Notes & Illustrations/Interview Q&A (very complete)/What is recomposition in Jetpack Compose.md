# What is recomposition in Jetpack Compose?

Recomposition in Jetpack Compose refers to the process of reflecting state changes in the user interface. It's as if Compose has its own "language" to describe how the UI should look in a given state, and recomposition acts as the "translator" that translates those descriptions into actual views.

While in the traditional Android UI system, you have to manually manage view updates, Jetpack Compose automates this process. When the application state changes, Compose triggers recomposition, which means re-executing the composable functions that may have changed in response to the state change.

It's a bit like when you tell an actor to play a new role. You don't tell them step by step how to do it. Instead, you give them a script (the composable) and they act out the new role (create a new user interface) based on that script. When the script changes (state changes), the actor adjusts their performance (recomposition).

Recomposition is typically triggered by a change in a State<T> object. Compose tracks these objects and re-runs all the composable functions that read that particular State<T>, as well as any other composables that cannot be skipped.

Understanding when recomposition occurs is crucial for effectively utilizing Jetpack Compose. It enables the creation of applications that are more responsive, easier to maintain, and aligned with the Kotlin philosophy—concise, safe, and interoperable.