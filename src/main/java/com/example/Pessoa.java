package com.example;
import jakarta.persistence.*;

@Entity
public class Pessoa {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) --> POSTEGREE
    @GeneratedValue
    private Long id;
    private String nome;

    public Pessoa() {

    }
    
    public Pessoa(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
