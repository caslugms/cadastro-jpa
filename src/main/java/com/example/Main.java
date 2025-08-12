package com.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Documento documento = new Documento();
        documento.setEmissor("ssp");
        documento.setTipo("rg");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Fulano de Tal");
        pessoa.setDocumento(documento);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("meuPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(pessoa);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
