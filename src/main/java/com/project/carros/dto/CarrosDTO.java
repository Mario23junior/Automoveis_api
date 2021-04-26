package com.project.carros.dto;

import org.modelmapper.ModelMapper;

import com.project.carros.Model.Carro;

public class CarrosDTO {
  
	private Long id;
	private String nome;
	private String tipo;
	
	public static CarrosDTO converte(Carro carro) {
	  ModelMapper modelMapper = new ModelMapper();
	  return modelMapper.map(carro, CarrosDTO.class);
 	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
