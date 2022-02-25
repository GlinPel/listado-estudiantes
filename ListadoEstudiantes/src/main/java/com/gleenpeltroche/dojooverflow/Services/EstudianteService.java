package com.gleenpeltroche.dojooverflow.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gleenpeltroche.dojooverflow.models.Estudiante;
import com.gleenpeltroche.dojooverflow.repositories.EstudianteRepository;

@Service
public class EstudianteService{
	
	@Autowired
	EstudianteRepository estudianteRepository;
	
	public List<Estudiante> getAllEstudiantes() {
	    return estudianteRepository.findAll();
	}
	public Estudiante saveEstudiante(Estudiante question) {
	    return estudianteRepository.save(question);
	}
	public Estudiante getEstudianteById(Long id) {
	    Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
	    if(optionalEstudiante.isPresent()) {
	        return optionalEstudiante.get();
	    } else {
	        return null;
	    }
	}
}

