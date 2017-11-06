package com.yourcodelab.service;

import java.io.IOException;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.dao.MensagemDAO;

import com.yourcodelab.model.Mensagem;



public class MensagemService {
	
	MensagemDAO dao= new MensagemDAO();
	
	public List<Mensagem> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Mensagem> list = new ArrayList<Mensagem>();
			
		list = dao.listAll();
		
		return list;
	}
	
	
	
	public void insertMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException{
		dao.salvar(c);
	}
	
	
	public void deleteMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		dao.delete(c);
	}
	
	public void updateMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		dao.update(c);
	}

}
