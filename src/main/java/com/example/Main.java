package com.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();
        documento.setEmissor("ssp");
        documento.setTipo("rg");

        Documento documento2 = new Documento();
        documento2.setEmissor("comarca");
        documento2.setTipo("rg");

        Projeto projeto1 = new Projeto();
        projeto1.setNome("Projeto de Exemplo");
        Projeto projeto2 = new Projeto();
        projeto2.setNome("Projeto de Exemplo 2");

        Telefone telefone1 = new Telefone();
        telefone1.setNumero("11999999999");
        Telefone telefone2 = new Telefone();
        telefone2.setNumero("895458411");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano de Tal");
        pessoa.setDocumento(documento);
        pessoa.setTelefones(List.of(telefone1, telefone2));
        pessoa.setProjetos(List.of(projeto1, projeto2));

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Fulano de Tal 2");
        pessoa2.setDocumento(documento2);
        pessoa2.setTelefones(List.of(telefone1, telefone2));
        pessoa2.setProjetos(List.of(projeto1, projeto2));

        projeto1.setPessoas(List.of(pessoa, pessoa2));
        projeto2.setPessoas(List.of(pessoa, pessoa2));

        System.out.println(pessoa2.getTelefones().get(0).getNumero());

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();

        em.close();
        emf.close();
         
    }
}
