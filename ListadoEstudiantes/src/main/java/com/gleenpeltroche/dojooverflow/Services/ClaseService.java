package com.gleenpeltroche.dojooverflow.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gleenpeltroche.dojooverflow.models.Clase;
import com.gleenpeltroche.dojooverflow.repositories.ClaseRepository;

@Service
public class ClaseService {
	@Autowired
	ClaseRepository claseRepository;
	
	public List<Clase> getAllClases() {
	    return claseRepository.findAll();
	}
	public void saveClase(Clase clase) {
		claseRepository.save(clase);
	}
	public Clase getClaseById(Long id) {
	    Optional<Clase> optionalClase = claseRepository.findById(id);
	    if(optionalClase.isPresent()) {
	        return optionalClase.get();
	    } else {
	        return null;
	    }
	}
}
