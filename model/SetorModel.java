package br.com.softwrap.model;

import java.util.ArrayList;
import java.util.Date;

public class SetorModel {
	private long id;
	private String nome;
	private Date dataDeAbertura;
	FuncionarioModel funcionario;
	ArrayList<FuncionarioModel> funcionarios;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataDeAbertura() {
		return dataDeAbertura;
	}
	public void setDataDeAbertura(Date dataDeAbertura) {
		this.dataDeAbertura = dataDeAbertura;
	}
	public FuncionarioModel getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(FuncionarioModel funcionario) {
		this.funcionario = funcionario;
	}
}