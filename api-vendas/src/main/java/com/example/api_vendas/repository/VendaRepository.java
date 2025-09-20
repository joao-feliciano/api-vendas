package com.example.api_vendas.repository;

import com.example.api_vendas.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    // Busca vendas por período
    List<Venda> findByDataVendaBetween(LocalDate dataInicio, LocalDate dataFim);

    // Busca vendas de um vendedor específico
    List<Venda> findByVendedorId(Long vendedorId);

    // Query customizada para buscar vendedores únicos em um período
    @Query("SELECT DISTINCT v.vendedorId, v.vendedorNome FROM Venda v " +
            "WHERE v.dataVenda BETWEEN :dataInicio AND :dataFim")
    List<Object[]> findVendedoresUnicos(@Param("dataInicio") LocalDate dataInicio,
                                        @Param("dataFim") LocalDate dataFim);

    // Query para contar vendas por vendedor em um período
    @Query("SELECT COUNT(v) FROM Venda v " +
            "WHERE v.vendedorId = :vendedorId " +
            "AND v.dataVenda BETWEEN :dataInicio AND :dataFim")
    Long countVendasPorVendedorNoPeriodo(@Param("vendedorId") Long vendedorId,
                                         @Param("dataInicio") LocalDate dataInicio,
                                         @Param("dataFim") LocalDate dataFim);
}