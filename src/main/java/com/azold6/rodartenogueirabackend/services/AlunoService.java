package com.azold6.rodartenogueirabackend.services;

import com.azold6.rodartenogueirabackend.models.Aluno;
import com.azold6.rodartenogueirabackend.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAllByIdadeCrescente(){
        List<Aluno> alunos = alunoRepository.findAllByOrderByIdadeAsc();
        return alunos;
    }
}
