# Can an enum class implement an interface?

Yes, it can implement an interface - but it cannot inherit from classes. Here's an example of an enum class implementing an interface:

```kotlin
interface SomeInterface{
  fun doWork()
}

enum class SomeWorker: SomeInterface{
  A {
    override fun doWork() {
      TODO("Not yet implemented")
    }
  }, 
  B {
    override fun doWork() {
      TODO("Not yet implemented")
    }
  }
}
```

In this example, **`SomeWorker`** is an enum class that implements **`SomeInterface`**. Each enum constant **`A`** and **`B`** provides its own implementation of the **`doWork`** function declared in the interface. Although an enum class can implement an interface, it cannot inherit from another class because every enum in Kotlin implicitly inherits from **`Enum`** (which is a special class in Kotlin).