
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author helder
 */
public class Database {
    
    private Connection con;
    private String url;
    private String username;
    private String password;
    
    public Database(){
        url = "jdbc:mysql://localhost:3306/playerlistener";
        username = "admin";
        password = "admin4321";
    }
    
    public Connection getConnection() throws SQLException{
        //carregar os drivers
        
        try{
            Class.forName("com.mysql.jdbc");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        try{
            con = DriverManager.getConnection(url, username, password);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return con;
    }
}
