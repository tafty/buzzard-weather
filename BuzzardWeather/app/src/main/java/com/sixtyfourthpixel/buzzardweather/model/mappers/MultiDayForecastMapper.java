package com.sixtyfourthpixel.buzzardweather.model.mappers;


import com.sixtyfourthpixel.buzzardweather.model.local.DayForecast;
import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;
import com.sixtyfourthpixel.buzzardweather.model.local.TimeForecast;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.CityForecast;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.Forecast;

import java.util.Calendar;

import static com.sixtyfourthpixel.buzzardweather.Constants.WEATHER_ICON_URL;
import static com.sixtyfourthpixel.buzzardweather.Constants.WEATHER_ICON_URL_PLACEHOLDER;

public class MultiDayForecastMapper {
	public MultiDayForecast map(CityForecast cityForecast, int limit) {
		if (cityForecast == null || cityForecast.getForecasts() == null || cityForecast.getForecasts().size() == 0) {
			return null;
		}

		// TODO Sort the incoming city forecast data by time
		MultiDayForecast multiDayForecast = new MultiDayForecast();

		Calendar date = Calendar.getInstance();
		int currentDay = -1;
		DayForecast dayForecast = null;
		String description;
		String icon;

		for (Forecast forecast : cityForecast.getForecasts()) {
			date.setTimeInMillis(forecast.getDate() * 1000);

			//noinspection WrongConstant
			if (date.get(Calendar.DAY_OF_YEAR) != currentDay) {
				if (multiDayForecast.dayForecasts.size() >= limit) {
					break;
				}

				currentDay = date.get(Calendar.DAY_OF_YEAR);

				dayForecast = new DayForecast((Calendar) date.clone());

				multiDayForecast.dayForecasts.add(dayForecast);
			}

			if (dayForecast != null) {
				if (forecast.getWeather().size() > 0) {
					description = forecast.getWeather().get(0).getDescription();
					icon = WEATHER_ICON_URL.replace(WEATHER_ICON_URL_PLACEHOLDER, forecast.getWeather().get(0).getIcon());
				} else {
					description = "";
					icon = "";
				}

				dayForecast.timeForecasts.add(
						new TimeForecast(
								(Calendar) date.clone(),
								forecast.getAtmosphere().getTemp(),
								forecast.getWind().getSpeed(),
								forecast.getWind().getDegrees(),
								description,
								icon));
			}
		}

		return multiDayForecast;
	}
}
