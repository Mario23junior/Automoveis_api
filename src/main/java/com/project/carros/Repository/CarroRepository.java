package com.project.carros.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.carros.Model.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long>{

}
