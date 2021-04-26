package com.project.carros.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import com.project.carros.Model.Carro;
import com.project.carros.Repository.CarroRepository;
import com.project.carros.dto.CarrosDTO;

@Service
public class CarroService {
    
	@Autowired
	private CarroRepository CarReposi;
	 
	public List<CarrosDTO> ListCarro() {
		List<Carro> carros = CarReposi.findAll();
		List<CarrosDTO> listCarros = carros.stream().map(carroConvert -> CarrosDTO.converte(carroConvert))
		                           .collect(Collectors.toList());
		
		return listCarros;
 	}
	
	public Optional<CarrosDTO> listIdCarro(@PathVariable Long id){
		return CarReposi.findById(id).map(carroConvert -> CarrosDTO.converte(carroConvert));
		
		
	}
	
	public List<CarrosDTO> listByType(String tipo){
		 
		 return CarReposi.findByTipo(tipo)
				  .stream()
				  .map(carroConvert -> CarrosDTO.converte(carroConvert)).collect(Collectors.toList());
	}


	public CarrosDTO save(Carro carro) {
		return CarrosDTO.converte(CarReposi.save(carro));
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
	
	public void delete(Long id) {		  		  
		  if(listIdCarro(id).isPresent()) {
			  CarReposi.deleteById(id);
		  }
     }
}
