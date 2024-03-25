package com.labprog.hibernateproject;

import com.labprog.entities.Pessoa;
import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class PessoaManager {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public Pessoa create(String nome, String email, String cpf, String tel, String sexo, String dt_) {

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Pessoa p1 = new Pessoa();
        p1.setEmail(email);
        p1.setNome(nome);

        em.persist(p1);
        em.getTransaction().commit();

        return p1;
    }

    public List<Pessoa> getAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<Pessoa> pessoaList = em.createQuery("from Pessoa as pessoa").getResultList();
        return pessoaList;
    }

    public Pessoa getByEmail(String email) {
        EntityManager em = getEntityManager();
        Pessoa p = em.find(Pessoa.class, email);
        em.detach(p);
        return p;
    }

}
