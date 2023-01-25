package com.academy.model;



import com.academy.Enum.Curso;
import com.academy.Enum.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nome")
	@Size(min=4, message="O nome deve conter no mínimo 4 caracteres")
	@NotNull(message = "O campo nome não pode ser nulo")
	@NotEmpty(message = "O nome não pode ser vazio")
	private String nome;
	
	@Column(name = "curso")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo curso não pode ser nulo")
	private Curso curso;
	
	@Column(name="matricula")
	@NotNull(message = "Clique no botão Gerar!!")
	@Size(min = 3, message = "Clique no botão gerar Matricula")
	private String matricula;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	@NotNull(message = "O campo status não pode ser nulo")
	private Status status;
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	
	
	
	
	
}
