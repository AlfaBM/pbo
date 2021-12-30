package Model;
import Entity.Rekening;
import Entity.User;
import KoneksiDB.KoneksiDB;

import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;


public class UserModel {
    private String sql;
    Connection conn = KoneksiDB.getconection();

    public ArrayList<User> getUser(){
        ArrayList<User> arraylistUser = new ArrayList<>();
        try {
            Statement stat = conn.createStatement();
            sql = "SELECT * FROM user";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()){
                User userEntity = new User(rs.getString("email"),rs.getString("password"),
                        rs.getInt("id"),rs.getString("nama"),rs.getString("noktp"),
                        rs.getString("notelp"),rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistUser;
    }

    public ArrayList<User> getUserby(int id){
        ArrayList<User> arraylistUser = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement statAlfa = conn.prepareStatement(sql);
            statAlfa.setInt(1,id);
            ResultSet rs = statAlfa.executeQuery();
            while (rs.next()){
                User userEntity = new User(rs.getString("email"),rs.getString("password"),
                        rs.getInt("id"),rs.getString("nama"),rs.getString("noktp"),
                        rs.getString("notelp"),rs.getString("alamat"));
                arraylistUser.add(userEntity);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistUser;
    }

    public ArrayList<Rekening> getsaldoby(int id){
        ArrayList<Rekening> arraylistrek = new ArrayList<>();
        try {
            sql = "SELECT * FROM user where id =?";
            PreparedStatement statAlfa = conn.prepareStatement(sql);
            statAlfa.setInt(1,id);
            ResultSet rs = statAlfa.executeQuery();
            while (rs.next()){
                Rekening rek = new Rekening(rs.getInt("saldo"));
                arraylistrek.add(rek);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
        return arraylistrek;
    }


    public void registrasi(User User){
        try {
            sql = "INSERT INTO user (email, password, nama, noktp, notelp, alamat) VALUE('%s', '%s', '%s', '%s', '%s', '%s')";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,User.getEmail());
            stat.setString(2,User.getPass());
            stat.setString(3,User.getNama());
            stat.setString(4,User.getNoktp());
            stat.setString(5,User.getNotelp());
            stat.setString(6,User.getAlamat());

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Registrasi!!");
            e.printStackTrace();
        }
    }

    public int cekLogin(String email, String pass){
        int cek = 0;
        try {
            sql = "SELECT * FROM user where email =? and password =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,email);
            stat.setString(2,pass);
            ResultSet rs = stat.executeQuery();
            if (rs.next()){
                cek = rs.getInt("id");
            }else {
                cek = 0;
            }
        }catch (SQLException e){
            System.out.println("Password / Email Salah!!");
            e.printStackTrace();
        }return cek;
    }

    public void updatePassword(String pass, int id){
        try {
            sql = "update user SET password =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,pass);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Ubah Password!!");
            e.printStackTrace();
        }
    }

    public void updateNotelp(String notelp, int id){
        try {
            sql = "update user SET noTelp =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,notelp);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Mengubah Nomor Telepon!!");
            e.printStackTrace();
        }
    }

    public void updateAlamat(String alamat, int id){
        try {
            sql = "update user SET alamat =? WHERE id =?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,alamat);
            stat.setInt(2,id);

            stat.executeUpdate();
        }catch (SQLException e){
            System.out.println("Gagal Ubah Alamat!!");
            e.printStackTrace();
        }
    }

}
