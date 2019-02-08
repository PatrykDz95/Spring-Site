package com.project.springsecurity.plotlyjs.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.project.springsecurity.plotlyjs.entity.WeatherTable;;
@Service
public interface IWeatherTableService {
	
	public List<WeatherTable> getWeatherTables();
	
	public void saveWeatherTable(WeatherTable theWeatherTable);
	
	public WeatherTable getWeatherTableId(int weatherTableId);

	public void deleteWeatherTable(int weatherTableId);

	public void updateWeatherTables(WeatherTable weatherTableId);
}
