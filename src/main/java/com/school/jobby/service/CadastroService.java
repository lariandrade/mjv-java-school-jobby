package com.school.jobby.service;

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

   /* public Cadastro getReferenceById(Integer id) {
        return cadastroRepository.getReferenceById(id);
    }*/

    public Optional<Cadastro> findById(Integer id) {
        return cadastroRepository.findById(id);
    }
}
