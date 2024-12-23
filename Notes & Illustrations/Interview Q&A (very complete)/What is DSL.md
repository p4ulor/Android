# What is DSL?

Domain Specific Language, or DSL, is a language that is specific to a particular domain. This can be understood as a set of functionalities tailored to solve a specific class of problems. Let's take Gradle DSL, which is a Groovy language dialect used to define project configuration scripts, as an example:

Instead of referring to `dependencies` in the `project` variable in the build script and directly calling the `add()` method with the appropriate arguments:

```
project.dependencies.add("implementation", "androidx.appcompat:appcompat:1.1.0")

```

We use a DSL that allows us to define project dependencies in a more readable way:

```
dependencies {
  implementation "androidx.appcompat:appcompat:1.1.0"
}

```

Another example of DSL in Android? The entire Jetpack Compose library is based on a DSL - in this case, one used to build user interfaces.