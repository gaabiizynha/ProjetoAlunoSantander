package com.projeto.dbaluno.repository;

import com.projeto.dbaluno.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    List<Aluno> findAllByNomeContainingIgnoreCase(String nome);
    Optional<Aluno> findById(Long Id);
}