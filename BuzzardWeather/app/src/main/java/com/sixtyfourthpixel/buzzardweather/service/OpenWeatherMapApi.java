package com.sixtyfourthpixel.buzzardweather.service;


import com.sixtyfourthpixel.buzzardweather.model.openweathermap.CityForecast;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapApi {
	@GET("forecast")
	Observable<CityForecast> getForecast(@Query("q") String city, @Query("appid") String apiId, @Query("units") String units);
}
