package KoneksiDB;
import java.sql.Connection;
import java.sql.DriverManager;

public class KoneksiDB {
    public static Connection getconection(){
        Connection conn = null;
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost/db_dompet";
        String user = "root";
        String pass = "";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user,pass);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
