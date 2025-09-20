package com.example.api_vendas.service;

import com.example.api_vendas.dto.CriarVendaDTO;
import com.example.api_vendas.dto.VendaResponseDTO;
import com.example.api_vendas.dto.VendedorEstatisticasDTO;
import com.example.api_vendas.entity.Venda;
import com.example.api_vendas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    /**
     * Cria uma nova venda
     */
    public VendaResponseDTO criarVenda(CriarVendaDTO criarVendaDTO) {
        // Converter DTO para Entity
        Venda venda = new Venda(
                LocalDate.now(), // data da venda é hoje
                criarVendaDTO.getValor(),
                criarVendaDTO.getVendedorId(),
                criarVendaDTO.getVendedorNome()
        );

        // Salvar no banco
        Venda vendaSalva = vendaRepository.save(venda);

        // Converter Entity para DTO de resposta
        return new VendaResponseDTO(
                vendaSalva.getId(),
                vendaSalva.getDataVenda(),
                vendaSalva.getValor(),
                vendaSalva.getVendedorId(),
                vendaSalva.getVendedorNome()
        );
    }

    /**
     * Busca estatísticas dos vendedores por período
     */
    public List<VendedorEstatisticasDTO> buscarEstatisticasVendedores(LocalDate dataInicio, LocalDate dataFim) {
        // Validar período
        if (dataInicio.isAfter(dataFim)) {
            throw new IllegalArgumentException("Data de início não pode ser maior que data fim");
        }

        // Buscar vendedores únicos no período
        List<Object[]> vendedoresUnicos = vendaRepository.findVendedoresUnicos(dataInicio, dataFim);

        List<VendedorEstatisticasDTO> estatisticas = new ArrayList<>();

        // Calcular dias no período
        long diasNoPeriodo = ChronoUnit.DAYS.between(dataInicio, dataFim) + 1;

        // Para cada vendedor, calcular estatísticas
        for (Object[] vendedor : vendedoresUnicos) {
            Long vendedorId = (Long) vendedor[0];
            String vendedorNome = (String) vendedor[1];

            // Contar total de vendas
            Long totalVendas = vendaRepository.countVendasPorVendedorNoPeriodo(
                    vendedorId, dataInicio, dataFim
            );

            // Calcular média diária
            BigDecimal mediaVendasDiaria = BigDecimal.valueOf(totalVendas)
                    .divide(BigDecimal.valueOf(diasNoPeriodo), 2, RoundingMode.HALF_UP);

            estatisticas.add(new VendedorEstatisticasDTO(
                    vendedorNome,
                    totalVendas,
                    mediaVendasDiaria
            ));
        }

        return estatisticas;
    }

    /**
     * Busca todas as vendas (método auxiliar para testes)
     */
    public List<VendaResponseDTO> buscarTodasVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        List<VendaResponseDTO> vendasDTO = new ArrayList<>();

        for (Venda venda : vendas) {
            vendasDTO.add(new VendaResponseDTO(
                    venda.getId(),
                    venda.getDataVenda(),
                    venda.getValor(),
                    venda.getVendedorId(),
                    venda.getVendedorNome()
            ));
        }

        return vendasDTO;
    }
}