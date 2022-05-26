package com.azold6.rodartenogueirabackend.controllers;

import com.azold6.rodartenogueirabackend.dto.AlunoResponseDTO;
import com.azold6.rodartenogueirabackend.models.Aluno;
import com.azold6.rodartenogueirabackend.services.AlunoService;
import com.azold6.rodartenogueirabackend.utils.ApachePOIExcelRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @PostMapping("/gerarExcel")
    public void gerarTabelaExcel() throws IOException {
        ApachePOIExcelRead.gerarExcel();
        System.out.println("Excel gerado com sucesso!");
    }
}
