# DevelopersLifeApp
## You are invited to write an Android application that has the following minimum functionality:
1. On the main screen of the application, a gif image is displayed along with its
description obtained from the site developerslife.ru (details of working with the [API](http://developerslife.ru/) are below) *
2. There are two buttons below the image:
- - One (next button) loads the next random post
(by calling the API method).
 - - The second - allows you to return to the previous post, which we
cached after download.
- - It turns out the following structure: (initially, the back button is not active, but already
there is some post loaded at startup) click on “next” →
a post appears and the back button becomes active → click on
“next” again → a new post appears and both buttons are active → press back and get one post back (both buttons are active) → press again and get to the first picture (the back button has become
active again). Now if we click on "next" we first have to
go through the posts that we had loaded, and then how they end - upload new ones.
3. API responses must be cached at least for the duration of the session for
implementation of transitions "back".
4. Different states of data loading should be provided: error
downloads, download and successful download.

## It would be great (but not required) if you take care of the following:
- Application will be written in Kotlin
- General smoothness and stability of the app
- Ability to display gif images from three different site categories: hot, latest popular

## The application implements:
- Fragment
- ViewBinding
- OkHttp
- Retrofit
- Glide
- RxJava
- MVP
