/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */

public class Clientes {
    
    private int id;
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String cep;
    private String uf;
    private String email;
    private String telefone;
    private String celular;

    public Clientes(int id) {
        this.id = id;
    }
     
    public Clientes(String nome) {
        this.nome = nome;
    }

    public Clientes(String nome, String endereco, String bairro, String cidade, String cep, String uf, String email, String telefone, String celular) {
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public Clientes(int id, String nome, String endereco, String bairro, String cidade, String cep, String uf, String email, String telefone, String celular) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.uf = uf;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }  
    
}
