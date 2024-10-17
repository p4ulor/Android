# How does type variance work?

Variance describes the relationships between type parameters in classes and functions.

To determine variance in generic types, we use the `in` and `out` modifiers:

To understand variance, we will use the interface:

```
interface DataProvider<T> {
  fun provide(): T
}

```

### Covariance - `out`

Let's look at the `useNumberProvider` function - it accepts `DataProvider<Number>` as a parameter. We know that `Double` is a subtype of `Number`, but `DataProvider<Double>` will not be compatible with `DataProvider<Number>`.

```
class Example {

  fun a(dataProvider: DataProvider<Double>){
    useNumberProvider(dataProvider) // does not compile
  }

  fun useNumberProvider(dataProvider: DataProvider<Number>){
    ...
  }
}

```

To reconcile these types, we add covariance to the generic parameter `T` in DataProvider:

```
interface DataProvider<out T> {
  fun provide(): T
}

```

Now our code can look like this:

```
fun useNumberProvider(dataProvider: DataProvider<Number>){
	...
}

useNumberProvider(dataProvider) // compiles

```

We can conduct an additional test:

```
val a = object: DataProvider<Double>{
  override fun provide(): Double {
    return Random.nextDouble()
  }
}

a is DataProvider<Number> // true

```

Fun fact: covariance `out` is implemented in the Kotlin standard library - for example, `Iterator`:

```
public interface Iterable<out T> {
    /**
     * Returns an iterator over the elements of this object.
     */
    public operator fun iterator(): Iterator<T>
}

```

In short: covariance allows a derived class of a given parameter to be inserted into the place of a parametric type.

### Contravariance - `in`

Contravariance works in the opposite direction, i.e. type casting will occur upwards:

```
interface DataAcceptor<in T>{
  fun accept(data: T)
}

val acceptor = object : DataAcceptor<Number>{
  override fun accept(data: Number) {
    println(data) // println 2.0
  }
}

fun useAcceptor(acceptor: DataAcceptor<Double>){
  acceptor.accept(2.0)
}

useAcceptor(acceptor)

```

With contravariance - using the `in` constraint - we can pass its supertype to the `useAcceptor` function that accepts `DataAcceptor<Double>` - an instance of an acceptor parameterized by `Number`.

Alright, so how do we deal with variance and contravariance?

The best method is to check its limitations in combat. I also recommend checking out [an illustrated guide to covariance and contravariance from the typealias.com blog](https://typealias.com/guides/illustrated-guide-covariance-contravariance/).