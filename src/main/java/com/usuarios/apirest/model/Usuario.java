package com.usuarios.apirest.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Constraint;
import javax.validation.constraints.NotNull;
import javax.xml.crypto.Data;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_USUARIOS")
public class Usuario implements Serializable {
	
	private static final long serialVersionID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull(message ="Nome é Obrigatório")
	private String nome;

	@CPF(message = "CPF Inválido")
	@NotNull(message ="Nome é Obrigatório")
	private String cpf;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@NotNull(message ="Nome é Obrigatório")
	private String data_nascimento;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private String data_cadastro;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private String data_atualizacao;
	
	private boolean deletado;

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(String data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(String data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}
	
	
	
	
	
}
