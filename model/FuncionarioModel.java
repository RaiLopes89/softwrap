package br.com.softwrap.model;

import java.util.Date;

public class FuncionarioModel {
	private long id;
	private String nome;
	private Enum cargo;
	private SetorModel setor;
	private double salarioBase;
	private Date entrada;
	private Enum status;
	
	
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
	public Enum getCargo() {
		return cargo;
	}
	public void setCargo(Enum cargo) {
		this.cargo = cargo;
	}
	public SetorModel getSetor() {
		return setor;
	}
	public void setSetor(SetorModel setor) {
		this.setor = setor;
	}
	public double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Enum getStatus() {
		return status;
	}
	public void setStatus(Enum status) {
		this.status = status;
	}
	
}