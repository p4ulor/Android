## [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- The purpose of the use of a ViewModel, is to store (and maintain) data throught the lifecycle changes of activities **in memory**
- Most activities have a custom ViewModel class tied to it to store data and perform operations that need to be asynchronous operations
- This component/object/entity is initilizaed when an activity is launched, and it's data and outgoing operations survives throughout the activity lifecycle transitions. But when the activity is destroyed or when the app's process is terminated, it's ViewModel is also destroyed
- It's like a conscious data maintainer in an activies life. ViewModel objects are automatically retained during configuration changes so the data they hold is immediately available to the re-created activity (or fragment instance)
- This component functions and works for 1 activity at a time
- This is a fundamental component part of android's architecture (OS), that provides this functionality in some sort of automatic and aware way once the project is compiled
- Note, you should have methods that do I/O without return values, use update LiveData variables instead
- Generaly, since the ViewModel is the class with the data, it's where data should be manipulated with methods. Thus, the Activity should handle widgets, listeners, LiveData observations and other things (presentational logic)
- A better name to understand ViewModel is ActivitySuperviser, ActivitySurviver, ActivityDataHolder, etc

## [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- The purpose of LiveData is to hold data that can be observed. This is, you can implement consequences to what happens when the data changes by defining a method, per example, you might wanna update something given the data's new value. It's an observable data container. It's usefulness is that you get notified of when the data changes and can act on it
- It's notification method is also triggered during screen rotation
- This type of container of data is defined, setted and obtained in the respective ViewModel class for an Activity
- This data holder is mostly used alongside with a ViewModel as a field
- The observe method is set on the ViewModel's activity, usually in the onCreate()
- It's mostly used for observing values in the activitie's ViewModel and notifying them to the activity. Per example, to update widgets from an activity, since you cant access them directly in the ViewModel class
- In order to grasp the name LiveData, you could be associate the fact that a variable LiveData is "alive" or that it "lives", meaning that it speaks/communicates (in coding term, observes) when it's changed. Like "HEY!" my (me= variable) value changed! 

## The use of ViewModel is recommended for synchronous operations

If you call a method defined in an activity that makes a request to a server via Volley, and it takes a couple seconds, and you rotate the screen or in any other way destroy the activity the response will try to give the response to the previous activity which was already destroyed. But if you have this method running from a ViewModel class, it work because the ViewModel survives during screen rotation.

Per example, note that when using Volley and Retrofit:
- execute() -> blocking, synchronous I/O through network
- enqueue() -> non blocking, assynchrnous I/O through network, BUT doesnt survive reconfiguration changes, unless viewModel is used

## Advantages over onSave and OnRestore InstanceState
- No need to write multiple "puts" and "gets" like `bundle.putString("key", string)` and `bundle.getString("key")`, per variable.
- Fewer object type saving limitations. 
- Cleaner/simpler code
- Much likely faster app execution
