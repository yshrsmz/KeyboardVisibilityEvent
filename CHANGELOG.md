Change Log
==========

Version 3.0.0-RC2 *(2020-02-28)*
--------------------------------

- Add missing javadoc.jar and sources.jar
- Improve status bar height calculation logic [#57](https://github.com/yshrsmz/KeyboardVisibilityEvent/pull/57). Thanks [@anoop44](https://github.com/anoop44)!
- Fix an wrong method signature [#58](https://github.com/yshrsmz/KeyboardVisibilityEvent/pull/58). Thanks [@bensmiley](https://github.com/bensmiley)!


Version 3.0.0-RC1 *(2020-02-14)*
----------------------------

- Library converted to Kotlin(v1.3.61)
- Update targetSdkVersion to 29
- Android Gradle Plugin 3.5.3
- Added support for Architecture Components Lifecycle [#48](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/48). Thanks @kletzander](https://github.com/kletzander)!
- Exclude the height of status bar and ActionBar from the height diff calculation to fix [#41](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/41). Thanks [@anoop44](https://github.com/anoop44)!


Version 2.3.0 *(2019-04-09)*
----------------------------

- Check `SOFT_INPUT_ADJUST_NOTHING` explicitly to fix [#37](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/37) and [#38](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/38). Thanks to [@alzhuravlev](https://github.com/alzhuravlev) for the fix!


Version 2.2.1 *(2019-01-22)*
----------------------------

- Added logic to handle softInputMode with keyboard state flags. (windowSoftInputMode="adjustResize|stateHidden" or similar values will not crash anymore and keyboard visibility changes will be detected properly)


Version 2.2.0 *(2018-12-11)*
----------------------------

- Update targetSdkVersion to 28
- Use ratio rather than constant value to detect keyboard visibility change [#25](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/25)


Version 2.1.0 *(2017-03-06)*
----------------------------

- Add `Unregistrar registerEventListener(Activity, KeyboardVisibilityEventListener)` to manually unregister event([#18](https://github.com/yshrsmz/KeyboardVisibilityEvent/pull/18)). Thanks to [@anoop44](https://github.com/anoop44) for the awesome PR!


Version 2.0.1 *(2017-01-06)*
----------------------------

- Fix keyboard not properly detected in some situation([#7](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/7) and [#8](https://github.com/yshrsmz/KeyboardVisibilityEvent/issues/8)). Thanks to [@UsherBaby](https://github.com/UsherBaby) for the fix!

Version 2.0.0 *(2016-08-20)*
----------------------------

- Moved to jCenter
- Min SDK 14
- Auto unregister event upon target Activity's onDestroy
- Updated tools


Version 1.0.1 *(2015-10-26)*
----------------------------

- Min SDK 9



Version 1.0.0 *(2015-03-20)*
----------------------------

- Initial Release

