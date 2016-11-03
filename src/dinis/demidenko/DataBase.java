package dinis.demidenko;

import java.sql.*;



/**
 * Created by dende on 30.10.2016.
 */
public class DataBase {

    public Connection getDBConnection() {
        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/anketa";
        String password = "0000";
        String username = "root";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }
    public void addBD(String str){
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            String query = str;
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
