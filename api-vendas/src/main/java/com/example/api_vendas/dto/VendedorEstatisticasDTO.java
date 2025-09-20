package com.example.api_vendas.dto;

import java.math.BigDecimal;

public class VendedorEstatisticasDTO {

    private String nome;
    private Long totalVendas;
    private BigDecimal mediaVendasDiaria;

    // Construtor padrão
    public VendedorEstatisticasDTO() {}

    // Construtor com parâmetros
    public VendedorEstatisticasDTO(String nome, Long totalVendas, BigDecimal mediaVendasDiaria) {
        this.nome = nome;
        this.totalVendas = totalVendas;
        this.mediaVendasDiaria = mediaVendasDiaria;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Long getTotalVendas() { return totalVendas; }
    public void setTotalVendas(Long totalVendas) { this.totalVendas = totalVendas; }

    public BigDecimal getMediaVendasDiaria() { return mediaVendasDiaria; }
    public void setMediaVendasDiaria(BigDecimal mediaVendasDiaria) { this.mediaVendasDiaria = mediaVendasDiaria; }
}