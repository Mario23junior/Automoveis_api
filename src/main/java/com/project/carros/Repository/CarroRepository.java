package com.project.carros.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.carros.Model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{
 
	List<Carro> findByTipo(String tipo);
}
