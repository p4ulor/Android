# How does Hashmap work?

A HashMap in Java is an implementation of the Map interface that allows storing data in key-value pairs. HashMap operates on the principle of **hashing**, which means that data is stored in an array and accessed by **computing the hash value for the key**.

In the case of HashMap, calculating the hash value is used to determine the index of the array under which the data should be stored. This makes access to data in HashMap very fast, as to find the data, you only need to calculate their hash and find them under the appropriate index in the array.

To add a new element to HashMap, you should call the **`put`** method, which takes two arguments - the key and the value. To retrieve the value for a given key, you should call the **`get`** method, which takes the key as an argument and returns the value that has been assigned to that key.

HashMap is widely used in applications because it provides fast data access and is easy to use. However, it should be remembered that HashMap does not guarantee the order of elements, so if it is necessary to maintain the order of adding elements, you should use a different implementation of the Map interface, for example **`LinkedHashMap`**.

It's worth noting: when you create a map in Kotlin using the **`mapOf()`** function, a **`LinkedHashMap`** is created underneath.

### **What is a collision in a HashMap?**

<aside>
👉  A common question in job interviews

</aside>

This is a situation where two different keys give the same hash value. In this situation, the data for these keys will be stored under the same index in the array, which can cause data loss for one of the keys.

HashMap is designed in a way to avoid collisions by using additional mechanisms such as scattering or chaining. In case of scattering, data for keys that give the same hash value are stored under different indices in the array, while in case of chaining, data for keys with collisions are stored in the form of a list under the same index in the array. However, it should be remembered that the greater the number of collisions, the more memory is needed to store the data and the more time has to be spent on their search.