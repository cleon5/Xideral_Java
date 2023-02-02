package com.libros.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.libros.spring.entity.Libro;
import com.libros.spring.service.LibroService;

@Controller
@RequestMapping("/libro") //Es la forma en entrar al controller
public class LibroController {

	// need to inject our customer service  
	@Autowired
	private LibroService libroService;
	
	@GetMapping("/list") 
	public String listLibro(Model theModel) {
		
		// get customers from the service
		List<Libro> libro = libroService.getLibros();
				
		// add the customers to the model
		theModel.addAttribute("libros", libro);
		
		return "list-libros";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Libro libro = new Libro();
		
		theModel.addAttribute("libro", libro);
		
		return "libros-form";
	}
	
	@PostMapping("/saveLibro")
	public String saveLibro(@ModelAttribute("libro") Libro libro) {
		
		// save the customer using our service
		libroService.saveLibro(libro);	
		
		return "redirect:/libro/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("libroId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Libro libro = libroService.getLibro(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("libro", libro);
		
		// send over to our form		
		return "libros-form";
	}
	
	@GetMapping("/delete")
	public String deleteLibro(@RequestParam("libroId") int theId) {
		
		// delete the customer
		libroService.deleteLibro(theId);
		
		return "redirect:/libro/list";
	}
}










