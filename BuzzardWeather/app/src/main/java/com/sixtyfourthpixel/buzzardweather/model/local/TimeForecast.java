package com.sixtyfourthpixel.buzzardweather.model.local;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

public class TimeForecast implements Parcelable {
	public final Calendar time;
	public final double temperature;
	public final String description;
	public final String iconUrl;
	public final double windSpeed;
	public final double windAngle;

	public TimeForecast(Calendar time, double temperature, double windSpeed, double windAngle, String description, String icon) {
		this.time = time;
		this.temperature = temperature;
		this.description = description;
		this.iconUrl = icon;
		this.windSpeed = windSpeed;
		this.windAngle = windAngle;
	}

	private TimeForecast(Parcel in) {
		this.time = Calendar.getInstance();
		this.time.setTimeInMillis(in.readLong());
		temperature = in.readDouble();
		windSpeed = in.readDouble();
		windAngle = in.readDouble();
		description = in.readString();
		iconUrl = in.readString();
	}

	public static final Creator<TimeForecast> CREATOR = new Creator<TimeForecast>() {
		@Override
		public TimeForecast createFromParcel(Parcel in) {
			return new TimeForecast(in);
		}

		@Override
		public TimeForecast[] newArray(int size) {
			return new TimeForecast[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {
		parcel.writeLong(time.getTimeInMillis());
		parcel.writeDouble(temperature);
		parcel.writeDouble(windSpeed);
		parcel.writeDouble(windAngle);
		parcel.writeString(description);
		parcel.writeString(iconUrl);
	}
}
