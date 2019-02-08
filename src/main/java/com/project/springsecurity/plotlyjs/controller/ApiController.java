package com.project.springsecurity.plotlyjs.controller;

import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.project.springsecurity.plotlyjs.rest.NotFoundException;

@Controller
@RequestMapping("/api")
public class ApiController { 
		
	// steupt logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	private JSONObject obj_JSONObject;
	
	@GetMapping("/currency")
	public Object cryptoAPI(ModelMap theModel) {
		
		//display method we are calling
		myLogger.info("===>Calling cryptoAPI() method");
		
		final String btcString = "https://api.coindesk.com/v1/bpi/currentprice.json";

		try {
			
			 URL obj = new URL(btcString);
	          HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	          con.setRequestMethod("GET");
	          con.setRequestProperty("User-Agent", "Mozilla/5.0");
	          BufferedReader in = new BufferedReader(
	              new InputStreamReader(con.getInputStream()));
	          String inputLine;
	          StringBuilder response = new StringBuilder();
	          while ((inputLine = in .readLine()) != null) {
	              response.append(inputLine);
	          } 
	          in .close();
			obj_JSONObject = new JSONObject(response.toString());
		
		    float getPrice = obj_JSONObject.getJSONObject("bpi").getJSONObject("USD").getFloat("rate_float");
		    String getCurrency = obj_JSONObject.getJSONObject("bpi").getJSONObject("USD").getString("code");
		    String disclaimer = obj_JSONObject.getString("disclaimer");
		    
			theModel.addAttribute("getPrice", getPrice);
		    theModel.addAttribute("getCurrency", getCurrency);
			theModel.addAttribute("disclaimer", disclaimer);
		    
		    return "cryptoPrice";
					
				}catch(IOException e) {
					e.printStackTrace();
				}

		throw new NotFoundException("Value not found " + btcString);
		
	}
	
	private static final String API_KEY = "d3f402ba364691fc61e4a73cbe0358c2";
	private static final String LOCATION = ",pl";
	
	@GetMapping("/weather/{town}")
	public String weatherAPI(@PathVariable String town, ModelMap theModel) {
			
		myLogger.info("===>Calling weatherAPI() method");
		
		final String urlString = "http://api.openweathermap.org/data/2.5/weather?q=" + 
				 town + LOCATION + "&units=metric" + "&appid=" + API_KEY;
	try {	
	
	  URL obj = new URL(urlString);
	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	  con.setRequestMethod("GET");
	  con.setRequestProperty("User-Agent", "Mozilla/5.0");
	  BufferedReader in = new BufferedReader(
	      new InputStreamReader(con.getInputStream()));
	  String inputLine;
	  StringBuilder response = new StringBuilder();
	  while ((inputLine = in .readLine()) != null) {
	      response.append(inputLine);
	  } 
	  in .close();

	  obj_JSONObject = new JSONObject(response.toString());
	  JSONArray obj_JSONArray = obj_JSONObject.getJSONArray("weather");
	  JSONObject obj_JSONObject1 = obj_JSONArray.getJSONObject(0);
	
	  JSONObject mainObject = obj_JSONObject.getJSONObject("main");
	  float tempWeather = mainObject.getFloat("temp");
	  int pressureWeather = mainObject.getInt("pressure");
	  int humidityWeather = mainObject.getInt("humidity");
	  String descWeather = obj_JSONObject1.getString("description");
	  String nameWeather = obj_JSONObject.getString("name");
	
	  theModel.addAttribute("descWeather", descWeather);
	  theModel.addAttribute("nameWeather", nameWeather);
	  theModel.addAttribute("tempWeather", tempWeather);
	  theModel.addAttribute("pressureWeather", pressureWeather);
	  theModel.addAttribute("humidityWeather", humidityWeather);
	  
	  return "weather";		
	
	}catch(Exception e) {
		e.printStackTrace();
		myLogger.info("Exception handling in weatherAPI() method");
		}
	throw new NotFoundException("Town not found - " + town);		
	}

}
