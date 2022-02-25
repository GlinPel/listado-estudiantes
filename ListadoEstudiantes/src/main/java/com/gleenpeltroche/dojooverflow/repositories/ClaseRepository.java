package com.gleenpeltroche.dojooverflow.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gleenpeltroche.dojooverflow.models.Clase;

@Repository
public interface ClaseRepository extends CrudRepository<Clase, Long> {
	List<Clase> findAll();
}
