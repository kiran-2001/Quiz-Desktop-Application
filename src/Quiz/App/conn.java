package Quiz.App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class conn {
    Connection c;
    Statement s;
    public conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c =DriverManager.getConnection("jdbc:mysql://localhost:3306/rit","root","8600");
            s =c.createStatement();
            System.out.println("Hello, You are Connected with database successfully.");

        }catch(Exception e){
            System.out.println();
        }
    }
}
