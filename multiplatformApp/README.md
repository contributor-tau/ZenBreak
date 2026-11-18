# multiplatformApp
This is an **Apple** multiplatform app.  
Meaning it's a project that contains the macOS and iOS applications.  

### Dependencies
This depends on the `shared-core` module which is packed as a multiplatform framework in order to be usable here.  
Refer to that module for instructions on how to build it.

Run `./gradlew :shared-core:spmDevBuild` from the repository root before opening the project in Xcode:
it builds the `ZenBreakCoreKit` XCFramework that the root `Package.swift` points to.
