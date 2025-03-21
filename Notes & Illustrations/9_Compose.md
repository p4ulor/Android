### 1 - CompositionLocals
Given a composable function that has
- val density = LocalDensity.current

Shouldn't it be more efficient to store it in a `remember{}` block?

No, it's generally not recommended or reliable to store `LocalDensity.current` directly in a `remember` block.

Here's why:
- `LocalDensity` is a `CompositionLocal`:  `CompositionLocal` values are designed to be dynamic and can change during recomposition.  Storing the value in `remember` effectively freezes it to the value it had *during the initial composition*.  If the density changes (e.g., due to configuration changes, font size changes, or other factors), your composable will be using the *old*, incorrect density value.
- Recomposition Issues:  Using an outdated `LocalDensity` can lead to incorrect UI layout and scaling.  Elements might appear too large or too small, or they might not be positioned correctly.  This can create a frustrating user experience.
- Compose will handle recomposition and update the value as needed.

## Tutorials
### Graph with fade and animation
- https://youtu.be/1yiuxWK74vI
