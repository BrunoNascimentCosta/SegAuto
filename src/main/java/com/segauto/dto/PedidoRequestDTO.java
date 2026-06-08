package com.segauto.dto;

import lombok.Data;

@Data
public class PedidoRequestDTO {
    private Long clienteId;
    private String linkAnuncio;
    private String modeloCarro;
    private String cidade;
    private String estado;
    private String tipoAvaliacao;
}
