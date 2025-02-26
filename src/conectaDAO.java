
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
         
              conn = null;
              
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost/etapa4", "root", "1234"); //Supersenha0112 ou 1234
              System.out.println("Conectou com o banco de dados!!!!");
          } catch (SQLException ex) {
              System.out.println("Erro: Não foi possivel se conectar no banco de dados!");
          } catch (ClassNotFoundException ex) {
              System.out.println("Erro: Driver JDBC nao encontrado!.");
          }       

          return conn;
      }
    }
    
}
