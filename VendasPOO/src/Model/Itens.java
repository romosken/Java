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
public class Itens {
    
    private int idPedido;
    private int idProduto;
    private double qtd;

    public Itens(int idPedido, int idProduto, double qtd) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.qtd = qtd;
    }
    public Itens(int idPedido, int idProduto) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
     
    }
    public Itens(int idPedido) {
        this.idPedido = idPedido;
        
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
    
    
    
    
}
