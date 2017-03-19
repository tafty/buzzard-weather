package com.sixtyfourthpixel.buzzardweather.di.model.mappers;


import com.sixtyfourthpixel.buzzardweather.model.mappers.MultiDayForecastMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MappersModule {
	@Provides
	@Singleton
	MultiDayForecastMapper provideMultiDayForecastMapper() {
		return new MultiDayForecastMapper();
	}
}
