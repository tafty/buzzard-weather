package com.sixtyfourthpixel.buzzardweather.di.ui;


import com.sixtyfourthpixel.buzzardweather.interactors.InteractorContracts;
import com.sixtyfourthpixel.buzzardweather.ui.MainContracts;
import com.sixtyfourthpixel.buzzardweather.ui.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
	@Provides
	@Singleton
	MainContracts.Presenter providePresenter(InteractorContracts.WeatherApi weatherApi) {
		return new MainPresenter(weatherApi);
	}
}
