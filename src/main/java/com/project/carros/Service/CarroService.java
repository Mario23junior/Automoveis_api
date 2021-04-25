package com.project.carros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.carros.Model.Carro;
import com.project.carros.Repository.CarroRepository;

@Service
public class CarroService {
    
	@Autowired
	private CarroRepository CarReposi;
	 
	public List<Carro> ListCarro() {
		return CarReposi.findAll();
	}
	
	public Optional<Carro> listIdCarro(@PathVariable Long id){
		return CarReposi.findById(id);
	}
	
	public Iterable<Carro> listByType(String tipo){
		return CarReposi.findByTipo(tipo);
	}

	public Carro save(Carro carro) {
		return CarReposi.save(carro);
	}
		
}
