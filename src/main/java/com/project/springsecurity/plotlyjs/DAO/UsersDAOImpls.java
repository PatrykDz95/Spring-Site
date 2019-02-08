package com.project.springsecurity.plotlyjs.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.project.springsecurity.plotlyjs.entity.Users;
import com.project.springsecurity.plotlyjs.entity.WeatherTable;
@Repository
@Transactional
public class UsersDAOImpls implements IUserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@SuppressWarnings("deprecation")
	@Override
	public Users getActiveUser(String userName) {
		Users activeUserInfo = new Users();
		short enabled = 1;
		List<?> list = hibernateTemplate.find("from users where username=? and enabled=?",
			       userName, enabled);
		if(!list.isEmpty()) {
			activeUserInfo = (Users)list.get(0);
		}
		return activeUserInfo;
	}
} 