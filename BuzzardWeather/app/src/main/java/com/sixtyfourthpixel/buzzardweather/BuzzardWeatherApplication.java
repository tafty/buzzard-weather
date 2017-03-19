package com.sixtyfourthpixel.buzzardweather;

import android.app.Application;

import com.sixtyfourthpixel.buzzardweather.di.AppComponent;
import com.sixtyfourthpixel.buzzardweather.di.AppModule;
import com.sixtyfourthpixel.buzzardweather.di.DaggerAppComponent;
import com.sixtyfourthpixel.buzzardweather.di.NetModule;

import static com.sixtyfourthpixel.buzzardweather.Constants.API_BASE_URL;


public class BuzzardWeatherApplication extends Application {
	private AppComponent appComponent;

	@Override
	public void onCreate() {
		super.onCreate();

		appComponent = DaggerAppComponent.builder()
				.appModule(new AppModule(this))
				.netModule(new NetModule(API_BASE_URL))
				.build();
	}

	public AppComponent getAppComponent() {
		return appComponent;
	}
}