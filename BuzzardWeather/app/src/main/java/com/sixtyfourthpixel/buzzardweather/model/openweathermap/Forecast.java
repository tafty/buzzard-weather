package com.sixtyfourthpixel.buzzardweather.model.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Forecast {
	@SerializedName("dt")
	@Expose
	private Long date;
	@SerializedName("main")
	@Expose
	private Atmosphere atmosphere;
	@SerializedName("weather")
	@Expose
	private java.util.List<Weather> weather = null;
	@SerializedName("clouds")
	@Expose
	private Clouds clouds;
	@SerializedName("wind")
	@Expose
	private Wind wind;
	@SerializedName("rain")
	@Expose
	private Rain rain;
	@SerializedName("sys")
	@Expose
	private ForecastSys sys;
	@SerializedName("dt_txt")
	@Expose
	private String dateText;

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	public java.util.List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(java.util.List<Weather> weather) {
		this.weather = weather;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Rain getRain() {
		return rain;
	}

	public void setRain(Rain rain) {
		this.rain = rain;
	}

	public ForecastSys getSys() {
		return sys;
	}

	public void setSys(ForecastSys sys) {
		this.sys = sys;
	}

	public String getDateText() {
		return dateText;
	}

	public void setDateText(String dateText) {
		this.dateText = dateText;
	}
}
