# Leighton Buzzard Weather Recruitment Exercise App
The Leighton Buzzard Weather app was undertaken as part of a recruitment exercise
## Running, Building & Testing Leighton Buzzard Weather
 - Clone the GitHub repository
 - Import the BuzzardWeather project into Android Studio (it was developed using version 2.3 with Gradle 2.3.0)
 - Run using a device or emulator at API level 16 or above
 - Unit tests can be run from within Android Studio
 - There are no instrumentation tests at present
## Code Architecture
The app is a standard single Activity Android project utilising a ViewPager containing a Fragment for each day's weather forecast. Each Fragment contains a RecyclerView to display the forecast for each time period. When the app is resumed the MainPresenter makes use of an Interactor to instigate a call to the OpenWeatherMap API on a background thread using RxJava and Retrofit 2. The data returned from the service is then mapped from the Gson annotated POJOs to a more succinct set of parcelable objects for local use by the UI elements. Picasso is used to load the (rather tiny) weather icons supplied by OpenWeatherMap. Butterknife is used to bind views. Dagger 2 is used for Dependency Injection.
### Design patterns used
 - MVP
 - Dependency Injection
### Libraries used
 - Butterknife
 - RxJava
 - Dagger 2
 - Retrofit 2
 - Picasso
 - OkHttp 3

*OpenWeatherMap POJOs created using: http://www.jsonschema2pojo.org/*

## Future Enhancements:
 - Remove the assumption that the data is returned from the service in the correct time order by sorting it before mapping takes place
 - Add more comprehensive unit tests
 - Add instrumentation tests
 - Implement more comprehensive error handling
 - Implement loading/empty state UI
 - Implement caching for offline use
 - Add  a pull-to-refresh control
 - More information displayed from the service i.e. min/max temperatures
 - Specifically add a custom view that shows the wind speed and direction
 - Add light and dark themes
 - Add Night/Day themes
 - Add translations
 - Add an anayltics solution
 - Add a search box for other locations!