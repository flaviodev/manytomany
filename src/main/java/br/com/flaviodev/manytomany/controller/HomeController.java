package br.com.flaviodev.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.flaviodev.manytomany.repository.AnexoRepository;
import br.com.flaviodev.manytomany.repository.CorrespondenciaRepository;

@Controller
public class HomeController {

	@Autowired
	private AnexoRepository anexoRepository;
	
	@Autowired
	private CorrespondenciaRepository correspondenciaRepository;
	
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("anexos", anexoRepository.findAll());
		mv.addObject("correspondencias", correspondenciaRepository.findAll());
		
		return mv;
	}

	
}
