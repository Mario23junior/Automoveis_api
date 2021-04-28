package com.project.carros;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.carros.Model.Carro;
import com.project.carros.Service.CarroService;

@SpringBootTest
class CarrosApplicationTests {
    
	@Autowired
	private CarroService service;
	
	@Test
	@DisplayName("Testando cadastro de carros")
	void createCar() {
	    
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("luxo");
		
		service.save(carro);
	}

}
