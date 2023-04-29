package com.estudo.eventoapp.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String local;
    private String data;
    private String horario;

    @OneToMany
    private List<Convidado> convidado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public List<Convidado> getConvidado() {
        return convidado;
    }

    public void setConvidado(List<Convidado> convidado) {
        this.convidado = convidado;
    }
}
