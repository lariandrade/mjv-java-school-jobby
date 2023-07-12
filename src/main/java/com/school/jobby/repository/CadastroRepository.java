package com.school.jobby.repository;

import com.school.jobby.models.Cadastro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {
}
