/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import DataBase.Database;
import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author helder
 */
public class UsuarioController extends Usuario{
    
    Database db;
    Connection con;
    PreparedStatement pst;
    
    public UsuarioController() throws SQLException{
        super();        
        db = new Database();
        con = db.getConnection();
    }
    
    public int criarConta(Usuario u){
        int res = 0;
        String sql = "";
        
        try{
            //Query
            sql = "INSERT INTO usuario(`id`,`nome`,`email`,`senha`) VALUES(NULL, ?, ?, ?)";
            //prepara a query
            pst = con.prepareStatement(sql);
            
            pst.setString(1, u.getNome());
            pst.setString(2, u.getEmail());
            pst.setString(3, u.getSenha());
            
            res = pst.executeUpdate();
            
        }catch(SQLException e){
            
            System.out.print(e.getMessage());
        }
        
        return res;
    }
    
    public boolean checarLogin(Usuario u){
        String sql = "";
        ResultSet rs = null;
        
        try {
            sql = "SELECT * FROM usuario WHERE email = ? and senha = ?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, u.getEmail());
            pst.setString(2, u.getSenha());
            
            rs = pst.executeQuery();
            
            if(rs.next()){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
       
        return false;
    }
}
