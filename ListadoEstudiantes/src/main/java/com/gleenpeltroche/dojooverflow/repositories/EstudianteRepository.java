package com.gleenpeltroche.dojooverflow.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.gleenpeltroche.dojooverflow.models.Estudiante;



@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
	List<Estudiante> findAll();
}