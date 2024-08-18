package com.labprog.authproject;

import com.labprog.entities.User;
import com.labprog.utils.HashMd5;
import com.labprog.utils.HibernateUtil;
import jakarta.persistence.*;

import org.hibernate.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserManager {

    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<User> users = session.createQuery("FROM User").getResultList();
        t.commit();
        return users;
    }

    public User getByUsername(String username) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("FROM User WHERE username= :username")
                .setParameter("username", username);
        User user = (User) query.getSingleResult();
        t.commit();

        return user;
    }

    public User createUser(String email, String username, String password) { // public User createUser(User user)
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        User u = new User();
        u.setEmail(email);
        u.setUsername(username);

        String hashpwd = HashMd5.hash(password);
        u.setPassword(hashpwd);
        session.save(u);

        t.commit();
        return u;
    }

}
