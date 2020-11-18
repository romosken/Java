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
public class Pedidos {
    
    private int id;
    private int idCliente;
    private Date data;

    public Pedidos(int id) {
        this.id = id;
      
    }
    
    public Pedidos(int idCliente, Date data) {
        this.idCliente = idCliente;
        this.data = data;
    }

    public Pedidos(int id, int idCliente, Date data) {
        this.id = id;
        this.idCliente = idCliente;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    
    
}
