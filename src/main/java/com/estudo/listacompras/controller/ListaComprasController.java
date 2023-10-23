package com.estudo.listacompras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.estudo.listacompras.model.Produto;
import com.estudo.listacompras.service.ListaComprasService;

@Controller
public class ListaComprasController {
	
	@Autowired
	private ListaComprasService listaComprasService;
	
	@GetMapping("/listarCompras")
	public String listarCompras(Model model) {
		List<Produto> lsCompras = listaComprasService.listarCompras();
		model.addAttribute("lsCompras", lsCompras);
		return "compras/listarCompras";
	}
	
	@GetMapping("/cadastrarCompras")
	public String cadastrarCompras() {
		return "compras/cadastrarCompras";
	}
	
	@PostMapping("/cadastrarCompras")
	public String cadastrarCompras(@ModelAttribute Produto produto) {
		listaComprasService.salvar(produto);
		return "redirect:/cadastrarCompras";
	}
	
	@RequestMapping("/alterarCompra")
	public String alterarCompra(@RequestParam Long id, Model model) {
		Produto produto = listaComprasService.listarPeloId(id);
		model.addAttribute("produto", produto);
		return "redirect:/listarCompras";
	}
	
	@RequestMapping("/removerCompra")
	public String removerCompra(@RequestParam Long id) {
		listaComprasService.deletarCompras(id);
		return "redirect:/listarCompras";
	}
}
