package com.school.jobby.controller;

import com.school.jobby.dto.DadosCadastro;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatos")
public class CadastroController {


    @PostMapping
    public void cadastro(@RequestBody @Valid DadosCadastro dados) {
       System.out.println(dados);
    }

}
