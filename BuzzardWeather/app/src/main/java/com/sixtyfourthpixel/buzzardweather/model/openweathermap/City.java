package com.sixtyfourthpixel.buzzardweather.model.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {
	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("coord")
	@Expose
	private Coordinates coordinates;
	@SerializedName("country")
	@Expose
	private String country;
	@SerializedName("population")
	@Expose
	private Integer population;
	@SerializedName("sys")
	@Expose
	private CitySys citySys;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}

	public CitySys getCitySys() {
		return citySys;
	}

	public void setCitySys(CitySys citySys) {
		this.citySys = citySys;
	}
}
