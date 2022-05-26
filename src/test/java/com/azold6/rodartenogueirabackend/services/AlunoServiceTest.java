package com.azold6.rodartenogueirabackend.services;

import com.azold6.rodartenogueirabackend.dto.AlunoResponseDTO;
import com.azold6.rodartenogueirabackend.models.Aluno;
import com.azold6.rodartenogueirabackend.repositories.AlunoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class AlunoServiceTest {

    @Mock
    AlunoRepository alunoRepository;

    @InjectMocks
    AlunoService alunoService;

    @Test
    void findAllByIdadeCrescenteTest() {
        //given
        Aluno aluno = new Aluno();
        given(alunoRepository.findAllByOrderByIdadeAsc()).willReturn(List.of(aluno));

        //when
        List<Aluno> resposta = alunoService.findAllByIdadeCrescente();

        //then
        then(alunoRepository).should(times(1)).findAllByOrderByIdadeAsc();
        assertEquals(1, resposta.size());
    }

    @Test
    void entityToDtoTest(){
        //given
        Aluno aluno = new Aluno();
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(aluno);

        //when
        List<AlunoResponseDTO> resposta = alunoService.entityToDto(alunos);

        //then
        assertEquals(1, resposta.size());
    }
}