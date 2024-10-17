# What is higher-order function?

It's a function... that returns or accepts other functions as an argument!

Here's an Android example; We have a certain **`Router`**, which is tasked, among other things, with displaying a dialog to confirm an action. From our ViewModel/Presenter/any other layer, we call the **`openConfirmationDialog`** function and **intercept the click event** as follows:

```kotlin
fun doComplexThings(){
  openConfirmationDialog {
    useCase.execute()
      ...
  }
}

```

```kotlin
fun openConfirmationDialog(onConfirm: ()->Unit){
  // use fragment manager to display dialog
  // bind "onConfirm" to "ok" button click
  onConfirm()
}

```

This is an example of a higher-order function that accepts a function. But how can a higher-order function that returns a function look like?

```kotlin
class CalendarMappings {
  val format = SimpleDateFormat()
  fun calendarMapping(): (String) -> Date {
    return {
      format.parse(it)
    }
  }
}

```

In this case, the **`calendarMapping()`** function returns a **function that maps a String to a Date** using SimpleDateFormat. Can this be written in a different way? Of course. For instance, in the **`CalendarMappings`** class, we can create a function that takes a String and returns a Date. However, with higher-order functions notation, we can call a function like this:

```kotlin
fun useCase(){
  val calendarMappings = CalendarMappings()

  val date: Date = "2020-06-09"
    .let(calendarMappings.calendarMapping())
}

```

Two things to remember. A higher-order function is a function that...

- accepts other functions as arguments
- returns functions