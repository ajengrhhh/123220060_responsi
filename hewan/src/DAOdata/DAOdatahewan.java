package DAOdata;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksi;
import model.*;
import DAOimplement.hewanimplement;
/**
 *
 * @author 
 */
public class DAOdatahewan implements hewanimplement {
    Connection connection;
 
    final String select = "SELECT * FROM titip_hewan";
    final String insert = "INSERT titip_hewan (nama_pemilik, nama_hewan, jenis_hewan, nomor_telepon, durasi_titip, total_biaya) VALUES (?,?,?,?,?,?);";
    final String update = "UPDATE titip_hewan SET  nama_hewan=?, jenis_hewan=?, nomor_telepon=?, durasi_titip=? where nama_pemilik=?;";
    final String delete = "delete from titip_hewan where nama_pemilik=?";
    
    public DAOdatahewan(){
        connection = koneksi.connection();
    }

    public void insert(datahewan dh) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, dh.getNama_pemilik());
            statement.setString(2, dh.getNama_hewan());
            statement.setString(3, dh.getJenis_hewan());
            statement.setInt(4, dh.getNomor_telepon());
            statement.setInt(5, dh.getDurasi_titip());
            statement.setInt(6, dh.getTotal_biaya());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }

    public void update(datahewan dh) {
           PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update);
            statement.setString(1, dh.getNama_hewan());
            statement.setString(2, dh.getJenis_hewan());
            statement.setInt(3, dh.getNomor_telepon());
            statement.setInt(4, dh.getDurasi_titip());
            statement.setString(5, dh.getNama_pemilik());
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
    public List<datahewan> getAll() {
        List<datahewan> dh = null;
        try{
            dh = new ArrayList<datahewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datahewan dr = new datahewan();
                dr.setId(rs.getInt("id"));
                dr.setNama_pemilik(rs.getString("nama_pemilik"));
                dr.setNama_hewan(rs.getString("nama_hewan"));
                dr.setJenis_hewan(rs.getString("jenis_hewan"));
                dr.setNomor_telepon(rs.getInt("nomor_telepon"));
                dr.setDurasi_titip(rs.getInt("durasi_titip"));
                dr.setTotal_biaya(rs.getInt("total_biaya"));
                dh.add(dr);
            }
        }catch(SQLException ex){
            Logger.getLogger(DAOdatahewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dh;
    }
    public void delete(String nama_pemilik) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, nama_pemilik);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        }finally{
            try{
                statement.close();
            }catch(SQLException ex ){
                ex.printStackTrace();
            }
        }
    }
}
