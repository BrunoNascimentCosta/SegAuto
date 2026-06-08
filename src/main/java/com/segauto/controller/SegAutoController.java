package com.segauto.controller;

import com.segauto.dto.ClienteLoginDTO;
import com.segauto.dto.PedidoRequestDTO;
import com.segauto.model.Cliente;
import com.segauto.model.PedidoAvaliacao;
import com.segauto.repository.ClienteRepository;
import com.segauto.repository.PedidoAvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/segauto")
@CrossOrigin(origins = "*") 
public class SegAutoController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PedidoAvaliacaoRepository pedidoRepository;

    @PostMapping("/clientes/login")
    public ResponseEntity<Cliente> loginOuCadastrarCliente(@RequestBody ClienteLoginDTO dto) {
        Optional<Cliente> clienteExistente = clienteRepository.findByEmail(dto.getEmail());
        
        if (clienteExistente.isPresent()) {
            return ResponseEntity.ok(clienteExistente.get());
        }
        
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.getNome());
        novoCliente.setEmail(dto.getEmail());
        
        Cliente clienteSalvo = clienteRepository.save(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PostMapping("/pedidos")
    public ResponseEntity<?> criarPedido(@RequestBody PedidoRequestDTO dto) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(dto.getClienteId());
        
        if (clienteOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não encontrado no sistema.");
        }
        
        PedidoAvaliacao pedido = new PedidoAvaliacao();
        pedido.setCliente(clienteOpt.get());
        pedido.setLinkAnuncio(dto.getLinkAnuncio());
        pedido.setModeloCarro(dto.getModeloCarro());
        pedido.setCidade(dto.getCidade());
        pedido.setEstado(dto.getEstado());
        pedido.setTipoAvaliacao(dto.getTipoAvaliacao());
        pedido.setStatus("AGUARDANDO_LANCES");
        pedido.setDataCriacao(LocalDateTime.now());
        
        PedidoAvaliacao pedidoSalvo = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }
}
