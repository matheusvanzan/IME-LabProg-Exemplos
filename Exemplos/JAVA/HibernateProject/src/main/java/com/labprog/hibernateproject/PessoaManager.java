package com.labprog.hibernateproject;

import com.labprog.entities.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PessoaManager {

    public Pessoa create(String nome, String email, String cpf, String tel, String sexo, String dt_) {

        Pessoa rp = null;

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            Pessoa p1 = new Pessoa();
            p1.setEmail(email);
            p1.setNome(nome);
            p1.setCpf(cpf);
            p1.setTelefone(tel);
            p1.setSexo(sexo);

            java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd").parse(dt_);
            java.sql.Date dtBanco = new java.sql.Date(dt.getTime());
            p1.setDatanascimento(dtBanco);

            transaction.begin();
            manager.persist(p1);
            transaction.commit();

            rp = p1;

        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            manager.close();
            factory.close();
        }

        return rp;

    }


}
