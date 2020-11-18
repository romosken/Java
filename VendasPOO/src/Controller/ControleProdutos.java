/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Produtos;
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
public class ControleProdutos {
     private final Connection con;
    
    public ControleProdutos() throws SQLException, ClassNotFoundException{
        this.con = new ConexaoBD().getConnection();
    } 
    
    public Produtos inserir(Produtos produto) throws SQLException{
        
        String sql = "insert into produtos" + " (descricao, preco, unidade,qtdInicial,data,qtdAtual)" + " values (?,?,?,?,?,?)";
    
     
        PreparedStatement stmt = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);


        stmt.setString(1,produto.getDescricao());
        stmt.setDouble(2,produto.getPreco());
        stmt.setString(3,produto.getUnidade());
        stmt.setDouble(4,produto.getQtd_inicial());
        stmt.setDate(5,produto.getData());
        stmt.setDouble(6,produto.getQtd_atual());
        
        
        
       
  
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            produto.setId(id);
        }
        stmt.close();
        con.close();
        return produto;
    }
    
    
    
    public Produtos alterar(Produtos produto) throws SQLException{
        
        String sql = "UPDATE produtos SET descricao=?, preco=?, unidade=?,qtdInicial=?,data=?,qtdAtual=? WHERE id = ?";
       
        PreparedStatement stmt = con.prepareStatement(sql);
       
        stmt.setString(1,produto.getDescricao());
        stmt.setDouble(2,produto.getPreco());
        stmt.setString(3,produto.getUnidade());
        stmt.setDouble(4,produto.getQtd_inicial());
        stmt.setDate(5,produto.getData());
        stmt.setDouble(6,produto.getQtd_atual());
        stmt.setInt(7,produto.getId());
        

        // executa        
        stmt.execute();
        stmt.close();
        return produto;
    }
    
    
    
    public Produtos excluir(Produtos produto) throws SQLException{
        
        String sql = "delete from produtos WHERE id = ?";
      
        PreparedStatement stmt = con.prepareStatement(sql);
      
        stmt.setInt(1,produto.getId());
     
        stmt.execute();
        stmt.close();
        con.close();
        return produto; 
    }
    
    
    
    public Produtos buscar(Produtos produto) throws SQLException{
        
        String sql = "select * from produtos WHERE id = ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
          
            stmt.setInt(1, produto.getId());
           
            ResultSet rs = stmt.executeQuery();
            Produtos retorno = null;
            while (rs.next()) {      
           
                retorno = new Produtos(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDouble(3),
                    rs.getString(4),
                    rs.getDouble(5),
                    rs.getDate(6),
                    rs.getDouble(7)
                    
                );
            
            }
            stmt.close();
            con.close();
            return retorno; 
    }
    
    
    
    public List<Produtos> listar(Produtos produto) throws SQLException{
        
        
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();
        
        String sql = "select * from produtos where descricao like ?";
        PreparedStatement stmt = this.con.prepareStatement(sql);
       
        stmt.setString(1, "%"+produto.getDescricao() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            
            Produtos prSaida = new Produtos(
                rs.getInt(1),
                rs.getString(2),
                rs.getDouble(3),
                rs.getString(4),
                rs.getDouble(5),
                rs.getDate(6),
                rs.getDouble(7)
                
            );
            
            produtos.add(prSaida);
        }
        
        rs.close();
        stmt.close();
        return produtos;
    }
}
