/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 *
 * @author
 */
public class koneksi {
    static Connection con;
    
    public static Connection connection() {
        if (con==null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("responsi_2024_pbo_if_g");
            data.setUser("root");
            data.setPassword("");
            try {
                con = data.getConnection();
                System.out.println("Koneksi berhasil!");
            } catch (SQLException ex ) {
                ex.printStackTrace();
                System.out.println("Koneksi Gagal!");
            }
        }
        return con;
    }
}
