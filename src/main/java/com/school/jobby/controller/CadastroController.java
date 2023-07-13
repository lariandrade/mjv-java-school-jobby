package com.school.jobby.controller;

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
import java.util.Optional;

@RestController
@RequestMapping("/candidatos")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroDTO dados) {
        DadosDetalhamentoCadastro dadosDetalhamento = cadastroService.save(dados);
        return ResponseEntity.ok(dadosDetalhamento);
    }

    @GetMapping
    public ResponseEntity<List<Cadastro>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cadastroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        Optional<Cadastro> cadastro = cadastroService.findById(id);

        if(cadastro.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cadastro.get());
    }


}
