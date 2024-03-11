package org.example.dataBase;



import org.example.model.produs;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class produseDB {
    public static void addProduse (List<produs> produse) throws SQLException {
        var sql= "INSERT INTO produse(codProdus,denumire,pret)" +
                "VALUES(?,?,?)";

        try( var conn= DB.connect();
        var pstmt=conn.prepareStatement(sql)){
            for(var produs: produse){
                pstmt.setInt(1,produs.getCodProdus());
                pstmt.setString(2,produs.getDenumire());
                pstmt.setDouble(3,produs.getPret());
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch(SQLException e){
            e.printStackTrace();
        }
    }


    public static int delete(int codprodus) throws SQLException {
        var sql ="DELETE FROM produse WHERE codprodus=?";

        try(var conn =DB.connect();
            var pstmt=conn.prepareStatement(sql)){

            pstmt.setInt(1,codprodus);
            return pstmt.executeUpdate();
            }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

    public static List<produs>  findALL(){
        var produse= new ArrayList<produs>();
        var sql= "SELECT codprodus,denumire,pret FROM produse ORDER BY denumire";

        try(var conn=DB.connect();
        var stmt=conn.createStatement()){
            var rs=stmt.executeQuery(sql);

            while ((rs.next())){
                var produs= new produs(
                        rs.getInt("codprodus"),
                        rs.getString("denumire"),
                        rs.getDouble("pret"));
                        produse.add(produs);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return produse;
    }
}
