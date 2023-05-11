package com.pedroh.utilitarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/financeiro")
public class FinanceiroController {

    @GetMapping("/detalhesfinanceiro")
    public String getFinanceiro() {
        return "financeiro/controleFinanceiro";
    }

    @Transactional
    @PostMapping("/cadastrarSalario")
    public ResponseEntity<String> cadastrarSalario(	@RequestParam("data")String data, 
    												@RequestParam("descricao") String descricao,
    												@RequestParam("tipo") String tipo,
    												@RequestParam("valor") Double valor){
        System.out.println(data);
    	System.out.println(descricao);
        System.out.println(tipo);
        System.out.println(valor);
        
        return ResponseEntity.ok("Registro salvo com sucesso!");
    }
}
