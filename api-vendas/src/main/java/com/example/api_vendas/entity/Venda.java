package com.example.api_vendas.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vendas")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @Column(name = "valor", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "vendedor_id", nullable = false)
    private Long vendedorId;

    @Column(name = "vendedor_nome", nullable = false, length = 100)
    private String vendedorNome;

    // Construtor padrão (obrigatório para JPA)
    public Venda() {}

    // Construtor com parâmetros
    public Venda(LocalDate dataVenda, BigDecimal valor, Long vendedorId, String vendedorNome) {
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