package com.azold6.rodartenogueirabackend.repositories;

import com.azold6.rodartenogueirabackend.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findAllByOrderByIdadeAsc();
}
