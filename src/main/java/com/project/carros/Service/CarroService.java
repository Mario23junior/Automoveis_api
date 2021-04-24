package com.project.carros.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.carros.Model.Carro;
import com.project.carros.Repository.CarroRepository;

@Service
public class CarroService {
    
	@Autowired
	private CarroRepository CarReposi;
	 
	public List<Carro> ListCarro() {
		return CarReposi.findAll();
	}
	
}
