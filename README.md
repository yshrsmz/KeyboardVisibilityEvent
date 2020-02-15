KeyboardVisibilityEvent
===

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-KeyboardVisibilityEvent-green.svg?style=flat)](https://android-arsenal.com/details/1/2519)
[![Android Gems](http://www.android-gems.com/badge/yshrsmz/KeyboardVisibilityEvent.svg?branch=master)](http://www.android-gems.com/lib/yshrsmz/KeyboardVisibilityEvent)
[![Download](https://api.bintray.com/packages/yshrsmz/maven/keyboardvisibilityevent/images/download.svg) ](https://bintray.com/yshrsmz/maven/keyboardvisibilityevent/_latestVersion)

Android Library to handle soft keyboard visibility change event.
show/hide keyboard method is also included.

## Library's status

Currently I don't have enough time to maintain this library, so I leave this as it is.  
I'm going to merge PRs when they arrive though ;)

## Features
- handle keyboard visibility change
- check if keyboard is currently visible
- show/hide keyboard(check UIUtil.java)

_Please note that as described in this [issue](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/1), currently the library cannot detect visibility change when the activity's `windowSoftInputMode` do not change Activity's height(such as `adjustNothing`)._

## Installation

from 2.0.0, AAR is distributed via jCenter. The latest version is [![Download](https://api.bintray.com/packages/yshrsmz/maven/keyboardvisibilityevent/images/download.svg) ](https://bintray.com/yshrsmz/maven/keyboardvisibilityevent/_latestVersion)

```groovy
dependencies {
    compile 'net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:LATEST_VERSION'
}
```

## Usage

check out sample project!

### Add event listener for keyboard change event

#### Automatically unregistering the event on the Activity's onDestroy
```java
KeyboardVisibilityEvent.setEventListener(
        getActivity(),
        new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                // some code depending on keyboard visiblity status
            }
        });
```

#### Automatically unregistering the event on the LifecycleOwner's `ON_DESTROY`

This is convenient when you want to KeyboardVisibilityEvent from a Fragment.

```java
KeyboardVisibilityEvent.setEventListener(
        getActivity(),
        getLifecycleOwner(),
        new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                // some code depending on keyboard visiblity status
            }
        });
```

#### Manually unregistering the event
```java
// get Unregistrar
Unregistrar unregistrar = KeyboardVisibilityEvent.registerEventListener(
        getActivity(),
        new KeyboardVisibilityEventListener() {
            @Override
            public void onVisibilityChanged(boolean isOpen) {
                // some code depending on keyboard visiblity status
            }
        });

// call this method when you don't need the event listener anymore
unregistrar.unregister();
```

## License

    Copyright 2015-2019 Shimizu Yasuhiro (yshrsmz)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
