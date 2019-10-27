import java.sql.*;
import java.util.List;
import java.util.Vector;

public class test {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String username = "root";
        String password = "123456";
        int initConnection = 5000;
        List<Connection>list = new Vector<Connection>();
        long startTime = System.currentTimeMillis();
        for(int i = 0;i<initConnection;i++){
            Connection conn = DriverManager.getConnection(url, username, password);
            list.add(conn);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("创建连接池的时间为：" + (endTime - startTime) +"ms");
        
    }
}