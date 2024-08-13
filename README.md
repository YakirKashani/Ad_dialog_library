# AdDialog Library

A customizable Android library for displaying popup ads with a countdown timer, featuring animations and customizable ad behavior.

## Features

- **Countdown Timer**: Displays a countdown timer showing the remaining time until the ad can be closed.
- **Clickable Ad Image**: Allows users to click on the ad image, which opens a specified URL in a browser.
- **Customizable Animations**: Choose from a variety of animations for displaying the ad.
- **Cancelable Ads**: Users can close the ad by pressing an 'X' button after a countdown timer ends.
- **Configureable**: Easily configure the ad's content, timer duration, and animation.

## Setup

Add the following to your 'build.gradle' file:

```groovy
dependencies {
  implementation 'com.example:ad-dialog-library:1.0.0'
}
```


## Usage

To use the AdDialog library in your android application, follow these steps:

1. **Initialize the AdDialog**: Call the 'showDialog' method from your activity or fragment, passing in the required parameters:


```Java
AdDialog.showDialog(
  this,
  nextIntent,
  10, // Countdown in seconds
  R.drawable.your_ad_image, // Image resource
  AdAnimation.ENTER_FROM_LEFT, // Animation type
  "https://your-ad-url.com" // URL to open on ad click
);
```

2. **Configure the Dialog**:

- *Context*: The current vontext of your activity or fragment.
- *nextIntent*: The intent to start when the ad is closed.
- *CountDownInSeconds*: Duration of the countdown timer in seconds.
- *InageResId*: Resource ID of the ad image.
- *AdAnimation*: The type of animation to use when displaying the ad.
- *URL*: The URL to open in a browser when the ad image is clicked.

## Animations

The AdDialog library provides several animation for the dialog appearance:

- *"ENTER_FROM_LEFT"*
- *"ENTER_FROM_RIGHT"*
- *"ENTER_FROM_ABOVE"*
- *"ENTER_FROM_BELOW"*
- *"RESIZE_TO_FULL"*

These animations can be used to customize the visual experience of your ads.

![Ad_picture](https://github.com/user-attachments/assets/1f80c66c-ab8e-46b8-83eb-be8a543c95a7)

