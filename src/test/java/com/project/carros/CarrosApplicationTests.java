package com.project.carros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.carros.Model.Carro;
import com.project.carros.Service.CarroService;
import com.project.carros.dto.CarrosDTO;

@SpringBootTest
class CarrosApplicationTests {
    
	@Autowired
	private CarroService service;
	
	@Test
	@DisplayName("Testando cadastro de carros")
	void testeSave() {
	    
		Carro carro = new Carro();
		carro.setNome("Ferrari");
		carro.setTipo("luxo");
		
		CarrosDTO c = service.save(carro);
		
		assertNotNull(c);
		
		Long id = c.getId();
		assertNotNull(id);
		
		// deletando objeto
		
		Optional<CarrosDTO> find = service.listIdCarro(id);
		assertTrue(find.isPresent());
		
		c = find.get();
		assertEquals("Ferrari", c.getNome());
		assertEquals("luxo", c.getTipo());
		
		service.delete(id);
		
		// verificando se o objeto foi deletado
		assertFalse(service.listIdCarro(id).isPresent());
	}
	
	

}
