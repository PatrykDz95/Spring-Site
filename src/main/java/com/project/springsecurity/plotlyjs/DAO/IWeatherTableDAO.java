package com.project.springsecurity.plotlyjs.DAO;

import java.util.List;

import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.springsecurity.plotlyjs.entity.WeatherTable;
@Service
public interface IWeatherTableDAO {

	public List<WeatherTable> getWeatherTables();
    WeatherTable getWeatherTableById(int weatherTableId);
    void addWeatherTable(WeatherTable weatherTable);
    void updateWeatherTable(WeatherTable weatherTable);
    void deleteWeatherTable(int weatherTableId);
 }
