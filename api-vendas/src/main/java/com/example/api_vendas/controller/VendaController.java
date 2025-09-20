package com.example.api_vendas.controller;

import com.example.api_vendas.dto.CriarVendaDTO;
import com.example.api_vendas.dto.VendaResponseDTO;
import com.example.api_vendas.dto.VendedorEstatisticasDTO;
import com.example.api_vendas.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*") // Permite requisições de qualquer origem
public class VendaController {

    @Autowired
    private VendaService vendaService;

    /**
     * Endpoint para criar uma nova venda
     * POST /api/vendas
     */
    @PostMapping
    public ResponseEntity<VendaResponseDTO> criarVenda(@Valid @RequestBody CriarVendaDTO criarVendaDTO) {
        try {
            VendaResponseDTO vendaCriada = vendaService.criarVenda(criarVendaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(vendaCriada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Endpoint para buscar estatísticas dos vendedores
     * GET /api/vendas/vendedores/estatisticas?dataInicio=2024-01-01&dataFim=2024-12-31
     */
    @GetMapping("/vendedores/estatisticas")
    public ResponseEntity<List<VendedorEstatisticasDTO>> buscarEstatisticasVendedores(
            @RequestParam("dataInicio")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,

            @RequestParam("dataFim")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim) {

        try {
            List<VendedorEstatisticasDTO> estatisticas = vendaService.buscarEstatisticasVendedores(dataInicio, dataFim);
            return ResponseEntity.ok(estatisticas);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * Endpoint auxiliar para listar todas as vendas
     * GET /api/vendas
     */
    @GetMapping
    public ResponseEntity<List<VendaResponseDTO>> listarTodasVendas() {
        try {
            List<VendaResponseDTO> vendas = vendaService.buscarTodasVendas();
            return ResponseEntity.ok(vendas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}