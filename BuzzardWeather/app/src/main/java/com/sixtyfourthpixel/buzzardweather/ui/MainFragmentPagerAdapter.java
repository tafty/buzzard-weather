package com.sixtyfourthpixel.buzzardweather.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sixtyfourthpixel.buzzardweather.model.local.MultiDayForecast;
import com.sixtyfourthpixel.buzzardweather.ui.forecasts.DayForecastFragment;

import java.text.SimpleDateFormat;
import java.util.Locale;


class MainFragmentPagerAdapter extends FragmentPagerAdapter {
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("EEE d MMM", Locale.getDefault());

	private MultiDayForecast multiDayForecast;

	MainFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		if (multiDayForecast == null || position < 0 || multiDayForecast.dayForecasts.size() < position) {
			return null;
		}

		return DayForecastFragment.newInstance(multiDayForecast.dayForecasts.get(position));
	}

	@Override
	public int getCount() {
		return multiDayForecast == null ? 0 : multiDayForecast.dayForecasts.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		if (multiDayForecast == null || position < 0 || multiDayForecast.dayForecasts.size() < position) {
			return null;
		}

		return DATE_FORMAT.format(multiDayForecast.dayForecasts.get(position).date.getTime());
	}

	void setForecast(MultiDayForecast forecast) {
		multiDayForecast = forecast;

		notifyDataSetChanged();
	}
}
