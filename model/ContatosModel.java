package model;

import java.util.Calendar;

public class ContatosModel {
	private long id;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	public ContatosModel() {
		//Durante a persistencia, salvar o horário da que foi salvo o objeto.
		this.dataNascimento = Calendar.getInstance();
	}
	
	
	
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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public Calendar getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	@Override
	public String toString() {
		return "ID: " + this.id + "\nNome: " + this.nome + "\nEmail: " + this.email + "\nEndereço: " + this.endereco;
	}
}
