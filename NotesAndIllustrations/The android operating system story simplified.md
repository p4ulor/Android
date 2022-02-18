### The Operating system
Android's OS AKA Runtime was built on top of the Linux kernel LTS branch (open-source, in C language). Android is a Linux distribution according to the Linux Foundation. Others, such as Google engineer Patrick Brady, say that Android is not Linux in the traditional Unix-like Linux distribution sense; Android does not include the GNU C Library (it uses Bionic as an alternative C library) 

### The run time enviornment (which runs on top of the OS)
A run time enviornment is like a small operating system that provide all the functionality necessary for a program to run

Android's programming languages (suited/used for apps) are mainly Java and Kotlin

Android can't *run java or kotlin* applications. It runs **Android applications** *written* in java or kotlin that get compiled down to the .class (bytecodes) files and are further used as explained bellow.

The RTE (which deals with compilation and execution) that was built to work with these files was designed by Google and  it's called Dalvik. 

This RTE, on top of Google's code, uses a subset of the free and open-source [Apache Harmony](https://en.wikipedia.org/wiki/Apache_Harmony) project, an implementation (or a [Clean room design](https://en.wikipedia.org/wiki/Clean_room_design)) of the Java (class libraries) for the core of it's Class Library AND 11,000 lines of source code, which are owned by Oracle. 

What Google used from Apache Harmony's project, includes 37 API calls and around 11,500 lines of code deemed central to Java. Google stated that it had used this code for commercial reasons to rapidly complete Android and to avoid the "drudgery" of recreating the code.

Anyways, these bytecodes are inputed to this Dalvik RTE which creates .dex files which contain Dex bytecodes. These files are finally packed with other resource files and are turned into an .apk file. Which is a file that packages everything needed to install a program and make it a runnable android application in the phone.

In 2013, Along with Dalvik working in OS version 4.4, ART (Android Runtime) is launched along side it. And from that point forward, Dalvik was left behind and the Android's OS being used since then was and still is the Android Runtime (ART)

ART improved load and run times by using native code. And it works using the same Dex bytecodes and files format. Also, in order to adapt to Oracle's lawsuit, this OS was built within Google without any of the Java source code. However, Android continued to use the JavaSE APIs until Android Nougat (still not copyrighted, since just using the descriptions of declarations or interfaces in order to create your implementations of API's afterward, is not copyrightable), until it was fully replaced by OpenJDK (this was also because Apache Harmony project was discontinued and because at this point in time OpenJDK had much more functionality back when Google used Apache Harmony)

Adding OpenJDK to the equation, Android now has certain Java API libraries to support the development of apps in the Java programming language, broken into two parts: the APIs to the libraries, and the implementing code developed by Google that make said libraries work. 

Oracle, which develops Java, has two implementations of these libraries: the proprietary JDK version and the open source OpenJDK version. Google’s decision to “consolidate” its efforts with OpenJDK means it is moving away from its own and implemented code, to Oracle’s open-source code. Amazon and other companies also contribute to OpenJDK.

## Webography
- https://en.wikipedia.org/wiki/Google_LLC_v._Oracle_America,_Inc.
- https://en.wikipedia.org/wiki/Dalvik_(software)
- https://source.android.com/devices/tech/dalvik
- https://www.baeldung.com/oracle-jdk-vs-openjdk