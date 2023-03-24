![Screenshot](./resources/github-banner.png)

# Android Kotlin boilerplate

This template is compatible with the latest **stable** version of Android Studio.


## Core

* Room Database
* Hilt
* ViewModel, read+write
* UI in Compose, list + write (Material3)
* Navigation
* Repository and data source
* Kotlin Coroutines and Flow
* Unit tests
* UI tests using fake data with Hilt

## Installation

1. Clone this branch

```
git clone https://github.com/android/architecture-templates.git --branch base
```

2. Run the customizer script:

```
./customizer.sh your.package.name DataItemType [MyApplication]
```

Where `your.package.name` is your app ID (should be lowercase) and `DataItemType` is used for the
name of the screen, exposed state and data base entity (should be PascalCase). You can add an optional application name.

## Features 🍌
* [ ] Localization
* [ ] Theme
* [x] Navigation Stack
* [x] State Management - ViewModel
* [x] Login Flow
    * [] Login Flow UI 
        * [ ] Login/ Signup/ Forgot password
    * Intergation Mock API and view model
        * [ ] Login/Signup With Email
        * [ ] Login With Google
        * [ ] Login With Facebook (optional)
        * [ ] Login With Apple
    * User state management
        * [ ] Create dashboard screen with bottom navigation bar
        * [ ] Profile screen - show login/no-login state

## Digging Deeper 🚀
Checkout [wiki](https://github.com/GoldenOwlAsia/mobile-android-kotlin-template/wiki) for more info

## Screenshot
