package com.projeto.dbaluno.controller;

import com.projeto.dbaluno.model.Aluno;
import com.projeto.dbaluno.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlunoController {

    @Autowired
    public AlunoRepository repository;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Aluno> getById(@PathVariable Long id)
    {
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> getById(@PathVariable String nome)
    {
        return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
    }
    @PostMapping
    public ResponseEntity<Aluno> postAluno(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
    }
    @PutMapping("/edit/{id}")
    public ResponseEntity<Aluno> putAluno(@RequestBody Aluno aluno, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(aluno));
    }
    @DeleteMapping("/{id}")
    public void deleteAlunoId(@PathVariable Long id){
        repository.deleteById(id);
    }
}
