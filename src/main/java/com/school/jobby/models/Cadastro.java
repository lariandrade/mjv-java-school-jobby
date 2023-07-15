package com.school.jobby.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.school.jobby.dtos.cadastro.candidato.DadosAtualizacaoCadastro;
import com.school.jobby.dtos.cadastro.candidato.DadosCadastroDTO;
import com.school.jobby.dtos.cadastro.candidato.DadosEnderecoDTO;
import com.school.jobby.dtos.cadastro.candidato.DadosProfissaoDTO;
import com.school.jobby.enums.Sexo;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    private String nome;
    private String CPF;
    private LocalDate dataNascimento;
    private Long telefone;
    private String email;
    private String habilidades;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @Embedded
    private Celular celular;
    @Embedded
    private Endereco endereco;

    @Embedded
    private PretencaoSalarial pretencaoSalarial;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profissao_id")
    private Profissao profissao;

    @OneToMany(mappedBy = "cadastro", cascade = CascadeType.ALL)
    @JsonManagedReference
    //private CadastroExperiencia experiencia;
    private List<CadastroExperiencia> experiencias;

    public Cadastro(DadosCadastroDTO dados) {
        this.nome = dados.nome();
        this.CPF = dados.CPF();
        this.dataNascimento = dados.dataNascimento();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.sexo = dados.sexo();
        this.celular = dados.celular();
        this.endereco = new Endereco(dados.endereco());
        this.profissao = new Profissao(dados.profissao());
        this.pretencaoSalarial = dados.pretencaoSalarial();
        this.habilidades = dados.habilidades();
    }

    public void setEndereco(DadosEnderecoDTO endereco) {
        if (endereco.logradouro() != null) {
            this.endereco.setLogradouro(endereco.logradouro());
        }

        if (endereco.bairro() != null) {
            this.endereco.setBairro(endereco.bairro());
        }

        if (endereco.cep() != null) {
            this.endereco.setCep(endereco.cep());
        }

        if (endereco.complemento() != null) {
            this.endereco.setComplemento(endereco.complemento());
        }

        if (endereco.cidade() != null) {
            this.endereco.setCidade(endereco.cidade());
        }

        if (endereco.numero() != null) {
            this.endereco.setNumero(endereco.numero());
        }

    }

    public void setProfissao(DadosProfissaoDTO profissao) {
        if (profissao.nome() != null) {
            this.profissao.setNome(profissao.nome());
        }

    }
}
