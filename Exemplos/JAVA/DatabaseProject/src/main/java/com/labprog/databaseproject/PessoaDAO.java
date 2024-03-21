package com.labprog.databaseproject;

import java.sql.*;
import java.util.*;

public class PessoaDAO {
    Connection db;

    public PessoaDAO() throws ClassNotFoundException, SQLException {
        ConnectionFactory conn = new ConnectionFactory();
        db = conn.Connect();
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws SQLException, Throwable {
        try {
            db.close();
        } finally {
            super.finalize();
        }
    }

    public int insert(Pessoa p) throws SQLException {
        String queryString = "INSERT INTO pessoa (nome, email, cpf, telefone, sexo, datanascimento)";
        queryString += " VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = db.prepareStatement(queryString);

        java.util.Date dt = p.getDtNasc();
        java.sql.Date dtBanco = new java.sql.Date(dt.getTime());

        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEmail());
        stmt.setString(3, p.getCpf());
        stmt.setString(4, p.getTelefone());
        stmt.setString(5, p.getSexo());
        stmt.setDate(6, dtBanco);

        return stmt.executeUpdate();
    }

    public List<Pessoa> search(String email) throws SQLException {
        String queryString = "SELECT nome, email FROM pessoa WHERE email=?";
        PreparedStatement stmt = db.prepareStatement(queryString);
        stmt.setString(1, email);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pessoa p = new Pessoa();
            p.setNome(rs.getString(1));
            p.setEmail(rs.getString(2));
            pessoas.add(p);
        }

        return pessoas;
    }

    public List<Pessoa> listAll() throws SQLException {
        String queryString = "SELECT nome, email FROM pessoa WHERE 1";
        PreparedStatement stmt = db.prepareStatement(queryString);

        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Pessoa p = new Pessoa();
            p.setNome(rs.getString(1));
            p.setEmail(rs.getString(2));
            pessoas.add(p);
        }

        return pessoas;
    }
}
