Contributing
===

## release

- update changelog
- bump versionCode in `keyboardvisibilityevent/build.gradle`
- bump versionName via gradle task(bumpMajor, bumpMinor or bumpPatch)
- run `./gradlew releng`
- run `./gradlew clean build :keyboardvisibilityevent:bintrayUpload -PbintrayUser=$BINTRAY_USER -PbintrayKey=$BINTRAY_API_KEY -PdryRun=false
`