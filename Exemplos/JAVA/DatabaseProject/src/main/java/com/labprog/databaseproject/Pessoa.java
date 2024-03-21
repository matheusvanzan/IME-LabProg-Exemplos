package com.labprog.databaseproject;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    private String nome, email, cpf, telefone;
    private boolean sexo;
    private Date dtNasc;

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getSexo() { return sexo ? "M" : "F"; }

    public void setSexo(String s) { sexo = (s == "M"); }

    public Date getDtNasc() { return dtNasc; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDtNascStr() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dtNasc);
    }

    public void setDtNasc(Date dtNasc) { this.dtNasc = dtNasc; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        String s = String.format("<Pessoa nome: %s>", nome);
        return s;
    }
}



