package com.ipartek.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ipartek.model.Movil;
import com.ipartek.repository.MarcaRepository;
import com.ipartek.repository.MovilRepository;

@Controller
public class AdminController {
	
	@Autowired
	private MarcaRepository marcaRepo;
	
	@Autowired
	private MovilRepository movilRepo;
	
	@RequestMapping("/superuser")
	public String cargarSeccionAdmin(Model model) {
		
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());
		model.addAttribute("atr_lista_moviles", movilRepo.findAll());
		
		model.addAttribute("obj_movil", new Movil());
		
		System.out.println(marcaRepo.findAll().toString());
		System.out.println(movilRepo.findAll().toString());
		
		return "admin";
	}
	
	@RequestMapping("/adminGuardarMovil")
	public String guardarMovilAdmin(Model model,@ModelAttribute("obj_movil") Movil mov) {
		
		movilRepo.save(mov);
		
		
		return "redirect:/superuser";
	}
	@RequestMapping("/adminBorrarMovil")
	public String borrarMovilAdmin(Model model,@RequestParam(value="id",required = false)Integer id) {
		
		movilRepo.deleteById(id);
		
		
		return "redirect:/superuser";
	}
	@RequestMapping("/adminModificarMovil")
	public String modificarMovilAdmin(Model model,@ModelAttribute("obj_movil")Movil mov,@RequestParam(value="id",required = false)Integer id) {
		
		model.addAttribute("atr_lista_marcas", marcaRepo.findAll());
		
		if(id!=null) {
			 mov=movilRepo.findById(id).orElse(new Movil());
		}else {
			mov=new Movil();
					
		}
		
		model.addAttribute("movil",mov);
		
		
		
		
		
		
		return "formModificarMovil";
	}
}
