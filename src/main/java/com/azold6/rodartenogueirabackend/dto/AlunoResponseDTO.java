package com.azold6.rodartenogueirabackend.dto;

public class AlunoResponseDTO {

    private Integer identificacao;
    private Integer idade;
    private String nome;
    private Double media;

    public AlunoResponseDTO(Integer identificacao, Integer idade, String nome, Double media) {
        this.identificacao = identificacao;
        this.idade = idade;
        this.nome = nome;
        this.media = media;
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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }
}
