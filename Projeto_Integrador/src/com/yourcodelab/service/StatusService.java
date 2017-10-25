package com.yourcodelab.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.yourcodelab.dao.StatusDAO;
import com.yourcodelab.model.Status;


public class StatusService {
	
	StatusDAO dao = new StatusDAO();
	
	public List<Status> listAll() throws ClassNotFoundException, IOException{
		try {
			return dao.listAll();
		} catch (SQLException e) {
			return null;
		}
	}

}
