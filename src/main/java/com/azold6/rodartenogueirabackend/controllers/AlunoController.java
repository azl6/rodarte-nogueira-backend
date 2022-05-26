package com.azold6.rodartenogueirabackend.controllers;

import com.azold6.rodartenogueirabackend.dto.AlunoResponseDTO;
import com.azold6.rodartenogueirabackend.models.Aluno;
import com.azold6.rodartenogueirabackend.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<AlunoResponseDTO>> findAllByIdadeCrescente(){
        List<Aluno> alunos = alunoService.findAllByIdadeCrescente();
        return ResponseEntity.ok().body(alunoService.entityToDto(alunos));
    }
}
