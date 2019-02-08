package com.project.springsecurity.plotlyjs.DAO;

import com.project.springsecurity.plotlyjs.entity.Users;

public interface IUserDAO {
	Users getActiveUser(String userName);
} 