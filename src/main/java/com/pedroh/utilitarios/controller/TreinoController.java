package com.pedroh.utilitarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pedroh.utilitarios.model.DetalheExercicio;
import com.pedroh.utilitarios.model.Treino;
import com.pedroh.utilitarios.service.DetalheExercicioService;
import com.pedroh.utilitarios.service.TreinoService;

import jakarta.validation.Valid;

@Controller
public class TreinoController {
	
	@Autowired
	private TreinoService treinoService;
	@Autowired
	private DetalheExercicioService detalheExercicioService;
	
	@GetMapping("/cadastrarTreino")
	public String form() {
		return "treino/formTreino";
	}
	
	@PostMapping("/cadastrarTreino")
	public String form(Treino treino) {
		treinoService.cadastrarTreino(treino);
		return "redirect:/cadastrarTreino";
	}
	
	@GetMapping("/treinos")
	public ModelAndView listaEventos() {
		List<Treino> treinos = treinoService.buscarTreinos();
		ModelAndView mv = new ModelAndView("index");  
		mv.addObject("treino", treinos);
		return mv;
	}
	
	@GetMapping("/{id}")
	public ModelAndView detalhesTreino(@PathVariable("id") Long id) {
		Treino treino = treinoService.buscarTreinoPeloId(id);
		ModelAndView mv = new ModelAndView("treino/detalhesTreino");
		mv.addObject("treino", treino);
		
		List<DetalheExercicio> detalhes = detalheExercicioService.encontrarDetalhePeloTreino(treino);
		mv.addObject("detalhes", detalhes);
		
		return mv;
	} 
	
	@PostMapping(value = "/{id}")
	public String detalhesTreinoPost(@PathVariable("id") Long id, @Valid DetalheExercicio detalheExercicio, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/{id}";
		}
		Treino treino = treinoService.buscarTreinoPeloId(id);
		detalheExercicio.setTreino(treino);
		detalheExercicioService.salvar(detalheExercicio);
		attributes.addFlashAttribute("mensagem", "Verifique os campos!");
		return "redirect:/{id}";
	}
}
