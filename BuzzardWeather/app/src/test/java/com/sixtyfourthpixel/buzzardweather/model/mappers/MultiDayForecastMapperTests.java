package com.sixtyfourthpixel.buzzardweather.model.mappers;


import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.Atmosphere;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.CityForecast;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.Forecast;
import com.sixtyfourthpixel.buzzardweather.model.openweathermap.Weather;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MultiDayForecastMapperTests {
	private static final long FORECAST_TIME_1 = 1487257200L;
	private static final long FORECAST_TIME_2 = 1487268000L;
	private static final long FORECAST_TIME_3 = 1487289600L;
	private static final long FORECAST_TIME_4 = 1487300400L;

	private static final String WEATHER_DESCRIPTION_1 = "WEATHER_DESCRIPTION_1";
	private static final String WEATHER_ICON_1 = "WEATHER_ICON_1";
	private static final String WEATHER_ICON_URL_1 = "http://openweathermap.org/img/w/WEATHER_ICON_1.png";
	private static final double ATMOSPHERE_TEMPERATURE_1 = 1.0;

	private static final String WEATHER_DESCRIPTION_2 = "WEATHER_DESCRIPTION_2";
	private static final String WEATHER_ICON_2 = "WEATHER_ICON_2";
	private static final String WEATHER_ICON_URL_2 = "http://openweathermap.org/img/w/WEATHER_ICON_2.png";
	private static final double ATMOSPHERE_TEMPERATURE_2 = 2.0;

	private static final String WEATHER_DESCRIPTION_3 = "WEATHER_DESCRIPTION_3";
	private static final String WEATHER_ICON_3 = "WEATHER_ICON_3";
	private static final String WEATHER_ICON_URL_3 = "http://openweathermap.org/img/w/WEATHER_ICON_3.png";
	private static final double ATMOSPHERE_TEMPERATURE_3 = 3.0;

	private static final String WEATHER_DESCRIPTION_4 = "WEATHER_DESCRIPTION_4";
	private static final String WEATHER_ICON_4 = "WEATHER_ICON_4";
	private static final String WEATHER_ICON_URL_4 = "http://openweathermap.org/img/w/WEATHER_ICON_4.png";
	private static final double ATMOSPHERE_TEMPERATURE_4 = 4.0;

	@Mock
	private CityForecast cityForecast0Length;
	@Mock
	private CityForecast cityForecast1Length;
	@Mock
	private CityForecast cityForecast2Length1Day;
	@Mock
	private CityForecast cityForecast2Length2Days;
	@Mock
	private CityForecast cityForecast4Length2Days;
	@Mock
	private Forecast forecast1;
	@Mock
	private Forecast forecast2;
	@Mock
	private Forecast forecast3;
	@Mock
	private Forecast forecast4;
	@Mock
	private Weather weather1;
	@Mock
	private Weather weather2;
	@Mock
	private Weather weather3;
	@Mock
	private Weather weather4;
	@Mock
	private Atmosphere atmosphere1;
	@Mock
	private Atmosphere atmosphere2;
	@Mock
	private Atmosphere atmosphere3;
	@Mock
	private Atmosphere atmosphere4;

	private MultiDayForecastMapper multiDayForecastMapper;

	@Before
	public void setup() {
		multiDayForecastMapper = new MultiDayForecastMapper();

		when(atmosphere1.getTemp()).thenReturn(ATMOSPHERE_TEMPERATURE_1);

		when(weather1.getDescription()).thenReturn(WEATHER_DESCRIPTION_1);
		when(weather1.getIcon()).thenReturn(WEATHER_ICON_1);

		List<Weather> weathers1 = new ArrayList<>();
		weathers1.add(weather1);

		when(forecast1.getDate()).thenReturn(FORECAST_TIME_1);
		when(forecast1.getWeather()).thenReturn(weathers1);
		when(forecast1.getAtmosphere()).thenReturn(atmosphere1);

		when(atmosphere2.getTemp()).thenReturn(ATMOSPHERE_TEMPERATURE_2);

		when(weather2.getDescription()).thenReturn(WEATHER_DESCRIPTION_2);
		when(weather2.getIcon()).thenReturn(WEATHER_ICON_2);

		List<Weather> weathers2 = new ArrayList<>();
		weathers2.add(weather2);

		when(forecast2.getDate()).thenReturn(FORECAST_TIME_2);
		when(forecast2.getWeather()).thenReturn(weathers2);
		when(forecast2.getAtmosphere()).thenReturn(atmosphere2);

		when(atmosphere3.getTemp()).thenReturn(ATMOSPHERE_TEMPERATURE_3);

		when(weather3.getDescription()).thenReturn(WEATHER_DESCRIPTION_3);
		when(weather3.getIcon()).thenReturn(WEATHER_ICON_3);

		List<Weather> weathers3 = new ArrayList<>();
		weathers3.add(weather3);

		when(forecast3.getDate()).thenReturn(FORECAST_TIME_3);
		when(forecast3.getWeather()).thenReturn(weathers3);
		when(forecast3.getAtmosphere()).thenReturn(atmosphere3);

		when(atmosphere4.getTemp()).thenReturn(ATMOSPHERE_TEMPERATURE_4);

		when(weather4.getDescription()).thenReturn(WEATHER_DESCRIPTION_4);
		when(weather4.getIcon()).thenReturn(WEATHER_ICON_4);

		List<Weather> weathers4 = new ArrayList<>();
		weathers4.add(weather4);

		when(forecast4.getDate()).thenReturn(FORECAST_TIME_4);
		when(forecast4.getWeather()).thenReturn(weathers4);
		when(forecast4.getAtmosphere()).thenReturn(atmosphere4);

		List<Forecast> forecast1Length = new ArrayList<>();
		forecast1Length.add(forecast1);

		List<Forecast> forecast2Length1Day = new ArrayList<>();
		forecast2Length1Day.add(forecast1);
		forecast2Length1Day.add(forecast2);

		List<Forecast> forecast2Length2Days = new ArrayList<>();
		forecast2Length2Days.add(forecast1);
		forecast2Length2Days.add(forecast3);

		List<Forecast> forecast4Length2Days = new ArrayList<>();
		forecast4Length2Days.add(forecast1);
		forecast4Length2Days.add(forecast2);
		forecast4Length2Days.add(forecast3);
		forecast4Length2Days.add(forecast4);

		when(cityForecast0Length.getForecasts()).thenReturn(new ArrayList<>());
		when(cityForecast1Length.getForecasts()).thenReturn(forecast1Length);
		when(cityForecast2Length1Day.getForecasts()).thenReturn(forecast2Length1Day);
		when(cityForecast2Length2Days.getForecasts()).thenReturn(forecast2Length2Days);
		when(cityForecast4Length2Days.getForecasts()).thenReturn(forecast4Length2Days);
	}

	@Test
	public void when_cityForecastIsNull_then_return_null() {
		MultiDayForecast forecast = multiDayForecastMapper.map(null, 5);

		assertEquals(null, forecast);
	}

	@Test
	public void when_cityForecastHasNoForecasts_then_multiDayForecastHasNoDays() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast0Length, 5);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(0, forecast.dayForecasts.size());
	}

	@Test
	public void when_cityForecastHasOneForecast_then_multiDayForecastHasOneDayAndOneTimeForecast() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast1Length, 5);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(1, forecast.dayForecasts.size());
		assertEquals(1, forecast.dayForecasts.get(0).timeForecasts.size());

		assertEquals(WEATHER_DESCRIPTION_1, forecast.dayForecasts.get(0).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_1, forecast.dayForecasts.get(0).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_1, forecast.dayForecasts.get(0).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_1 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(0).time.getTimeInMillis());
	}

	@Test
	public void when_cityForecastHasTwoForecastsForOneDay_then_multiDayForecastHasOneDayAndTwoTimeForecasts() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast2Length1Day, 5);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(1, forecast.dayForecasts.size());
		assertEquals(2, forecast.dayForecasts.get(0).timeForecasts.size());

		assertEquals(WEATHER_DESCRIPTION_1, forecast.dayForecasts.get(0).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_1, forecast.dayForecasts.get(0).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_1, forecast.dayForecasts.get(0).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_1 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(0).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_2, forecast.dayForecasts.get(0).timeForecasts.get(1).description);
		assertEquals(WEATHER_ICON_URL_2, forecast.dayForecasts.get(0).timeForecasts.get(1).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_2, forecast.dayForecasts.get(0).timeForecasts.get(1).temperature, 0.001);
		assertEquals(FORECAST_TIME_2 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(1).time.getTimeInMillis());
	}

	@Test
	public void when_cityForecastHasTwoForecastsAcrossTwoDays_then_multiDayForecastHasTwoDaysWithOneTimeForecastEach() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast2Length2Days, 5);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(2, forecast.dayForecasts.size());
		assertEquals(1, forecast.dayForecasts.get(0).timeForecasts.size());
		assertEquals(1, forecast.dayForecasts.get(1).timeForecasts.size());

		assertEquals(WEATHER_DESCRIPTION_1, forecast.dayForecasts.get(0).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_1, forecast.dayForecasts.get(0).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_1, forecast.dayForecasts.get(0).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_1 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(0).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_3, forecast.dayForecasts.get(1).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_3, forecast.dayForecasts.get(1).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_3, forecast.dayForecasts.get(1).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_3 * 1000, forecast.dayForecasts.get(1).timeForecasts.get(0).time.getTimeInMillis());
	}

	@Test
	public void when_cityForecastHasFourForecastsAcrossTwoDays_then_multiDayForecastHasTwoDaysWithTwoTimeForecastsEach() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast4Length2Days, 5);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(2, forecast.dayForecasts.size());
		assertEquals(2, forecast.dayForecasts.get(0).timeForecasts.size());
		assertEquals(2, forecast.dayForecasts.get(1).timeForecasts.size());

		assertEquals(WEATHER_DESCRIPTION_1, forecast.dayForecasts.get(0).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_1, forecast.dayForecasts.get(0).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_1, forecast.dayForecasts.get(0).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_1 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(0).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_2, forecast.dayForecasts.get(0).timeForecasts.get(1).description);
		assertEquals(WEATHER_ICON_URL_2, forecast.dayForecasts.get(0).timeForecasts.get(1).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_2, forecast.dayForecasts.get(0).timeForecasts.get(1).temperature, 0.001);
		assertEquals(FORECAST_TIME_2 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(1).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_3, forecast.dayForecasts.get(1).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_3, forecast.dayForecasts.get(1).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_3, forecast.dayForecasts.get(1).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_3 * 1000, forecast.dayForecasts.get(1).timeForecasts.get(0).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_4, forecast.dayForecasts.get(1).timeForecasts.get(1).description);
		assertEquals(WEATHER_ICON_URL_4, forecast.dayForecasts.get(1).timeForecasts.get(1).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_4, forecast.dayForecasts.get(1).timeForecasts.get(1).temperature, 0.001);
		assertEquals(FORECAST_TIME_4 * 1000, forecast.dayForecasts.get(1).timeForecasts.get(1).time.getTimeInMillis());
	}

	@Test
	public void when_cityForecastHasFourForecastsAcrossTwoDays_but_limitIsOne_then_multiDayForecastHasOneDayWithTwoTimeForecasts() {
		MultiDayForecast forecast = multiDayForecastMapper.map(cityForecast4Length2Days, 1);

		assertNotNull(forecast);
		assertNotNull(forecast.dayForecasts);
		assertEquals(1, forecast.dayForecasts.size());
		assertEquals(2, forecast.dayForecasts.get(0).timeForecasts.size());

		assertEquals(WEATHER_DESCRIPTION_1, forecast.dayForecasts.get(0).timeForecasts.get(0).description);
		assertEquals(WEATHER_ICON_URL_1, forecast.dayForecasts.get(0).timeForecasts.get(0).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_1, forecast.dayForecasts.get(0).timeForecasts.get(0).temperature, 0.001);
		assertEquals(FORECAST_TIME_1 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(0).time.getTimeInMillis());

		assertEquals(WEATHER_DESCRIPTION_2, forecast.dayForecasts.get(0).timeForecasts.get(1).description);
		assertEquals(WEATHER_ICON_URL_2, forecast.dayForecasts.get(0).timeForecasts.get(1).iconUrl);
		assertEquals(ATMOSPHERE_TEMPERATURE_2, forecast.dayForecasts.get(0).timeForecasts.get(1).temperature, 0.001);
		assertEquals(FORECAST_TIME_2 * 1000, forecast.dayForecasts.get(0).timeForecasts.get(1).time.getTimeInMillis());
	}
}
