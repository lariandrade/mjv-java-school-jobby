package com.school.jobby.models;

import com.school.jobby.dtos.cadastro.candidato.DadosCidadeDTO;
import com.school.jobby.dtos.cadastro.candidato.DadosEnderecoDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Endereco {
    private Long cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade_id")
    private Cidade cidade;

    public Endereco(DadosEnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
        this.cidade = new Cidade(dados.cidade());
    }

    public void setCidade(DadosCidadeDTO cidade) {
        if (cidade.estado() != null) {
            this.cidade.setEstado(cidade.estado());
        }

        if (cidade.nome() != null) {
            this.cidade.setNome(cidade.nome());
        }

        if (cidade.sigla() != null) {
            this.cidade.setSigla(cidade.sigla());
        }

    }
}
