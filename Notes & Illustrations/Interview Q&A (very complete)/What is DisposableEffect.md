# What is DisposableEffect?

DisposableEffect in Compose is used for side effects that require cleanup when key changes occur or when the composition is leaving. If the keys of DisposableEffect change, you need to dispose (clean up) your current effect and reset it by invoking the effect again. It should include an onDispose clause as the last statement in its code block. Otherwise, the IDE displays an error during compilation.

It can be used to register and unregister lifecycle observers. For example, you may want to send analytics events based on lifecycle events.

Use DisposableEffect to register and unregister an observer when necessary.