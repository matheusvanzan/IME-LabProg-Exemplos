package com.labprog.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "pessoa", schema = "labprog3", catalog = "")
public class Pessoa {
    @Basic
    @Column(name = "nome")
    private String nome;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "cpf")
    private String cpf;
    @Basic
    @Column(name = "telefone")
    private String telefone;
    @Basic
    @Column(name = "sexo")
    private String sexo;
    @Basic
    @Column(name = "datanascimento")
    private Date datanascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa that = (Pessoa) o;

        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (cpf != null ? !cpf.equals(that.cpf) : that.cpf != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (sexo != null ? !sexo.equals(that.sexo) : that.sexo != null) return false;
        if (datanascimento != null ? !datanascimento.equals(that.datanascimento) : that.datanascimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (cpf != null ? cpf.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (sexo != null ? sexo.hashCode() : 0);
        result = 31 * result + (datanascimento != null ? datanascimento.hashCode() : 0);
        return result;
    }
}
