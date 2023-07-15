package com.school.jobby.service;

import com.school.jobby.dtos.cadastro.experiencia.DadosAtualizacaoExperiencia;
import com.school.jobby.dtos.cadastro.experiencia.DadosDetalhamentoExperiencia;
import com.school.jobby.dtos.cadastro.experiencia.DadosExperienciaDTO;
import com.school.jobby.exception.ValidacaoException;
import com.school.jobby.models.CadastroExperiencia;
import com.school.jobby.repository.CadastroExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CadastroExperienciaService {

    @Autowired
    private CadastroExperienciaRepository cadastroExperienciaRepository;

    public DadosDetalhamentoExperiencia save(DadosExperienciaDTO dto) {
        CadastroExperiencia cadExperiencia = new CadastroExperiencia(dto);

        if (dto.empregoAtual() != null) {
            cadExperiencia.setEmpregoAtual(dto.empregoAtual());
            if (Boolean.FALSE.equals(dto.empregoAtual())) {
                if (dto.dataDesligamento() == null) {
                    throw new ValidacaoException("Por não ser emprego atual, data de desligamento é obrigatória");
                }
            }
        }

        cadastroExperienciaRepository.save(cadExperiencia);
        DadosDetalhamentoExperiencia dados = new DadosDetalhamentoExperiencia(cadExperiencia);

        return dados;
    }

    public List<CadastroExperiencia> findAll() {
        return cadastroExperienciaRepository.findAll();
    }

    public Optional<CadastroExperiencia> findById(Integer id) {
        return cadastroExperienciaRepository.findById(id);
    }

    public void delete(CadastroExperiencia cadExperiencia) {
        cadastroExperienciaRepository.delete(cadExperiencia);
    }

    public DadosDetalhamentoExperiencia update(Integer id, DadosAtualizacaoExperiencia dados) {
        Optional<CadastroExperiencia> cadExperienciaOP = cadastroExperienciaRepository.findById(id);

        CadastroExperiencia cadExperiencia = cadExperienciaOP.get();

        if (dados.nomeEmpresa() != null) {
            cadExperiencia.setNomeEmpresa(dados.nomeEmpresa());
        }

        if (dados.salario() != null) {
            cadExperiencia.setSalario(dados.salario());
        }

        if (dados.empregoAtual() != null) {
            cadExperiencia.setEmpregoAtual(dados.empregoAtual());
        }

        if (dados.dataContratacao() != null) {
            cadExperiencia.setDataContratacao(LocalDate.from(dados.dataContratacao()));
        }

        if (dados.dataDesligamento() != null) {
            cadExperiencia.setDataDesligamento(LocalDate.from(dados.dataDesligamento()));
        }

        if (dados.regimeContratacao() != null) {
            cadExperiencia.setRegimeContratacao(dados.regimeContratacao());
        }

        if (dados.profissao() != null) {
            cadExperiencia.setProfissao(dados.profissao());
        }

        cadastroExperienciaRepository.save(cadExperiencia);

        DadosDetalhamentoExperiencia dadosAtualizado = new DadosDetalhamentoExperiencia(cadExperiencia);

        return dadosAtualizado;
    }
}
