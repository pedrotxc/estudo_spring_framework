package com.estudo.financas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.estudo.financas.enums.PerfilInvestimento;
import com.estudo.financas.model.Investidor;
import com.estudo.financas.service.InvestidorService;

@Controller
public class InvestidorController {

	@Autowired
	private InvestidorService investidorService;

	@RequestMapping("/")
	public ModelAndView buscaInvestidores() {
		ModelAndView mv = new ModelAndView("index");
		List<Investidor> investidores = investidorService.buscarInvestidores();
		mv.addObject("investidores", investidores);
		return mv;
	}

	@GetMapping("/cadastrarInvestidor")
	public String cadastrarInvestidor() {
		ModelAndView mv = new ModelAndView();
		PerfilInvestimento[] perfisInvestidor = PerfilInvestimento.values();
		mv.addObject("perfisInvestidor", perfisInvestidor);
		return "investidor/cadastraInvestidor";
	}

	@PostMapping("/cadastrarInvestidor")
	public String cadastrarInvestidor(Investidor investidor) {
		investidorService.cadastrarInvestidor(investidor);
		return "redirect:/cadastrarInvestidor";
	}
	
	@RequestMapping("/deletarInvestidor")
	public String deletarInvestidor(Long id) {
		investidorService.deletarInvestidor(id);
		return "redirect:/";
	}
}
