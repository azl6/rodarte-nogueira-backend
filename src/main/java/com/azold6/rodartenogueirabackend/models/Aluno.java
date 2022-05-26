package com.azold6.rodartenogueirabackend.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Aluno {

    @Id
    private Integer identificacao;
    private String nome;
    private String sexo;
    private LocalDate dataDeNascimento;
    private Double notaPrimeiroSemestre;
    private Double notaSegundoSemestre;
    private Double notaTerceiroSemestre;
    private Double media;
    private Integer idade;

    public Aluno() {
    }

    public Aluno(Integer identificacao, String nome, String sexo, LocalDate dataDeNascimento, Double notaPrimeiroSemestre, Double notaSegundoSemestre, Double notaTerceiroSemestre, Double media, Integer idade) {
        this.identificacao = identificacao;
        this.nome = nome;
        this.sexo = sexo;
        this.dataDeNascimento = dataDeNascimento;
        this.notaPrimeiroSemestre = notaPrimeiroSemestre;
        this.notaSegundoSemestre = notaSegundoSemestre;
        this.notaTerceiroSemestre = notaTerceiroSemestre;
        this.media = media;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + identificacao +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataDeNascimento=" + dataDeNascimento +
                ", notaPrimeiroSemestre=" + notaPrimeiroSemestre +
                ", notaSegundoSemestre=" + notaSegundoSemestre +
                ", notaTerceiroSemestre=" + notaTerceiroSemestre +
                '}';
    }


    public Integer getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Integer identificacao) {
        this.identificacao = identificacao;
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

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void calculaIdade(){
        LocalDate dataDeNascimento = this.getDataDeNascimento();
        LocalDate dataAtual = LocalDate.now();
        Period period = Period.between(dataDeNascimento, dataAtual);
        this.setIdade(period.getYears());
    }

    public void calculaMedia(){
        DecimalFormat df = new DecimalFormat("#,###.##");
        this.media = (this.notaPrimeiroSemestre +
                     this.notaSegundoSemestre +
                     this.notaTerceiroSemestre)/3;
    }
}
