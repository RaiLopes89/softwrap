package model;

import java.util.Date;

import Enum.Cargo;
import Enum.Status;


public class FuncionarioModel {
	private long id;
	private String nome;
	private Cargo cargo;
	private SetorModel setor;
	private double salarioBase;
	private Date entrada;
	private Status status;
	
	
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
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}