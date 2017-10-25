package com.yourcodelab.dao;


import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.yourcodelab.model.Empregado;
import com.yourcodelab.model.Status;


public class EmpregadoDAO extends GenericDAO{
	
PreparedStatement ps;	
//private String LISTAR_TODOS = "SELECT * FROM tb_empregado";
private String LISTAR_TODOS = "select tb_empregado.*, tb_status.description from tb_empregado inner join tb_status on tb_empregado.idstatus = tb_status.id;";



public List<Empregado> listAll() throws SQLException, ClassNotFoundException, IOException{
	List<Empregado> lista = new ArrayList<Empregado>();
	
	openConnection();
	
	ps = connect.prepareStatement(LISTAR_TODOS);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs != null) {
		while(rs.next()) {
			
			Status status= new Status(rs.getInt("id"), rs.getString("description"));
			
			Empregado c =new Empregado(rs.getInt("id"),rs.getString("nome"),rs.getString("data_nascimento"),
					rs.getString("cpf"),rs.getString("rg"),rs.getString("telefone_fixo"),rs.getString("telefone_celular"),
					rs.getString("cep"),rs.getString("endereco_rua"),rs.getString("endereco_numero"),
					rs.getString("complemento"),rs.getString("bairro"),rs.getString("cidade"),rs.getString("estado"),
					rs.getString("email"),rs.getString("senha"),status,rs.getString("sexo"));
			
				lista.add(c);
		}
	}
	
	closeConnection();
	
	return lista;
}



}
