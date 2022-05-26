package com.azold6.rodartenogueirabackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sexo;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate dataDeNascimento;
    private Double notaPrimeiroSemestre;
    private Double notaSegundoSemestre;
    private Double notaTerceiroSemestre;

    public Aluno() {
    }

    public Aluno(Integer id, String nome, String sexo, LocalDate dataDeNascimento, Double notaPrimeiroSemestre, Double notaSegundoSemestre, Double notaTerceiroSemestre) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
        this.notaTerceiroSemestre = notaTerceiroSemestre;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataDeNascimento=" + dataDeNascimento +
                ", notaPrimeiroSemestre=" + notaPrimeiroSemestre +
                ", notaSegundoSemestre=" + notaSegundoSemestre +
                ", notaTerceiroSemestre=" + notaTerceiroSemestre +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Double getNotaPrimeiroSemestre() {
        return notaPrimeiroSemestre;
    }

    public void setNotaPrimeiroSemestre(Double notaPrimeiroSemestre) {
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
    }

    public Double getNotaSegundoSemestre() {
        return notaSegundoSemestre;
    }

    public void setNotaSegundoSemestre(Double notaSegundoSemestre) {
        this.notaSegundoSemestre = notaSegundoSemestre;
    }

    public Double getNotaTerceiroSemestre() {
        return notaTerceiroSemestre;
    }

    public void setNotaTerceiroSemestre(Double notaTerceiroSemestre) {
        this.notaTerceiroSemestre = notaTerceiroSemestre;
    }
}
