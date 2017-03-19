package com.sixtyfourthpixel.buzzardweather.di;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
	private final Application application;

	public AppModule(Application mApplication) {
		this.application = mApplication;
	}

	@Provides
	@Singleton
	Application provideApplication() {
		return application;
	}
}
