package com.yourcodelab.bean; 

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.yourcodelab.model.Empregado;
import com.yourcodelab.model.Status;
import com.yourcodelab.service.EmpregadoService;

@ManagedBean(name="empregadoManagedBean")
@SessionScoped


public class EmpregadoManagedBean {
	
	//Teste
	
	private Empregado empregado;
	private List<Empregado> listEmpregado;
	private EmpregadoService serviceempregado;
	private Status status;
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public EmpregadoManagedBean() throws ClassNotFoundException, SQLException, IOException{
		
		serviceempregado = new EmpregadoService();
		empregado = new Empregado(0, "", "","", "","", "","", "","", "","", "","", "","",status,"","");
		
		listEmpregado = serviceempregado.listAll();
		
	}
	
	
	
	public String searchByCidadeAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregado = serviceempregado.findEmpregadoByCidade(empregado.getCidade());
		
		return "indexEMPREGADOR";
	}
	
	public String ListarTudo() throws SQLException, ClassNotFoundException, IOException{
		
		this.listEmpregado = serviceempregado.listAll();
		
		return "indexEMPREGADOR";
	}
	
	

	//////////////////////////////////////////
	
	/*
	
	public String searchByNameAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listCustomer = service.findCustomerByName(customer.getName());
		
		return "index";
	}
	
	public String insertCustomerAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		service.insertCustomer(customer);
		
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String updateCustomerAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Updating...");
		service.updateCustomer(customer);
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String deleteCustomerAction() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Deleting...");
		service.deleteCustomer(customer);
		listCustomer = service.listAll();
		
		return "index";
	}
	

	*/
	
	/////////////////////////////////////////////
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}

	public List<Empregado> getListEmpregado() {
		
		
		return listEmpregado;
		
		
	}

	public void setListEmpregado(List<Empregado> listEmpregado) {
		this.listEmpregado = listEmpregado;
	}
	

}
