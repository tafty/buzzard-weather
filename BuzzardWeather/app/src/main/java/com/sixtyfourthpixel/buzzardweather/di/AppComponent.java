package com.sixtyfourthpixel.buzzardweather.di;

import com.sixtyfourthpixel.buzzardweather.di.interactors.InteractorModule;
import com.sixtyfourthpixel.buzzardweather.di.model.mappers.MappersModule;
import com.sixtyfourthpixel.buzzardweather.di.ui.MainModule;
import com.sixtyfourthpixel.buzzardweather.ui.MainActivity;
import com.sixtyfourthpixel.buzzardweather.ui.forecasts.DayForecastFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules = {AppModule.class, NetModule.class, InteractorModule.class, MainModule.class, MappersModule.class})
public interface AppComponent {
	void inject(MainActivity activity);

	void inject(DayForecastFragment fragment);
}
