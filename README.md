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

## Common Extensions ##

1. Eliminate the tedious "if" problem in Kotlin.

```kotlin
val condition=...
val result=if(condition) 1 else 0
```
Here's a better way to do this:

```kotlin
 val condition=...
 val result=condition then 1?:0
```

2. If you need to check a parameter for null and then pass it into a function:

```kotlin
fun requestItem(id:String?):Int{
   if(id!=null){
      return fetch(id)
   }
   return error()
}
```
A bit better:
```kotlin
fun request(id:String?)=id then(this::fetch)?:error()
```
Add an exception:
```kotlin
fun requestItem(id:String?):Int{
   if(id!=null){
      return fetch(id)
   }
   throw IllegalArgumentException()
}
```

```kotlin
fun request(id:String?)=id then(this::fetch)?:throw IllegalArgumentException()
```

## Installation ##


``` gradle
allprojects {
  repositories {
     maven { url 'https://jitpack.io' }
  }
}
```

``` gradle
dependencies {
     compile 'com.github.vpaliyX:android-extensions:-SNAPSHOT'
}

```



``````
MIT License

Copyright (c) 2017 Vasyl Paliy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
``````
