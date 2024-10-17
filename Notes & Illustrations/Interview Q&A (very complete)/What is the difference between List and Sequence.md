# What is the difference between List and Sequence?

Operations performed on collections, including lists, are evaluated eagerly, meaning that every collection transformation (map, filter) is performed on the entire collection, and the entire newly created collection is returned.

**Sequence** - operations on sequences are evaluated lazily, meaning that they are only performed when the operation is actually needed. Each transformation on a sequence occurs element by element, and a new collection is not created at each step.

A sequence is not a collection - if we want to extract the result of operations on sequences, we need to use a terminal operation, such as `toList()`.

It is possible to optimize complex collection operations using the `asSequence()` extension:

```
val numbers = (0..9999)

numbers.**asSequence()**
  .map { it.plus(2) }
  .filter { it % 2 == 0 }
  .map { it + 1.2 }
  .onEach { println(it) }
  .toList()

```

[Kotlin Collections vs Sequences in just 5 minutes](https://blog.kotlin-academy.com/kotlin-collections-vs-sequences-in-just-5minutes-70a3c3ec94a8)