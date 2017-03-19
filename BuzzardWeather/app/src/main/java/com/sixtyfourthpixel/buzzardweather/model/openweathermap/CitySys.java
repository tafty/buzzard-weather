package com.sixtyfourthpixel.buzzardweather.model.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CitySys {
	@SerializedName("population")
	@Expose
	private Integer population;

	public Integer getPopulation() {
		return population;
	}

	public void setPopulation(Integer population) {
		this.population = population;
	}
}
