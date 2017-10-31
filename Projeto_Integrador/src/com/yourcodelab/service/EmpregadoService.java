package com.yourcodelab.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.dao.EmpregadoDAO;
import com.yourcodelab.model.Empregado;


public class EmpregadoService {
	
	EmpregadoDAO dao=new EmpregadoDAO();
	
	public List<Empregado> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> list = new ArrayList<Empregado>();
			
		list = dao.listAll();
		
		return list;
	}
	
	public List<Empregado> findEmpregadoByName(String nome) throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> list = new ArrayList<Empregado>();
		
		if(!nome.isEmpty()) {
			list = dao.findEmpregadoByName(nome);
		}
		else {
			list = dao.listAll();
		}	
		
		return list;
	}
	

}
