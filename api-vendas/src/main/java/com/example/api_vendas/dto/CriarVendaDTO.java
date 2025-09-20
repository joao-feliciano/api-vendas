package com.example.api_vendas.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CriarVendaDTO {

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "0.01", message = "Valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "ID do vendedor é obrigatório")
    @Min(value = 1, message = "ID do vendedor deve ser maior que zero")
    private Long vendedorId;

    @NotBlank(message = "Nome do vendedor é obrigatório")
    @Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
    private String vendedorNome;

    // Construtor padrão
    public CriarVendaDTO() {}

    // Construtor com parâmetros
    public CriarVendaDTO(BigDecimal valor, Long vendedorId, String vendedorNome) {
        this.valor = valor;
        this.vendedorId = vendedorId;
        this.vendedorNome = vendedorNome;
    }

    // Getters e Setters
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public Long getVendedorId() { return vendedorId; }
    public void setVendedorId(Long vendedorId) { this.vendedorId = vendedorId; }

    public String getVendedorNome() { return vendedorNome; }
    public void setVendedorNome(String vendedorNome) { this.vendedorNome = vendedorNome; }
}