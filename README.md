# android-extensions
[![Build Status](https://travis-ci.org/vpaliyX/android-extensions.svg?branch=master)](https://travis-ci.org/vpaliyX/android-extensions)

![](https://github.com/vpaliyX/android-extensions/blob/master/art/kotlin.png)
This repository contains a set of android extensions which I use in my apps.

## Animation Extensions ##

1. Apply the same scale factor to X and Y.
```kotlin
view.animate().scale(1.f).start()
```
2. An easier way to build the animator object.
```kotlin
view.animator {
    scale(factor=1.5f)
    translationX(distanceX())
    translationY(distanceY())
    duration=300L
    startDelay=100L
    interpolator=AccelerateInterpolator()
 }.start()
```
3. Now it's super easy to build a width/height animator. 
You just need to pass the end height/width.

```kotlin
 view.getHeightAnimator(view.height/2).start()
```

4. Or you can do something like this:

```kotlin
 view.getHeightAnimator(endHeight).apply { 
    duration=300
    startDelay=10
    interpolator=AccelerateInterpolator()
 }.start()
```
