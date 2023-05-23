package com.pedroh.utilitarios.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pedroh.utilitarios.model.Registro;
import com.pedroh.utilitarios.repository.IndexRepository;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	IndexRepository repository;

    @GetMapping
    public ModelAndView getIndex(){
    	ModelAndView mv = new ModelAndView("index");
    	List<Registro> lsRegistros = repository.findAll();
    	mv.addObject("lsRegistros", lsRegistros);
        return mv;
    }
    
    @PostMapping("/cadastrarRegistro")
    public ResponseEntity<String> cadastrarRegistro(
    		@RequestParam("data") String data,
    		@RequestParam("descricao") String descricao,
    		@RequestParam("tipo") String tipo,
    		@RequestParam("valor") BigDecimal valor
    ) {
    	
    	Registro registro = new Registro(valor, descricao, data, tipo);
    	
    	repository.save(registro);
    	
    	return ResponseEntity.ok("Registro salvo com sucesso");
    }
    
    @DeleteMapping("/deletarRegistro/{id}")
    public ResponseEntity<String> deletarRegistro(@PathVariable("id") Long id){
    	try {
            Registro registro = repository.findById(id).get();
            
            repository.delete(registro);
            
            return ResponseEntity.ok("Entity deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid entity name");
        }
    }
}
