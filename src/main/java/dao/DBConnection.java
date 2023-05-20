package dao;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBConnection {

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public static Connection getConnection()throws Exception {
        try {
            String serverName  ="34.23.13.26";
            String dbName = "web";
            String portNumber = "3306";
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://"+serverName+":"+portNumber+"/"+dbName;
            String user = "root";
            String pass = "123456789";
            return  DriverManager.getConnection(url,user,pass);

        } catch (ClassNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return null;

    }
    //      public String getImagePath() throws Exception {
//        return "image/";
//    }
    /*Insert your other code right after this comment*/
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    public static void main(String[] args) throws Exception {
        DBConnection  c = new DBConnection();
        System.out.println(c.getConnection());
    }
    public  void excuteSql(String sql) throws Exception{
        Connection connect =getConnection();
        Statement stmt =  connect.createStatement();
        stmt.executeUpdate(sql);
    }
}
