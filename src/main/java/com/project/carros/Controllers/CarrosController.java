package com.project.carros.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.carros.Model.Carro;
import com.project.carros.Service.CarroService;

@RestController
@RequestMapping("/api/v1/automoveis")
public class CarrosController {
   
	private CarroService service;
	
	public CarrosController(CarroService service) {
	  this.service = service;
 	}
	
	@GetMapping
	public List<Carro> list(){
		return service.ListCarro();
	}
	
	@GetMapping("/{id}")
    public Optional<Carro> listId(@PathVariable Long id) {
    	return service.listIdCarro(id);
       }
	
	@GetMapping("/tipo/{tipo}")
	public Iterable<Carro> listByType(@PathVariable("tipo") String tipo){
		return service.listByType(tipo);
	}
	
	@PostMapping
	public void save(@RequestBody Carro carro) {
		 service.save(carro);
	}

}