[![Android Gems](http://www.android-gems.com/badge/yshrsmz/KeyboardVisibilityEvent.svg?branch=master)](http://www.android-gems.com/lib/yshrsmz/KeyboardVisibilityEvent)

KeyboardVisibilityEvent
===

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-KeyboardVisibilityEvent-green.svg?style=flat)](https://android-arsenal.com/details/1/2519)

Android Library to handle soft keyboard visibility change event.
show/hide keyboard method is also included.

## Features
- handle keyboard visibility change
- check if keyboard is currently visible
- show/hide keyboard(check UIUtil.java)

## Installation

AAR is distributed on the Maven Central repository.

```groovy
repositories {
    mavenCentral()
}

dependencies {
    compile 'net.yslibrary.keyboardvisibilityevent:keyboardvisibilityevent:1.0.0'
}
```

## Usage

check out sample project!

### Add event listener for keyboard change event

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

## License

http://www.apache.org/licenses/LICENSE-2.0.txt

