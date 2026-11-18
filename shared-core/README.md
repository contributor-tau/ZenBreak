# shared-core
This module contains the shared logic of the app.  
It is packaged as the `ZenBreakCoreKit` XCFramework with [KMMBridge](https://github.com/touchlab/KMMBridge).

## Development
Run `./gradlew :shared-core:spmDevBuild` to build a debug XCFramework and point the root `Package.swift` at it.
The macOS app (`multiplatformApp`) uses that local package.

## Publishing
The manually triggered `Release ZenBreakCoreKit` GitHub action uploads the XCFramework as a GitHub Release asset
(downloadable by Swift Package Manager without credentials) and tags a commit with a matching `Package.swift`.
Bump `LIBRARY_VERSION` in `gradle.properties` before running it.
