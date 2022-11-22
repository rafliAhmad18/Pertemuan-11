
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class fasilitas {
    private Connection Koneksi;
    public fasilitas(){
        Koneksi = KoneksiDatabase.getKoneksi();  
    }
    public void insert(barang barang){
        PreparedStatement prepare = null;
        try{
        String sql ="INSERT INTO barang(kode_barang,nama_barang,jumlah,harga)VALUES(?,?,?,?)";
        prepare = (PreparedStatement) Koneksi.prepareStatement(sql);
        prepare.setString(1, barang.getKode_barang());
        prepare.setString(2, barang.getNama_barang());
        prepare.setInt(3, barang.getJumlah());
        prepare.setLong(4, barang.getHarga());
        prepare.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");  
        }catch(SQLException ex){
            System.out.println("Prepare Statement gagal dibuat");
            System.out.println("pesan : " + ex.getMessage());
        }finally{
            if (prepare != null){
            try{
                prepare.close();
                System.out.println("Prepare statemen berhasil ditutup");
            }catch(SQLException ex){
                System.out.println("Prepare statemen gagal ditutup");
                System.out.println("Pesan : " + ex.getMessage());
            }
            }
        }
    } 
    public void delete(barang barang){
        PreparedStatement prepare = null;
        try{
        String sql ="INSERT INTO barang(kode_barang,nama_barang,jumlah,harga)VALUES(?,?,?,?)";
        prepare = (PreparedStatement) Koneksi.prepareStatement(sql);
        prepare.setString(1, barang.getKode_barang());
        prepare.setString(2, barang.getNama_barang());
        prepare.setInt(3, barang.getJumlah());
        prepare.setLong(4, barang.getHarga());
        prepare.executeUpdate();
        System.out.println("Prepare statement berhasil dibuat");  
        }catch(SQLException ex){
            System.out.println("Prepare Statement gagal dibuat");
            System.out.println("pesan : " + ex.getMessage());
        }finally{
            if (prepare != null){
            try{
                prepare.close();
                System.out.println("Prepare statemen berhasil ditutup");
            }catch(SQLException ex){
                System.out.println("Prepare statemen gagal ditutup");
                System.out.println("Pesan : " + ex.getMessage());
            }
            }
        }
    }
    public List<barang> selectAll(){
        PreparedStatement prepare = null; 
        ResultSet result = null;
        List<barang> list = new ArrayList<>();
        try {
            String sql ="SELECT * FROM barang";
             prepare = (PreparedStatement) Koneksi.prepareStatement(sql);
             result = prepare.executeQuery();
             while (result.next()){
                 barang barang = new barang();
                 barang.setNama_barang(result.getString("nama_barang"));
                 barang.setJumlah(result.getInt("jumlah"));
                 barang.setHarga(result.getLong("harga"));
                 list.add(barang);
             }
             System.out.println("Prepare statement berhasil dibuat");
             return list;
        }catch(SQLException ex){
         System.out.println("Prepare statement gagal dibuat");
         System.out.println("Pesan : " + ex.getMessage());
         return list;   
        }finally{
            if (prepare != null){
                try{
                    prepare.close();
                    System.out.println("Prepare statemen berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Prepare statemen gagal ditutup"); 
                    System.out.println("Pesan : " + ex.getMessage());
                }
            }
            if (result != null){
                try{
                    result.close();
                    System.out.println("Resultset berhasil ditutup");
                }catch(SQLException ex){
                    System.out.println("Resultset gagal ditutup");
                    System.out.println("Pesan : " + ex.getMessage());

                }
            }
        }
    }
}