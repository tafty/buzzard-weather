package com.sixtyfourthpixel.buzzardweather.interactors;


import com.sixtyfourthpixel.buzzardweather.interactors.responses.MultiDayForecastResponse;
import com.sixtyfourthpixel.buzzardweather.model.mappers.MultiDayForecastMapper;
import com.sixtyfourthpixel.buzzardweather.service.OpenWeatherMapApi;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

import static com.sixtyfourthpixel.buzzardweather.Constants.API_ID;
import static com.sixtyfourthpixel.buzzardweather.Constants.DAYS_TO_FORECAST;
import static com.sixtyfourthpixel.buzzardweather.Constants.UNITS;

public class WeatherData implements InteractorContracts.WeatherApi {
	private final Retrofit retrofit;
	private final MultiDayForecastMapper multiDayForecastMapper;

	public WeatherData(Retrofit retrofit, MultiDayForecastMapper multiDayForecastMapper) {
		this.retrofit = retrofit;
		this.multiDayForecastMapper = multiDayForecastMapper;
	}

	@Override
	public Observable<MultiDayForecastResponse> getForecast(String city) {
		OpenWeatherMapApi api = retrofit.create(OpenWeatherMapApi.class);

		return api.getForecast(city, API_ID, UNITS)
				.subscribeOn(Schedulers.io())
				.observeOn(AndroidSchedulers.mainThread())
				.map(cityForecast -> multiDayForecastMapper.map(cityForecast, DAYS_TO_FORECAST))
				.map(MultiDayForecastResponse::new)
				.onErrorReturn(MultiDayForecastResponse::new);
	}
}
