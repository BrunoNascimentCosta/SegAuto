package com.segauto.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos_avaliacao")
@Data
public class PedidoAvaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @Column(name = "link_anuncio", nullable = false)
    private String linkAnuncio;

    @Column(name = "modelo_carro")
    private String modeloCarro;

    private String cidade; // Mantido apenas este correto
    private String estado;

    @Column(name = "tipo_avaliacao")
    private String tipoAvaliacao; 

    private String status;        

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;
}
