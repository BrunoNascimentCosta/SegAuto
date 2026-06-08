package com.segauto.repository;

import com.segauto.model.PedidoAvaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoAvaliacaoRepository extends JpaRepository<PedidoAvaliacao, Long> {
    // Agora ele sabe que salva PedidoAvaliacao e o erro no Controller vai sumir!
}
