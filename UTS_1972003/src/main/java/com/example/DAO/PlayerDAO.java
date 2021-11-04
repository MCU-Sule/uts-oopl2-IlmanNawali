/**
 * Ilman Nawali 1972003
 */
package com.example.DAO;

import com.example.entity.Player;
import com.example.util.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlayerDAO implements daoInterface<Player>{
    @Override
    public int addData(Player data) {
        int result = 0;
        try {
            String query = "INSERT INTO player (id,nama,umur,keahlian) VALUES (?,?,?,?)";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setInt(1,data.getId());
            ps.setString(2,data.getNama());
            ps.setInt(3,data.getUmur());
            ps.setString(4,data.getKehlian());
            result = ps.executeUpdate();
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public int delData(Player data) {
        int result = 0;
        try {
            String query = "Delete FROM player WHERE id=?";
            Connection conn = JDBCConnection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement ps;
            ps= conn.prepareStatement(query);
            ps.setInt(1,data.getId());
            result= ps.executeUpdate();
            if (result != 0){
                conn.commit();
            }
            else{
                conn.rollback();
            }

        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return result;
    }

    @Override
    public int updateData(Player data) {
        int result = 0;
        try {
            String query = "Update player set name=?, umur=?, keahlian=? where id=?";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ps.setString(1, data.getNama());
            ps.setInt(2, data.getUmur());
            ps.setString(3, data.getKehlian());
            ps.setInt(4, data.getId());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return result;
    }

    @Override
    public List<Player> showData() {
        ObservableList<Player> cList = FXCollections.observableArrayList();

        try {
            String query = "SELECT * FROM player;";
            PreparedStatement ps;
            ps = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while (res.next()){
                int id= res.getInt("id");
                String nama = res.getString("nama");
                int umur= res.getInt("umur");
                String keahlian = res.getString("keahlian");
                Player pla = new Player(id, nama, umur, keahlian);
                cList.add(pla);
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }

        return cList;
    }
}
