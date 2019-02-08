package com.project.springsecurity.plotlyjs.DAO;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.springsecurity.plotlyjs.entity.WeatherTable;

@Repository // for compoent scanning (always add to DAO)
public class WeatherTableDAOImpl implements IWeatherTableDAO {
	
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<WeatherTable> getWeatherTables() {
		
		logger.info("Processing: getAllWeatherTables()");

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create query
		Query<WeatherTable> theQuery = currentSession.createQuery("from WeatherTable", WeatherTable.class);
		
		//getting user list
		List<WeatherTable> weatherTable = theQuery.getResultList();
		
		return weatherTable;
	}

	@Override
	@Transactional
	public WeatherTable getWeatherTableById(int weatherTableId) {
		logger.info("Processing: getWeatherTableById()");

		Session currentSession = sessionFactory.getCurrentSession();
		
		WeatherTable weatherTable = currentSession.get(WeatherTable.class, weatherTableId);
		
		return weatherTable;
	}

	@Override
	@Transactional
	public void addWeatherTable(WeatherTable weatherTable) {
		logger.info("Processing: addWeatherTable()");

		Session currentSession = sessionFactory.getCurrentSession();
						
		currentSession.save(weatherTable);		
	}

	@Override
	@Transactional
	public void updateWeatherTable(WeatherTable weatherTable) {
		logger.info("Processing: updateWeatherTable()");

		Session currentSession = sessionFactory.getCurrentSession();
				
		currentSession.saveOrUpdate(weatherTable);
		
	}

	@Override
	@Transactional
	public void deleteWeatherTable(int weatherTableId) {
		logger.info("Processing: deleteWeatherTable()");

		//get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				//delete object with primary key
				Query theQuery = currentSession.createQuery("delete from WeatherTable where id=:weather_id", WeatherTable.class);
				
				theQuery.setParameter("weather_id", weatherTableId);	
				
				theQuery.executeUpdate();		
	}

}
