package com.sixtyfourthpixel.buzzardweather.model.local;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DayForecast implements Parcelable {
	public final List<TimeForecast> timeForecasts = new ArrayList<>();
	public final Calendar date;

	public DayForecast(Calendar date) {
		this.date = date;
	}

	private DayForecast(Parcel in) {
		this.date = Calendar.getInstance();
		this.date.setTimeInMillis(in.readLong());
		in.readList(this.timeForecasts, List.class.getClassLoader());
	}

	public static final Creator<DayForecast> CREATOR = new Creator<DayForecast>() {
		@Override
		public DayForecast createFromParcel(Parcel in) {
			return new DayForecast(in);
		}

		@Override
		public DayForecast[] newArray(int size) {
			return new DayForecast[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int flags) {
		parcel.writeLong(date.getTimeInMillis());
		parcel.writeList(timeForecasts);
	}
}
