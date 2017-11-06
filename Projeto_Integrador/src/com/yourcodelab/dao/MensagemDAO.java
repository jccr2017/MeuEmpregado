package com.yourcodelab.dao;

import java.io.IOException;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Mensagem;
import com.yourcodelab.model.Resposta;


public class MensagemDAO extends GenericDAO{
	
	PreparedStatement ps;
	
	private String INSERT_MENSAGEM = "INSERT INTO tb_mensagem(nomeempresa,email,msg,idresposta,endereco,vaga,horaentrevista,data) VALUES(?, ?, ?,?,?,?,?,?);";
	private String LISTAR_MENSAGEM = "select tb_mensagem.*, tb_resposta.id as idResposta, tb_resposta.description from tb_mensagem inner join tb_resposta on tb_mensagem.idresposta = tb_resposta.id;";
	private String EXCLUIR = "DELETE FROM  tb_mensagem WHERE ID=?;";
	private String ALTERAR = "UPDATE tb_mensagem SET nomeempresa= ?, email= ?, msg = ?,idresposta=?,endereco=?,vaga=?,horaentrevista=?,data=? WHERE id=?;";
	//private String teste = "DELETE FROM  tb_mensagem WHERE ID=?;";
	
	
	public void salvar(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		openConnection();
		
		ps = connect.prepareStatement(INSERT_MENSAGEM);
		
		ps.setString(1, c.getNomeempresa());
		ps.setString(2, c.getEmail());
		ps.setString(3,c.getMsg());
		ps.setInt(4, c.getResposta().getId());
		ps.setString(5,c.getEndereco());
		ps.setString(6,c.getVaga());
		ps.setString(7,c.getHoraentrevista());
		ps.setString(8,c.getData());


		
		ps.execute();
		
		closeConnection();
	}
	
	///////////////////////////////////
	
	public List<Mensagem> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Mensagem> lista = new ArrayList<Mensagem>();
		
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_MENSAGEM);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				Resposta resposta= new Resposta(rs.getInt("idResposta"), rs.getString("description"));
				
				Mensagem c = new Mensagem(rs.getInt("id"),rs.getString("nomeempresa"), rs.getString("email"), rs.getString("msg")
						,resposta,rs.getString("endereco"),rs.getString("vaga"),rs.getString("horaentrevista"),rs.getString("data"));
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	/////////////////////////////////////////////////////////
	
	public void delete(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		openConnection();
		
		ps = connect.prepareStatement(EXCLUIR);
		ps.setInt(1, c.getId());
		
		ps.execute();
		
		closeConnection();
	}
	///////////////////////////////////////////////////////////////
	
	public void update(Mensagem c) throws SQLException, ClassNotFoundException, IOException{
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR);
		
		ps.setString(1, c.getNomeempresa());
		ps.setString(2, c.getEmail());
		ps.setString(3,c.getMsg());
		ps.setInt(4, c.getResposta().getId());
		ps.setString(5,c.getEndereco());
		ps.setString(6,c.getVaga());
		ps.setString(7,c.getHoraentrevista());
		ps.setString(8,c.getData());
		ps.setInt(9, c.getId());
		
		
		ps.execute();
		
		closeConnection();
	}
	

}
