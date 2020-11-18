/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */
public class Produtos {
    
    private int id;
    private String descricao;
    private double preco;
    private String unidade;
    private double qtd_inicial;
    private Date data;
    private double qtd_atual;

    
    public Produtos(int id) {
        this.id = id;
        
    }
    public Produtos(String descricao) {
        this.descricao = descricao;
        
    }
    public Produtos(String descricao, double preco, String unidade, double qtd_inicial, Date data, double qtd_atual) {
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
        this.qtd_inicial = qtd_inicial;
        this.data = data;
        this.qtd_atual = qtd_atual;
    }

    public Produtos(int id, String descricao, double preco, String unidade, double qtd_inicial, Date data, double qtd_atual) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.unidade = unidade;
        this.qtd_inicial = qtd_inicial;
        this.data = data;
        this.qtd_atual = qtd_atual;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getQtd_inicial() {
        return qtd_inicial;
    }

    public void setQtd_inicial(double qtd_inicial) {
        this.qtd_inicial = qtd_inicial;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getQtd_atual() {
        return qtd_atual;
    }

    public void setQtd_atual(double qtd_atual) {
        this.qtd_atual = qtd_atual;
    }
    
    
}
