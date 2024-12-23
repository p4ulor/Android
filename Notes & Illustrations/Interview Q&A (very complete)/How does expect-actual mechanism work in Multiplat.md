# How does expect-actual mechanism work in Multiplatform?

We can imagine it as a form of abstraction, similar to interfaces, but operating at a higher level of abstraction 🙂

The *expect-actual* mechanism allows delegating the implementation from the common/shared code to platform-specific code.

**Expect – will be the interface declaration:**

```kotlin
// commonMain
expect class Platform() {
    val platform: String
}
```

**Actual will be its implementation on a given platform:**

```kotlin
// androidMain
actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}
```

```kotlin
// iosMain
actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}
```

Note - **`actual`** and **`expect`** are keywords in Kotlin – they are reserved even if you don't have multiplatform code.

The *expect-actual* mechanism is part of Kotlin's multiplatform programming model, enabling you to write platform-agnostic code in shared modules, while delegating platform-specific functionalities to respective platform modules. This is one of the ways in which Kotlin's design lends itself to reusability and modularity of code, allowing you to organize your codebase in a way that makes it easier to maintain and scale for multiple platforms. It also enhances readability and maintainability of code, as the division of responsibilities between common code and platform-specific code is clear and explicit.