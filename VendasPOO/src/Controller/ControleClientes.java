/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Clientes;
import Util.ConexaoBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RODRIGORICCIDEPAULAM
 */

public class ControleClientes {

  
    private final Connection con;
    
    public ControleClientes() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    public Clientes inserir(Clientes cliente) throws SQLException{
        
        String sql = "insert into clientes" + " (nome, endereco, bairro,cidade,cep,uf,email,telefone,celular)" + " values (?,?,?,?,?,?,?,?,?)";
    
     
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        stmt.setString(1,cliente.getNome());
        stmt.setString(2,cliente.getEndereco());
        stmt.setString(3,cliente.getBairro());
        stmt.setString(4,cliente.getCidade());
        stmt.setString(5,cliente.getCep());
        stmt.setString(6,cliente.getUf());
        stmt.setString(7,cliente.getEmail());
        stmt.setString(8,cliente.getTelefone());
        stmt.setString(9,cliente.getCelular());
        
        
       
  
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            cliente.setId(id);
        }
        stmt.close();
        con.close();
        return cliente;
    }
    
    
    
    public Clientes alterar(Clientes cliente) throws SQLException{
        
        String sql = "UPDATE clientes SET nome=?, endereco=?, bairro=?,cidade=?,cep=?,uf=?,email=?,telefone=?,celular=? WHERE id = ?";
       
        PreparedStatement stmt = con.prepareStatement(sql);
       
        stmt.setString(1,cliente.getNome());
        stmt.setString(2,cliente.getEndereco());
        stmt.setString(3,cliente.getBairro());
        stmt.setString(4,cliente.getCidade());
        stmt.setString(5,cliente.getCep());
        stmt.setString(6,cliente.getUf());
        stmt.setString(7,cliente.getEmail());
        stmt.setString(8,cliente.getTelefone());
        stmt.setString(9,cliente.getCelular());
        stmt.setInt(10,cliente.getId());

        // executa        
        stmt.execute();
        stmt.close();
        return cliente;
    }
    
    
    
    public Clientes excluir(Clientes cliente) throws SQLException{
        
        String sql = "delete from clientes WHERE id = ?";
      
        PreparedStatement stmt = con.prepareStatement(sql);
      
        stmt.setInt(1,cliente.getId());
     
        stmt.execute();
        stmt.close();
        con.close();
        return cliente; 
    }
    
    
    
    public Clientes buscar(Clientes cliente) throws SQLException{
        
        String sql = "select * from clientes WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
          
            stmt.setInt(1, cliente.getId());
           
            ResultSet rs = stmt.executeQuery();
            Clientes retorno = null;
            while (rs.next()) {      
           
                retorno = new Clientes(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10)
                    
                );
            
            }
            stmt.close();
            con.close();
            return retorno; 
    }
    
    
    
    public List<Clientes> listar(Clientes cliente) throws SQLException{
        
        // usus: array armazena a lista de registros
        ArrayList<Clientes> clientes = new ArrayList<Clientes>();
        
        String sql = "select * from clientes where nome like ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%"+cliente.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Clientes clSaida = new Clientes(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
                rs.getString(8),
                rs.getString(9),
                rs.getString(10)
            );
            // adiciona o usu à lista de usus
            clientes.add(clSaida);
        }
        
        rs.close();
        stmt.close();
        return clientes;
    }
}


