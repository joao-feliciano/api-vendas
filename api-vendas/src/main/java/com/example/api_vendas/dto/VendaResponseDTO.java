package com.example.api_vendas.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class VendaResponseDTO {

    private Long id;
    private LocalDate dataVenda;
    private BigDecimal valor;
    private Long vendedorId;
    private String vendedorNome;

    // Construtor padrão
    public VendaResponseDTO() {}

    // Construtor com parâmetros
    public VendaResponseDTO(Long id, LocalDate dataVenda, BigDecimal valor,
                            Long vendedorId, String vendedorNome) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.valor = valor;
        this.vendedorId = vendedorId;
        this.vendedorNome = vendedorNome;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDataVenda() { return dataVenda; }
    public void setDataVenda(LocalDate dataVenda) { this.dataVenda = dataVenda; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Long getVendedorId() { return vendedorId; }
    public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }

    public String getVendedorNome() { return vendedorNome; }
    public void setVendedorNome(String vendedorNome) { this.vendedorNome = vendedorNome; }
}

