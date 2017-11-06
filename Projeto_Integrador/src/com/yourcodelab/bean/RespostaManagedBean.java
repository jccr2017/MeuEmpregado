package com.yourcodelab.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.yourcodelab.model.Resposta;
import com.yourcodelab.service.RespostaService;

@ManagedBean(name = "respostaManagedBean")
@SessionScoped
public class RespostaManagedBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Resposta Resposta;
	private List<Resposta> listResposta;
	private RespostaService service;
	
	public RespostaManagedBean() throws ClassNotFoundException, IOException {
		Resposta = new Resposta(0, "");
		service = new RespostaService();
		listResposta = service.listAll();
	}

	public Resposta getResposta() {
		return Resposta;
	}

	public void setResposta(Resposta Resposta) {
		this.Resposta = Resposta;
	}

	public List<Resposta> getListResposta() {
		return listResposta;
	}

	public void setListResposta(List<Resposta> listResposta) {
		this.listResposta = listResposta;
	}

	
	
	

}
