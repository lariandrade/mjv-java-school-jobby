package com.school.jobby.controller;

import com.school.jobby.dtos.cadastro.candidato.DadosDetalhamentoCadastro;
import com.school.jobby.dtos.cadastro.experiencia.DadosAtualizacaoExperiencia;
import com.school.jobby.dtos.cadastro.experiencia.DadosDetalhamentoExperiencia;
import com.school.jobby.dtos.cadastro.experiencia.DadosExperienciaDTO;
import com.school.jobby.exception.ValidacaoException;
import com.school.jobby.models.CadastroExperiencia;
import com.school.jobby.service.CadastroExperienciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/experiencias")
public class CadastroExperienciaController {

    @Autowired
    private CadastroExperienciaService cadastroExperienciaService;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid DadosExperienciaDTO dados) {
        try {
            DadosDetalhamentoExperiencia dadosDetalhamento = cadastroExperienciaService.save(dados);
            return ResponseEntity.ok(dadosDetalhamento);
        } catch(ValidacaoException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<CadastroExperiencia>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cadastroExperienciaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        Optional<CadastroExperiencia> cadExperiencia = cadastroExperienciaService.findById(id);
        if (cadExperiencia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiencia não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadExperiencia.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody DadosAtualizacaoExperiencia dados) {
        ResponseEntity<String> response;
        try {
            DadosDetalhamentoExperiencia dadosDetalhamento = cadastroExperienciaService.update(id, dados);
            return ResponseEntity.status(HttpStatus.OK).body(dadosDetalhamento);
        } catch (NoSuchElementException e) {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiencia não encontrada");
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<CadastroExperiencia> cadExperiencia = cadastroExperienciaService.findById(id);

        if (cadExperiencia.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Experiencia não encontrada");
        }

        cadastroExperienciaService.delete(cadExperiencia.get());

        return ResponseEntity.status(HttpStatus.OK).body("Experiencia deletada com sucesso.");
    }
}
