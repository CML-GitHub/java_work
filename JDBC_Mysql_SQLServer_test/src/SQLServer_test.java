import java.sql.*;

public class SQLServer_test {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://127.0.0.1:3306/mydb";
        String username = "cml";
        String password = "123456";
        Connection con = DriverManager.getConnection(url, username, password);
        String sqlserver = "SELECT * FROM msg";
        PreparedStatement pre = con.prepareStatement(sqlserver);
        ResultSet resultSet = pre.executeQuery();
        resultSet.next();
        String address = resultSet.getString("address");
        System.out.println(address);
    }
}