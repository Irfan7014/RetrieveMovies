package databases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class MovieDatabase {
    public Connection c;
    public Statement s;
    public MovieDatabase()
    {  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///movies","root","irfanabidi");    
            s =c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
