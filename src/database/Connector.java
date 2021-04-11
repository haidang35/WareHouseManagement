package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    public final static String connectString = "jdbc:mysql://localhost:3306/warehouse";
    public final static String username = "root";
    public final static String password = "";
    public Statement statement;
    private static Connector instance;

    private Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(connectString,username,password);
            Statement stt = conn.createStatement();
            statement = stt;

        }catch (ClassNotFoundException ce){
            System.out.println("Class not found");
        }catch (SQLException se){
            System.out.println("Connect error");
        }
    }

    public static Connector getInstance() {
        if(instance == null)
            instance = new Connector();

        return instance;
    }
    public Statement getStatement(){
        return this.statement;
    }

}
