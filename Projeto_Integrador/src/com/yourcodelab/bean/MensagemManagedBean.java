package com.yourcodelab.bean;

import java.io.IOException;



import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Mensagem;
import com.yourcodelab.model.Resposta;
import com.yourcodelab.service.MensagemService;

@ManagedBean(name="mensagemManagedBean")
@SessionScoped


public class MensagemManagedBean {
	
	private Mensagem Mensagem;
	private List<Mensagem> listMensagem;
	private MensagemService service;
	private Resposta resposta;
	
	
	
	public MensagemManagedBean() throws SQLException, ClassNotFoundException, IOException{
		
		
		
		service = new MensagemService();
		
		resposta = new Resposta(0, "");
		
		Mensagem = new Mensagem(0,"", "", "",resposta,"","","","");
		
		listMensagem = service.listAll();
		
		
	}
	
	
	///////////////////////////insert
	public String insertMensagemAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		service.insertMensagem(Mensagem);
		
		this.listMensagem = service.listAll();
		
		return "indexEMPREGADOR";
	}
	
	
	
	//////////////////////////delete
	
	public String deleteMensagemAction() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Deleting...");
		service.deleteMensagem(Mensagem);
		
		listMensagem = service.listAll();
		
		return "indexEMPREGADOR";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	///////update
	public String updateMensagemAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Updating...");
		
		service.updateMensagem(Mensagem);
		
		this.listMensagem = service.listAll();
		
		
		
		return "listamensagemEMPREGADO";
		
	
		
	}

	////////////////////////////////////////
	public Mensagem getMensagem() {
		return Mensagem;
	}

	public void setMensagem(Mensagem Mensagem) {
		this.Mensagem = Mensagem;
	}

	public List<Mensagem> getListMensagem() {
		
		
		return listMensagem;
		
		
	}

	public void setListMensagem(List<Mensagem> listMensagem) {
		this.listMensagem = listMensagem;
	}
	
	///////////////////////////////////////////
	
	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta Resposta) {
		this.resposta = Resposta;
	}

}