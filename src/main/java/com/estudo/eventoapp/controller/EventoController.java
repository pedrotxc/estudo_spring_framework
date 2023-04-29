package com.estudo.eventoapp.controller;

import com.estudo.eventoapp.model.Convidado;
import com.estudo.eventoapp.model.Evento;
import com.estudo.eventoapp.repository.ConvidadoRepository;
import com.estudo.eventoapp.repository.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;
    @Autowired
    ConvidadoRepository convidadoRepository;

    @GetMapping("/cadastrarEvento")
    public String form() {
        return "evento/formEvento";
    }

    @PostMapping("/cadastrarEvento")
    public String form(Evento evento) {
        eventoRepository.save(evento);
        return "redirect:/cadastrarEvento";
    }

    @GetMapping("/eventos")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");
        List<Evento> eventos = eventoRepository.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

    @GetMapping("/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo) {
        Evento evento = eventoRepository.findById(codigo).get();
        ModelAndView mv = new ModelAndView("evento/detalhesEvento");
        mv.addObject("evento", evento);

        List<Convidado> convidados = convidadoRepository.findByEvento(evento);
        mv.addObject("convidados", convidados);

        return mv;
    }

    @PostMapping("/{codigo}")
    public String detalhesEventoPost(@PathVariable("codigo") Long codigo, @Valid Convidado convidado, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos!");
            return "redirect:/{codigo}";
        }
        Evento evento = eventoRepository.findById(codigo).get();
        convidado.setEvento(evento);
        convidadoRepository.save(convidado);
        attributes.addFlashAttribute("mensagem", "Convidado adicionado com SUCESSO!");
        return "redirect:/{codigo}";
    }

    @RequestMapping("/deletarEvento")
    public String deletarEvento(Long codigo){
        Evento evento = eventoRepository.findById(codigo).get();
        eventoRepository.delete(evento);
        return "redirect:/eventos";
    }

    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String rg){
        Convidado convidado = convidadoRepository.findByRg(rg);
        convidadoRepository.delete(convidado);
        Evento evento = convidado.getEvento();
        Long idLong = evento.getId();
        String idString = "" + idLong;
        return "redirect:/" + idString;
    }
}