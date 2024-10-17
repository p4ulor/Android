# Does the order of Modifiers in Compose matter?

Yes, the order of Modifiers in Jetpack Compose does matter. Modifiers are applied in the order they are specified, which can affect the appearance and behavior of the composable.

For example, if we have two Modifiers: padding and background, the order in which they are applied will affect the final result:

```kotlin
Box(
	modifier = Modifier
	.padding(16.dp)
	.background(Color.Red)
)
```

In the above case, padding will be applied first, followed by the background, meaning the background will encompass the padding.

```kotlin
Box(
	modifier = Modifier
	.background(Color.Red)
	.padding(16.dp)
)
```

In this case, the background is applied first, followed by the padding. This means that the padding will not have a red background because it is added after the background.

Another example is the use of Modifier.clickable(). If clickable is added before size, the clickable area will have the default size, not the size specified by size. However, if clickable is added after size, the clickable area will have the size specified by size.