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
	
	public List<Empregado> findEmpregadoByCidade(String cidade) throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> list = new ArrayList<Empregado>();
		
		if(!cidade.isEmpty()) {
			list = dao.findEmpregadoByCidade(cidade);
		}
		else {
			list = dao.listAll();
		}	
		
		return list;
	}
	

}
