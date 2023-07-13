package com.school.jobby.service;

import com.school.jobby.dtos.cadastro.candidato.DadosAtualizacaoCadastro;
import com.school.jobby.dtos.cadastro.candidato.DadosCadastroDTO;
import com.school.jobby.dtos.cadastro.candidato.DadosDetalhamentoCadastro;
import com.school.jobby.models.Cadastro;
import com.school.jobby.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public DadosDetalhamentoCadastro save(DadosCadastroDTO dto) {

        Cadastro cadastro = new Cadastro(dto);

        cadastroRepository.save(cadastro);

        DadosDetalhamentoCadastro dados = new DadosDetalhamentoCadastro(cadastro);

        return dados;

    }

    public List<Cadastro> findAll() {
        return cadastroRepository.findAll();
    }

    public Optional<Cadastro> findById(Integer id) {
        return cadastroRepository.findById(id);
    }

    public void delete(Cadastro cadastro) {
        cadastroRepository.delete(cadastro);
    }

    public DadosDetalhamentoCadastro update(Integer id, DadosAtualizacaoCadastro dados) {

        Optional<Cadastro> cadastroOP = cadastroRepository.findById(id);

        Cadastro cadastro = cadastroOP.get();

        if (dados.nome() != null) {
            cadastro.setNome(dados.nome());
        }

        if (dados.telefone() != null) {
            cadastro.setTelefone(dados.telefone());
        }

        if (dados.email() != null) {
            cadastro.setEmail(dados.email());
        }

        if (dados.endereco() != null) {
            cadastro.setEndereco(dados.endereco());
        }

        if (dados.sexo() != null) {
            cadastro.setSexo(dados.sexo());
        }

        if (dados.celular() != null) {
            cadastro.setCelular(dados.celular());
        }

        if (dados.pretencaoSalarial() != null) {
            cadastro.setPretencaoSalarial(dados.pretencaoSalarial());
        }

        if (dados.profissao() != null) {
            cadastro.setProfissao(dados.profissao());
        }

        if (dados.habilidades() != null) {
            cadastro.setHabilidades(dados.habilidades());
        }

        cadastroRepository.save(cadastro);

        DadosDetalhamentoCadastro dadosAtualizado = new DadosDetalhamentoCadastro(cadastro);

        return dadosAtualizado;
    }
}
