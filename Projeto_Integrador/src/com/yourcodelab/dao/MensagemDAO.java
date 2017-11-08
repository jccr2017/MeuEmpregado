package com.yourcodelab.dao;

import java.io.IOException;




import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yourcodelab.model.Mensagem;



public class MensagemDAO extends GenericDAO{
	
	PreparedStatement ps;
	
	private String INSERT_MENSAGEM = "INSERT INTO tb_mensagem(nomeempresa,email,msg,idresposta,endereco,vaga,horaentrevista,data,salario,beneficios) VALUES(?, ?, ?,?,?,?,?,?,?,?);";
	private String LISTAR_MENSAGEM = "SELECT * FROM tb_mensagem;";
	private String EXCLUIR = "DELETE FROM  tb_mensagem WHERE ID=?;";
	private String ALTERAR = "UPDATE tb_mensagem SET nomeempresa= ?, email= ?, msg = ?,idresposta=?,endereco=?,vaga=?,horaentrevista=?,data=?,salario=?,beneficios=? WHERE id=?;";
	
	
	
	public void salvar(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		openConnection();
		
		ps = connect.prepareStatement(INSERT_MENSAGEM);
		
		ps.setString(1, c.getNomeempresa());
		ps.setString(2, c.getEmail());
		ps.setString(3,c.getMsg());
		ps.setString(4, c.getResposta());
		ps.setString(5,c.getEndereco());
		ps.setString(6,c.getVaga());
		ps.setString(7,c.getHoraentrevista());
		ps.setString(8,c.getData());
		ps.setString(9,c.getSalario());
		ps.setString(10,c.getBeneficios());


		
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
				
				
				
				Mensagem c = new Mensagem(rs.getInt("id"),rs.getString("nomeempresa"), rs.getString("email"), rs.getString("msg")
						,rs.getString("idresposta"),rs.getString("endereco"),rs.getString("vaga"),rs.getString("horaentrevista"),rs.getString("data"),
						rs.getString("salario"),rs.getString("beneficios"));
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
		ps.setString(4, c.getResposta());
		ps.setString(5,c.getEndereco());
		ps.setString(6,c.getVaga());
		ps.setString(7,c.getHoraentrevista());
		ps.setString(8,c.getData());
		ps.setString(9,c.getSalario());
		ps.setString(10,c.getBeneficios());
		ps.setInt(11, c.getId());
		
		
		ps.execute();
		
		closeConnection();
	}
	

}
