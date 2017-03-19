package com.sixtyfourthpixel.buzzardweather.di.interactors;


import com.sixtyfourthpixel.buzzardweather.interactors.InteractorContracts;
import com.sixtyfourthpixel.buzzardweather.interactors.WeatherData;
import com.sixtyfourthpixel.buzzardweather.model.mappers.MultiDayForecastMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class InteractorModule {
	@Provides
	@Singleton
	InteractorContracts.WeatherApi provideWeatherData(Retrofit retrofit, MultiDayForecastMapper multiDayForecastMapper) {
		return new WeatherData(retrofit, multiDayForecastMapper);
	}
}
