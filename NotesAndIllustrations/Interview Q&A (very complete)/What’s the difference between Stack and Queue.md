# What’s the difference between Stack and Queue?

Stack and queue are two types of data structures that differ in how they store and access elements.

A stack is a data structure where **new elements are added on top of the stack and removed from the top** (last in, first out - **LIFO**). This means that the elements on the stack form a kind of "pyramid," with the topmost element at the top and the elements below it forming subsequent layers of the stack.

A queue is a data structure where **new elements are added at the end of the queue and removed from the front** (first in, first out - **FIFO**). This means that the elements in the queue form a kind of "line," with the first element at the front and the last element at the end.

In summary, the main difference between a stack and a queue lies in the order in which elements are added and removed. Stacks follow the LIFO principle, while queues follow the FIFO principle.

Stacks are commonly used in scenarios where the order of processing is important and where the most recently added element needs to be accessed first. For example, they are useful in evaluating mathematical expressions, implementing function calls in programming languages, and managing program execution flow. Here's an example of using a stack in Kotlin:

```kotlin
val stack = Stack<Int>()
stack.push(1)
stack.push(2)
stack.push(3)

println(stack.pop()) // Output: 3
println(stack.pop()) // Output: 2

```

Queues, on the other hand, are often used when maintaining the order of elements is crucial, such as in task scheduling, message passing, or breadth-first search algorithms. They ensure that the elements are processed in the same order they were added. Here's an example of using a queue in Kotlin:

```kotlin
val queue = LinkedList<String>()
queue.add("Apple")
queue.add("Banana")
queue.add("Orange")

println(queue.remove()) // Output: Apple
println(queue.remove()) // Output: Banana

```

In the stack example, the most recently added element is popped off the stack first, demonstrating the Last-In, First-Out (LIFO) behavior. In the queue example, the elements are removed in the same order they were added, illustrating the First-In, First-Out (FIFO) behavior.