package br.com.alurafood.pedidos.repository;

import br.com.alurafood.pedidos.model.Pedido;
import br.com.alurafood.pedidos.model.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void atualizaStatus(Status status, Pedido pedido);

    @Query("SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Pedido porIdComItens(Long id);
}
