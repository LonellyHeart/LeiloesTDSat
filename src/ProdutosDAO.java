/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
                    conn = new conectaDAO().connectDB();
                    String sql = "INSERT INTO produtos(nome, valor, status) VALUES (?, ?, ?)";
                    
                    try {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setInt(2, produto.getValor());
                        stmt.setString(3, produto.getStatus());
                        stmt.execute();
                        
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir produto: " + e.getMessage());
                    }
                    
        
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
                conn = new conectaDAO().connectDB();
                String sql = "SELECT * FROM produtos";
                
                try {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    ResultSet rs = stmt.executeQuery();          
                    
                    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

                    while (rs.next()) {
                    ProdutosDTO produtos = new ProdutosDTO();
                    
                    produtos.setId(rs.getInt("id"));
                    produtos.setNome(rs.getString("nome"));
                    produtos.setValor(rs.getInt("valor"));
                    produtos.setStatus(rs.getString("status"));  
                    
                    listagem.add(produtos);
                            
                    }
                    return listagem;
                    
                } catch (Exception e) {
                    return null;
                }
                
     }

    public void venderProduto(int idproduto) {
         conn = new conectaDAO().connectDB();
         String sql = "UPDATE produtos SET status = 'Vendido' where id = ? ";
                    try {
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setInt(1, idproduto);
                        stmt.execute();
                        
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao atualizar status do produto: " + e.getMessage());
                    }
    } 

    public ArrayList<ProdutosDTO> listarProdutosVendidos(String statusProduto){
                conn = new conectaDAO().connectDB();
                String sql = "SELECT * FROM produtos WHERE status = ?";
                
                try {
                    PreparedStatement stmt = conn.prepareStatement(sql);
                    stmt.setString(1, statusProduto);
                    ResultSet rs = stmt.executeQuery();          
                    
                    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

                    while (rs.next()) {
                    ProdutosDTO produtos = new ProdutosDTO();
                    
                    produtos.setId(rs.getInt("id"));
                    produtos.setNome(rs.getString("nome"));
                    produtos.setValor(rs.getInt("valor"));
                    produtos.setStatus(rs.getString("status"));  
                    
                    listagem.add(produtos);
                            
                    }
                    return listagem;
                    
                } catch (Exception e) {
                    return null;
                }
                
     }
}
