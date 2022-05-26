package com.azold6.rodartenogueirabackend;

import com.azold6.rodartenogueirabackend.models.Aluno;
import com.azold6.rodartenogueirabackend.repositories.AlunoRepository;
import com.azold6.rodartenogueirabackend.utils.ApachePOIExcelRead;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class RodarteNogueiraBackendApplication implements CommandLineRunner {

	@Autowired
	AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(RodarteNogueiraBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Aluno> alunos = ApachePOIExcelRead.readExcel();
		alunoRepository.saveAll(alunos);
	}
}
