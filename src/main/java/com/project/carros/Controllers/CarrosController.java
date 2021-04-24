package com.project.carros.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.carros.Model.Carro;
import com.project.carros.Service.CarroService;

@RestController
@RequestMapping("/api/v1/automoveis/")
public class CarrosController {
   
	private CarroService service;
	
	public CarrosController(CarroService service) {
	  this.service = service;
 	}
	
	@GetMapping
	public List<Carro> list(){
		return service.ListCarro();
	}
}
