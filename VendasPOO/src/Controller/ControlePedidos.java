/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pedidos;
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
public class ControlePedidos {
    private final Connection con;
    
    public ControlePedidos() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    public Pedidos inserir(Pedidos pedido) throws SQLException{
        
        String sql = "insert into pedidos" + " (idCliente, data)" + " values (?,?)";
    
     
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        
        stmt.setInt(1,pedido.getIdCliente());
        stmt.setDate(2,pedido.getData());
        
  
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            pedido.setId(id);
        }
        stmt.close();
        con.close();
        return pedido;
    }
    
    
    
    public Pedidos alterar(Pedidos pedido) throws SQLException{
        
        String sql = "UPDATE pedidos SET idCliente=?, data=? WHERE id = ?";
       
        PreparedStatement stmt = con.prepareStatement(sql);
       
        stmt.setInt(1,pedido.getIdCliente());
        stmt.setDate(2,pedido.getData());
        
        stmt.setInt(3,pedido.getId());
        

                
        stmt.execute();
        stmt.close();
        return pedido;
    }
    
    
    
    public Pedidos excluir(Pedidos pedido) throws SQLException{
        
        String sql = "delete from pedidos WHERE id = ?";
      
        PreparedStatement stmt = con.prepareStatement(sql);
      
        stmt.setInt(1,pedido.getId());
     
        stmt.execute();
        stmt.close();
        con.close();
        return pedido; 
    }
    
    
    
    public Pedidos buscar(Pedidos pedido) throws SQLException{
        
        String sql = "select * from pedidos WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
          
            stmt.setInt(1, pedido.getId());
           
            ResultSet rs = stmt.executeQuery();
            Pedidos retorno = null;
            while (rs.next()) {      
           
                retorno = new Pedidos(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getDate(3)
                    
                );
            
            }
            stmt.close();
            con.close();
            return retorno; 
    }
    
    
    
    public List<Pedidos> listar(Pedidos pedido) throws SQLException{
        
        
        ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
        
        String sql = "select * from pedidos";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        if(pedido.getId() != 0)
        {
            sql = "select * from pedidos where id = ?";
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
        }
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            
            Pedidos peSaida = new Pedidos(
                rs.getInt(1),
                rs.getInt(2),
                rs.getDate(3)
                
            );
            
            pedidos.add(peSaida);
        }
        
        rs.close();
        stmt.close();
        return pedidos;
    }
}
