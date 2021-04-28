package com.project.carros;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
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
	 
	@Test
	@DisplayName("Listando dados do banco de dados")
	public void listByIdAll() {
		List<CarrosDTO> listCarros = service.ListCarro();
		
		assertEquals(30, listCarros.size());	
	}
	@Test
	@DisplayName("testando buscar por id")
	public void listById() {
		
		Optional<CarrosDTO> listById = service.listIdCarro(11L);
		assertTrue(listById.isPresent());
		
		CarrosDTO c = listById.get();
		
		assertEquals("Ferrari FF", c.getNome());
	}
	
	@Test
	@DisplayName("Testando listagem por tipo")
	public void listType() {
	   
		List<CarrosDTO> carrosList1 = service.listByType("luxo");
		List<CarrosDTO> carrosList2 = service.listByType("classicos");
		List<CarrosDTO> carrosList3 = service.listByType("esportivos");
		
		List<CarrosDTO> carrosList4 = service.listByType("x");
		
		assertEquals(10, carrosList1.size());
		assertEquals(10, carrosList2.size());
		assertEquals(10, carrosList3.size());
		
		assertEquals(0, carrosList4.size());


	}
}
