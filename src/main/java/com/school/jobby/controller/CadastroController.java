package com.school.jobby.controller;

import com.school.jobby.dtos.cadastro.candidato.DadosAtualizacaoCadastro;
import com.school.jobby.dtos.cadastro.candidato.DadosCadastroDTO;
import com.school.jobby.dtos.cadastro.candidato.DadosDetalhamentoCadastro;
import com.school.jobby.models.Cadastro;
import com.school.jobby.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid DadosCadastroDTO dados) {
        DadosDetalhamentoCadastro dadosDetalhamento = cadastroService.save(dados);
        return ResponseEntity.status(HttpStatus.CREATED).body(dadosDetalhamento);
    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> getAll() {
        List<Cadastro> cadastros = cadastroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(cadastros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        Optional<Cadastro> cadastro = cadastroService.findById(id);
        if (cadastro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastro.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody DadosAtualizacaoCadastro dados) {
        ResponseEntity<String> response;
        try {

            DadosDetalhamentoCadastro dadosDetalhamentoCadastro = cadastroService.update(id, dados);
            return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamentoCadastro);

        } catch (NoSuchElementException e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Cadastro> cadastro = cadastroService.findById(id);
        if (cadastro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Candidato não encontrado");
        }
        cadastroService.delete(cadastro.get());
        return ResponseEntity.status(HttpStatus.OK).body("Candidato deletado com sucesso.");
    }


}
