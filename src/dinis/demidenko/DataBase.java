package dinis.demidenko;
import java.sql.*;

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
    public ResultSet uploadBD(String str){
        ResultSet r = null;
        try {
            Connection con = getDBConnection();
            Statement statement = con.createStatement();
            String query = str;
            r = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }
    public String printRes(ResultSet rr){
        String res = "";
        res = "<!DOCTYPE html><html><head><link href=\"styles.css\" type=\"text/css\""
                + " rel=\"stylesheet\"><meta charset = \"UTF-8\"><title>Результат</title></head>"
                + "<body>";
        try {
            for(;rr.next();){
                res = res + "<div class=\"divSave\">" + rr.getString("text") + "</div>";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        res = res + "<div id=\"ssilkaRes\"><a"
                + " href=\"index.html\"><p id=\"ssi\">Назад</p></a></div>" + "</body>";
        return res;
    }
}
