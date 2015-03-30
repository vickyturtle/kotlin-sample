# kotlin-sample
Sample app to test kotlin usage with various libraries. The app is simple, just fetches rss feed of *The Verge* and displays it in list
Main purpose of the app is to test working of as many libraries as possible with Kotlin.
# Note
This app's main aim is to test working of some of the most used libraries for android with Kotlin. This is just a sample
app and the procedures may not be best practices.

# Libraries tested
* [Dagger 2](http://google.github.io/dagger/)
* [Retrofit ](https://github.com/square/retrofit)
* [Simple-Xml Converter](https://github.com/square/retrofit/tree/master/retrofit-converters/simplexml)
* [Rx Java](https://github.com/ReactiveX/RxJava)
* [Rx Android](https://github.com/ReactiveX/RxAndroid)
* [Jsoup](https://github.com/jhy/jsoup/)
* [Picasso](https://github.com/square/picasso)
* Recycler View

# What's not working
* Most of the annotations don't work if used directly on Kotlin `Property`. However they work perfectly if used on `gettters` and `setters`
* All Dagger modules have to be set in java only.
