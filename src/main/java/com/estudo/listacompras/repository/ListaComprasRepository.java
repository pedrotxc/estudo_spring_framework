package com.estudo.listacompras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudo.listacompras.model.Produto;

@Repository
public interface ListaComprasRepository extends JpaRepository<Produto, Long>{

}
