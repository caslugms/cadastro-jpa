package com.example;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "documento_id", referencedColumnName = "id")
    private Documento documento;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;
    

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
        name = "pessoa_projeto",
        joinColumns = @JoinColumn(name = "pessoa_id"),
        inverseJoinColumns = @JoinColumn(name = "projeto_id")
    )
    private List<Projeto> projetos;

    public Pessoa() {
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

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
}
