# How does final modifier work?

The **`final`** keyword in Java is used to denote classes, methods, and variables:

### **Class**

A **`final class`** is a class that cannot be inherited from.

Example:

```java
class StuffDoer {

}

class RandomStuffDoer extends StuffDoer{

}
```

The **`StuffDoer`** class does not have a **`final`** modifier - the **`RandomStuffDoer`** class can successfully extend it.

```java
final class StuffMaker{

}

~~class RandomStuffMaker extends StuffMaker{

}~~
```

The **`StuffMaker`** class is marked as **`final`** - nothing can inherit from it.

### **Method**

A **`final`** method is one that cannot be overridden in a derived class.

Example:

```java
class StuffDoer {
   void doStuff(){
      System.out.println("StuffDoer.doStuff");
   }
   final void createStuff(){
      System.out.println("StuffDoer.createStuff");
   }
}

class RandomStuffDoer extends StuffDoer{
   @Override
   void doStuff() {
      super.doStuff();
   }

   ~~@Override
   void createStuff() {
      super.createStuff();
   }~~
}

```

The **`doStuff`** method in the **`StuffDoer`** class does not have a **`final`** modifier - this method can be overridden in the **`RandomStuffDoer`** class. On the other hand, the **`createStuff`** method is marked as **`final`** - an attempt to override it in the derived class will fail - the compiler will not let us through.

### **Variable**

The **`final`** behavior looks a bit different for variables. The **`final`** keyword marks those class properties that are initialized once and cannot be modified later either within the class or by a setter.

```java
class DataHolder{
   private final String id;
   private final String content;
   private Integer counter;

   DataHolder(String id, String content, Integer counter) {
      this.id = id;
      this.content = content;
      this.counter = counter;
   }

   public void setCounter(Integer counter) {
      this.counter = counter;
   }
}

```

**`id`** and **`content`** are **`final`** – their values are assigned in the constructor or at the field declaration in the class. **`counter`** does not have such a limitation - we can assign a value to it both in the constructor and with the **`setCounter`** method.

### **How does `final` look like in Kotlin?**

The **`final`** behavior is default - if we want to inherit from a Kotlin class, or override its method, we need to add **`open`** to its signature.

However, in the case of variables, Kotlin uses **`val`** and **`var`**.

**`final String id`** ~ **`val id: String`**

**`Integer counter`** ~ **`var counter: Int`**