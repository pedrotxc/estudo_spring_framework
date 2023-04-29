package com.estudo.eventoapp.repository;

import com.estudo.eventoapp.model.Convidado;
import com.estudo.eventoapp.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvidadoRepository extends JpaRepository<Convidado, String> {

    List<Convidado> findByEvento(Evento evento);
    Convidado findByRg(String rg);

}
