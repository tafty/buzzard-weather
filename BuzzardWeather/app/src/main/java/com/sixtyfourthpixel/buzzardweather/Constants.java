package com.sixtyfourthpixel.buzzardweather;


public class Constants {
	public static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/";
	public static final String CITY = "Leighton%20Buzzard,uk";
	public static final String API_ID = "ea2f736620b0751ed007d964c9e8f69f";
	public static final String UNITS = "metric";

	public static final String WEATHER_ICON_URL_PLACEHOLDER = "{icon}";
	public static final String WEATHER_ICON_URL = String.format("http://openweathermap.org/img/w/%1$s.png", WEATHER_ICON_URL_PLACEHOLDER);

	public static final int DAYS_TO_FORECAST = 5;
}
