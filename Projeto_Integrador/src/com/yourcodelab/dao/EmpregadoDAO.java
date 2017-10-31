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


private String PROCURAR_NOME = "SELECT cs.id, cs.nome, cs.data_nascimento,cs.cpf,cs.rg"
		+ ",cs.telefone_fixo,cs.telefone_celular,cs.cep,cs.endereco_rua,cs.endereco_numero,cs.complemento"
		+ ",cs.bairro,cs.cidade,cs.estado,cs.email,cs.senha,cs.sexo,ct.id,ct.description FROM tb_empregado cs"
		+ ",tb_status ct WHERE cs.nome LIKE ? AND cs.idstatus= ct.id";


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

//////////////////////////////////////////////////////////////////////////////////////////////


public List<Empregado> findEmpregadoByName(String nome) throws ClassNotFoundException, SQLException, IOException{
	
	openConnection();
	
	List<Empregado> lista=new ArrayList<Empregado>();
	
	ps=connect.prepareStatement(PROCURAR_NOME);
	
    ps.setString(1,"%"+nome+"%");
	//ps.setString(0, name);
	
	ResultSet rs = ps.executeQuery();
	
	while(rs.next()){
		
		Empregado c=new Empregado();
		
		c.setId(rs.getInt("cs.id"));
		c.setNome(rs.getString("cs.nome"));
		c.setData_nascimento(rs.getString("cs.data_nascimento"));
		c.setCpf(rs.getString("cs.cpf"));
		c.setRg(rs.getString("cs.rg"));
		c.setTelefone_fixo(rs.getString("cs.telefone_fixo"));
		c.setTelefone_celular(rs.getString("cs.telefone_celular"));
		c.setCep(rs.getString("cs.cep"));
		c.setEndereco_rua(rs.getString("cs.endereco_rua"));
		c.setEndereco_numero(rs.getString("cs.endereco_numero"));
		c.setComplemento(rs.getString("cs.complemento"));
		c.setBairro(rs.getString("cs.bairro"));
		c.setCidade(rs.getString("cs.cidade"));
		c.setEstado(rs.getString("cs.estado"));
		c.setEmail(rs.getString("cs.email"));
		c.setSenha(rs.getString("cs.senha"));
		c.setNome(rs.getString("cs.nome"));
		c.setStatus(new Status(rs.getInt("ct.id"), rs.getString("ct.description")));
		c.setSexo(rs.getString("cs.sexo"));

		lista.add(c);
		
	}
	
	return lista;
	
}


}
