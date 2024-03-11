package org.example.dataBase;


import org.example.model.angajat;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class angajatDB {
    public static void add( List<angajat> angajati){
        var sql= "INSERT INTO angajati(id,name,parola) "
                + "VALUES(?,?,?)";

        try(var conn =DB.connect();
            var pstmt=conn.prepareStatement(sql)) {
            for(var angajat : angajati){
                pstmt.setInt(1,angajat.getId());
                pstmt.setString(2,angajat.getNumeCasier());
                pstmt.setInt(3,angajat.getParolaCasier());
                pstmt.addBatch();

            }

            pstmt.executeBatch();


        }catch (SQLException e){
            e.printStackTrace();
        }
        //return -1;
    }

    public static List<angajat>  findAll() throws SQLException {
        var angajati= new ArrayList<angajat>();
         var sql= "SELECT id, name,parola FROM angajati ORDER BY name";

         try(var conn =DB.connect();
         var stmt=conn.createStatement()){
             var rs=stmt.executeQuery(sql);

             while ((rs.next())){
                 var angajat= new angajat(
                         rs.getInt("id"),
                         rs.getString("name"),
                         rs.getInt("parola"));
                    angajati.add(angajat);

             }
         }catch (SQLException e){
             e.printStackTrace();
         }
         return angajati;
    }

    public static int delete (int id) throws SQLException {
        var sql= "DELETE FROM angajati WHERE id=?";

        try(var conn = DB.connect();
        var pstmt=conn.prepareStatement(sql)){
            pstmt.setInt(1,id);

            return pstmt.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }
}
