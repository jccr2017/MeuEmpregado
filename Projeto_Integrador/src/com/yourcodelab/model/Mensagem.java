package com.yourcodelab.model;

public class Mensagem {
	
	private int id;
	private String nomeempresa;
	private String email;
	private String msg;
	private Resposta resposta;
	private String endereco;
	private String vaga;
	private String horaentrevista;
	private String data;
	
	
	
	
	
	public Mensagem(){
		
	}
	

	public Mensagem(int id, String nomeempresa, String email, String msg, Resposta resposta, String endereco,
			String vaga, String horaentrevista,String data) {
		super();
		this.id = id;
		this.nomeempresa = nomeempresa;
		this.email = email;
		this.msg = msg;
		this.resposta = resposta;
		this.endereco = endereco;
		this.vaga = vaga;
		this.horaentrevista = horaentrevista;
		this.data=data;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeempresa() {
		return nomeempresa;
	}
	public void setNomeempresa(String nomeempresa) {
		this.nomeempresa = nomeempresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getVaga() {
		return vaga;
	}
	public void setVaga(String vaga) {
		this.vaga = vaga;
	}
	public String getHoraentrevista() {
		return horaentrevista;
	}
	public void setHoraentrevista(String horaentrevista) {
		this.horaentrevista = horaentrevista;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	

	

}
