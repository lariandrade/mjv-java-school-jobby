package com.school.jobby.dtos.cadastro.candidato;

import com.school.jobby.enums.Sexo;
import com.school.jobby.models.Celular;
import com.school.jobby.models.PretencaoSalarial;

public record DadosAtualizacaoCadastro(
        String nome,
        Long telefone,
        String email,
        DadosEnderecoDTO endereco,
        Sexo sexo,
        Celular celular,
        PretencaoSalarial pretencaoSalarial,
        DadosProfissaoDTO profissao,
        String habilidades) {}
