# What’s the difference between checked and unchecked exception?

### **Checked exceptions must be handled in the code**

otherwise, the compiler won't let us pass.

```java
public void throwCheckedException() throws Exception {
    throw new Exception();
}

```

If we throw a checked exception in a method, we have to add **`throws`** to its signature.

How does the usage of such a method look like?

```java
void catchIt(){
    try {
      throwCheckedException();
    } catch (Exception e) {
      e.printStackTrace();
    }
}

```

We use the try-catch block.

- Checked exceptions are used to control the behavior of the program
- We have to handle them

**Example of a checked exception** - IOException, which may occur when trying to create/read files:

```java
void createFile(){
  try {
    File.createTempFile("tmp", null);
  } catch (IOException e) {
    e.printStackTrace();
  }
}

```

### **Unchecked exceptions occur during the program's operation.**

```java
public void throwUncheckedException(){
  throw new RuntimeException();
}

void doSomething(){
  throwUncheckedException();
}

```

We don't "manually" catch them, but crash the entire application instead.

**Example of an unchecked exception** - IndexOutOfBoundsException, when we try to access a collection element with an index that does not exist in a given list.

```java
void accessList(){
  List<String> list = Arrays.asList("a", "b");

  String c = list.get(3); // IndexOutOfBoundsException
}

```