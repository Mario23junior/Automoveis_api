package com.project.carros.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

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
	
	public void update(@RequestBody Carro carro, @PathVariable Long id) {
		    CarReposi
				.findById(id)
				.map(updateData ->{
					carro.setId(updateData.getId());
					CarReposi.save(carro);
					return updateData;
 				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NO_CONTENT,"Não foi possivel atualziar dados"));
	}
		
}
