package com.gleenpeltroche.dojooverflow.controllers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gleenpeltroche.dojooverflow.Services.ClaseService;
import com.gleenpeltroche.dojooverflow.Services.EstudianteService;
import com.gleenpeltroche.dojooverflow.models.Clase;
import com.gleenpeltroche.dojooverflow.models.Estudiante;


@Controller
public class MainController {
	@Autowired
	EstudianteService estudianteService;
	@Autowired
	ClaseService claseService;

	
	@GetMapping("/classes/new")
	public String clasenew() {
		return "agregaClase.jsp";
	}
	
	@PostMapping("/classes/save")
	public String clasesave(
			@RequestParam("nombre") String nombre,
			RedirectAttributes redirectAttributes
			) {
		if(nombre.equals("")) {
			redirectAttributes.addFlashAttribute("error_vacio", "Error: Llena el nombre de la clase");
			return "redirect:/classes/new";
		}
		Clase clase = new Clase();
		clase.setNombre(nombre);
		claseService.saveClase(clase);
		redirectAttributes.addFlashAttribute("exito", "La clase fue guardada exitosamente");
		return "redirect:/classes/new";
	}
	
	@GetMapping("/students/new")
	public String estudiantenew() {
		return "agregaEstudiante.jsp";
	}
	
	@PostMapping("/students/save")
	public String estudiantesave(
			@RequestParam("nombre") String nombre,
			RedirectAttributes redirectAttributes
			) {
		if(nombre.equals("")) {
			redirectAttributes.addFlashAttribute("error_vacio", "Error: Llena el nombre del estudiante");
			return "redirect:/students/new";
		}
		Estudiante estudiante = new Estudiante();
		estudiante.setNombre(nombre);
		estudianteService.saveEstudiante(estudiante);
		redirectAttributes.addFlashAttribute("exito", "El estudiante fue guardado exitosamente");
		return "redirect:/students/new";
	}
	
	@GetMapping("/classes/{id}")
	public String clasebyid(Model model, @PathVariable("id") Long id) {
		Clase clase = claseService.getClaseById(id);
		if(clase == null) {
			return "redirect:/classes/new";
		}
		System.out.println(clase.getEstudiantes().size());
		model.addAttribute("clase", clase);
		return "muestraClase.jsp";
	}
	
	@GetMapping("/students/{id}")
	public String estudiantebyid(Model model, @PathVariable("id") Long id) {
		Estudiante estudiante = estudianteService.getEstudianteById(id);
		if(estudiante == null) {
			return "redirect:/students/new";
		}
		List<Clase> clases = claseService.getAllClases();
		model.addAttribute("estudiante", estudiante);
		model.addAttribute("clases", clases);
		return "muestraEstudiante.jsp";
	}
	
	@PostMapping("/classes/savenewclass")
	public String estudiantesaveclass(
			@RequestParam("id_estudiante") Long id_estudiante,
			@RequestParam("id_clase") Long id_clase,
			RedirectAttributes redirectAttributes
			) {
		Estudiante estudiante = estudianteService.getEstudianteById(id_estudiante);
		Clase clase = claseService.getClaseById(id_clase);
		estudiante.getClases().add(clase);
		estudianteService.saveEstudiante(estudiante);
		return "redirect:/students/"+id_estudiante;
	}
	
	@PostMapping("/classes/dropclass")
	public String estudiantedropclass(
			@RequestParam("id_estudiante") Long id_estudiante,
			@RequestParam("id_clase") Long id_clase,
			RedirectAttributes redirectAttributes
			) {
		Estudiante estudiante = estudianteService.getEstudianteById(id_estudiante);
		for (int i = 0; i < estudiante.getClases().size(); i++) {
			if(estudiante.getClases().get(i).getId() == id_clase){
				estudiante.getClases().remove(i);
			}
		}
		estudianteService.saveEstudiante(estudiante);
		return "redirect:/students/"+id_estudiante;
	}
}
