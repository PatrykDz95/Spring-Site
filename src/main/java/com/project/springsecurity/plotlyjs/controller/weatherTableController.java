package com.project.springsecurity.plotlyjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springsecurity.plotlyjs.DAO.IWeatherTableDAO;
import com.project.springsecurity.plotlyjs.entity.WeatherTable;
import com.project.springsecurity.plotlyjs.service.IWeatherTableService;
import com.project.springsecurity.plotlyjs.service.WeatherTableServiceImpl;

@Controller
@RequestMapping("/weather")
public class weatherTableController {

	//inject the weather dao
	@Autowired
	private IWeatherTableService weatherTableService;
	
	//responding only to get requests
		@GetMapping("/list")
		public String listCustomer(Model theModel) {
			
			//get customers from service
			List<WeatherTable> theWeatherTable = weatherTableService.getWeatherTables();
			
			//add the customers to the model
			theModel.addAttribute("weatherTable", theWeatherTable);
			
			return "list-weather";
		}
	
	@RequestMapping("/weatherTable")
	public String listWeather(Model theModel) {
		
		//get user from dao
		List<WeatherTable> theWeatherTable = weatherTableService.getWeatherTables();
		//add the user to the model
		theModel.addAttribute("weatherTable", theWeatherTable);
		
		return "list-weather";
	}
	
	
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		WeatherTable theweatherTable = new WeatherTable();
		
		theModel.addAttribute("weathertable", theweatherTable);
		
		return "list-weather";
	}
	
	@PostMapping("/saveWeather")
	public String saveCustomer(@ModelAttribute("weathertable") WeatherTable theWeatherTable) {
		
		//save the customer using our service
		weatherTableService.saveWeatherTable(theWeatherTable);
		
		return "redirect:/weather/list";
	}
	
	@GetMapping("/showFormForUpdate")
		public String showFormForUpdate(@RequestParam("weatherId") int weatherTableId, Model theModel) {
			
			//get the customer from the our Service
			WeatherTable theWeatherTable = weatherTableService.getWeatherTableId(weatherTableId);
			
			//set customer as a model attribute to pre-populate the form
			theModel.addAttribute("weathertable", theWeatherTable);
			
			//send over to our form
			return "list-weather";					
		}
	
	@DeleteMapping("/delete/{weatherId}")
	public String deleteCustomer(@PathVariable("weatherId") int weatherTableId) {
		
		//delete the customer
		weatherTableService.deleteWeatherTable(weatherTableId);
		
		return "redirect:/weather/list";
		
	}
}  
