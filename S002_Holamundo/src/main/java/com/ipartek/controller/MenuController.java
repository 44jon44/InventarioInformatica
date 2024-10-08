package com.ipartek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.repository.MovilRepository;
import com.ipartek.repository.OrdenadorRepository;

@Controller
public class MenuController {
	
	@Autowired
	private MovilRepository movilRepo;
	
	@Autowired
	private OrdenadorRepository ordenadorRepo;
	
	
	@RequestMapping("/menuInicio")
	public String opcionInicio(Model model) {
		
		model.addAttribute("atr_lista_moviles", movilRepo.findAll());
		System.out.println(movilRepo.findAll().toString());
		
		return "home";	
	}
	
	@RequestMapping("/menuMoviles")
	public String opcionMoviles(Model model) {

		model.addAttribute("atr_lista_moviles", movilRepo.findAll());
		System.out.println(movilRepo.findAll().toString());
		return "moviles";	
	}
	
	@RequestMapping("/menuOrdenadores")
	public String opcionOrdenadores(Model model) {
		
		model.addAttribute("atr_lista_ordenadores", ordenadorRepo.findAll());
		System.out.println(ordenadorRepo.findAll().toString());
		return "ordenadores";	
	}
	
	@RequestMapping("/menuContacto")
	public String opcionContacto(Model model) {
		return "contacto";	
	}
	
	
}
