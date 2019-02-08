package com.project.springsecurity.plotlyjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.springsecurity.plotlyjs.DAO.IWeatherTableDAO;
import com.project.springsecurity.plotlyjs.entity.WeatherTable;
@Service
public class WeatherTableServiceImpl implements IWeatherTableService {

	@Autowired
	private IWeatherTableDAO weatherTableDAO;
	
	@Override
	public List<WeatherTable> getWeatherTables() {
		return weatherTableDAO.getWeatherTables();
	}

	@Override
	public void saveWeatherTable(WeatherTable theWeatherTable) {
		weatherTableDAO.addWeatherTable(theWeatherTable);

	}

	@Override
	public WeatherTable getWeatherTableId(int weatherTableId) {
		WeatherTable obj = weatherTableDAO.getWeatherTableById(weatherTableId);
		return obj;
	}


	@Override
	public void deleteWeatherTable(int weatherTableId) {
		weatherTableDAO.deleteWeatherTable(weatherTableId);
	}

	public void updateWeatherTables(WeatherTable weatherTableId) {
		 weatherTableDAO.updateWeatherTable(weatherTableId);
		
	}

}
