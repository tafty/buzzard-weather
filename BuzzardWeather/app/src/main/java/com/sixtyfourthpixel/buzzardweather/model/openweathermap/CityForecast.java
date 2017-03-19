package com.sixtyfourthpixel.buzzardweather.model.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityForecast {
	@SerializedName("city")
	@Expose
	private City city;
	@SerializedName("cod")
	@Expose
	private String cod;
	@SerializedName("message")
	@Expose
	private Double message;
	@SerializedName("cnt")
	@Expose
	private Integer cnt;
	@SerializedName("list")
	@Expose
	private java.util.List<Forecast> forecasts = null;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Double getMessage() {
		return message;
	}

	public void setMessage(Double message) {
		this.message = message;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	public java.util.List<Forecast> getForecasts() {
		return forecasts;
	}

	public void setForecast(java.util.List<Forecast> forecast) {
		this.forecasts = forecast;
	}
}
