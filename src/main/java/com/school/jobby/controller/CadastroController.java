package com.school.jobby.controller;

import com.school.jobby.dto.DadosCadastroDTO;
import com.school.jobby.service.CadastroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping
    public ResponseEntity cadastro(@RequestBody @Valid DadosCadastroDTO dados) {
        cadastroService.save(dados);
        return ResponseEntity.ok("Candidato cadastrado");
    }

}
