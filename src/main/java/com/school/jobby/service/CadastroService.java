package com.school.jobby.service;

import com.school.jobby.dto.DadosCadastroDTO;
import com.school.jobby.models.Cadastro;
import com.school.jobby.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {

    @Autowired
    private CadastroRepository cadastroRepository;

    public void save(DadosCadastroDTO dto) {

        Cadastro cadastro = new Cadastro(dto);

        cadastroRepository.save(cadastro);

    }
}
