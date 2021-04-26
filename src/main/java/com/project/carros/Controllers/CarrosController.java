package com.project.carros.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.carros.Model.Carro;
import com.project.carros.Service.CarroService;
import com.project.carros.dto.CarrosDTO;

@RestController
@RequestMapping("/api/v1/automoveis")
public class CarrosController {
   
	private CarroService service;
	
	
	public CarrosController(CarroService service) {
	  this.service = service;
 	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CarrosDTO> list(){
		return service.ListCarro();
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<CarrosDTO> listId(@PathVariable Long id) {
    	
		Optional<CarrosDTO> carro = service.listIdCarro(id);
		
		return carro.map(c -> 
		               ResponseEntity.ok(c))
	                  .orElse(ResponseEntity.notFound()
	                  .build());
	     
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<CarrosDTO>> listByType(@PathVariable("tipo") String tipo){
		List<CarrosDTO> carros = service.listByType(tipo);
		
		return carros.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(carros);
			
	}
	
	@PostMapping
	public void save(@RequestBody Carro carro) {
		 service.save(carro);
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @RequestBody Carro carro) {
		service.update(carro, id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CarrosDTO> delete(@PathVariable Long id) {
		service.delete(id);
        return ResponseEntity.ok().build();
	}

}