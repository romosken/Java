/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Itens;
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
public class ControleItens {
    private final Connection con;
    
    public ControleItens() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    
    public Itens inserir(Itens item) throws SQLException{
        
        String sql = "insert into itens" + " (idPedido, idProduto, qtd)" + " values (?,?,?)";
    
     
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        stmt.setInt(1,item.getIdPedido());
        stmt.setInt(2,item.getIdProduto());
        stmt.setDouble(3,item.getQtd());
        
        stmt.executeUpdate();
        stmt.close();
        con.close();
        return item;
    }
    
    
    
    public Itens alterar(Itens item) throws SQLException{
        
        String sql = "UPDATE itens SET qtd=? WHERE idPedido = ? and idProduto=?";
       
        PreparedStatement stmt = con.prepareStatement(sql);
       
        stmt.setDouble(1,item.getQtd());
        stmt.setInt(2,item.getIdPedido());
        stmt.setInt(3,item.getIdProduto());
        
        stmt.execute();
        stmt.close();
        return item;
    }
    
    
    
    public Itens excluir(Itens item) throws SQLException{
        
        String sql = "delete from itens WHERE idPedido = ? and idProduto=?";
      
        PreparedStatement stmt = con.prepareStatement(sql);
      
        stmt.setInt(1,item.getIdPedido());
        stmt.setInt(2,item.getIdProduto());
     
        stmt.execute();
        stmt.close();
        con.close();
        return item; 
    }
    
    
    
    public Itens buscar(Itens item) throws SQLException{
        
        String sql = "select * from itens WHERE idPedido = ? and idProduto=?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
          
            stmt.setInt(1,item.getIdPedido());
            stmt.setInt(2,item.getIdProduto());
           
            ResultSet rs = stmt.executeQuery();
            Itens retorno = null;
            while (rs.next()) {      
           
                retorno = new Itens(
                   rs.getInt(1),
                   rs.getInt(2),
                   rs.getDouble(3)
                    
                );
            
            }
            stmt.close();
            con.close();
            return retorno; 
    }
    
    
    
    public List<Itens> listar(Itens item) throws SQLException{
        
        // usus: array armazena a lista de registros
        ArrayList<Itens> itens = new ArrayList<Itens>();
        
        String sql = "select * from itens";
        PreparedStatement stmt = this.con.prepareStatement(sql);
        if(item.getIdPedido()!=0)
        {
          
            sql = "select * from itens where idPedido = ?";
            stmt = this.con.prepareStatement(sql);
            stmt.setInt(1, item.getIdPedido());
            
        }
      
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Itens itSaida = new Itens(
                rs.getInt(1),
                rs.getInt(2),
                rs.getDouble(3)
                
            );
            // adiciona o usu à lista de usus
            itens.add(itSaida);
        }
        
        rs.close();
        stmt.close();
        return itens;
    }
}
