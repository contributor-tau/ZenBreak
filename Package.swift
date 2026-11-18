// swift-tools-version:5.8
import PackageDescription

let packageName = "ZenBreakCoreKit"

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v15),
        .macOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            path: "./shared-core/build/XCFrameworks/debug/\(packageName).xcframework"
        )
        ,
    ]
)
