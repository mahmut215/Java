/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Bilgi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SorguDao extends AbstractDAO {

    public List<Bilgi> sorgula(String sorgu, String name[]) {
        List<Bilgi> lList = new ArrayList<>();

        String s[] = sorgu.split(" ");
        System.out.println(" s  = " + s[0]);
        if (s[0] == "INSERT" || s[0] == "CREATE"
                || s[0] == "DROP" || s[0] == "UPDATE"
                || s[0] == "ALTER" || s[0] == "DELETE") {
            try {
                 Bilgi temp = new Bilgi();
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
                name[0] = "hhhhhhhh";
            } catch (SQLException ex) {
                Logger.getLogger(SorguDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                PreparedStatement pst = this.getConnection().prepareStatement(sorgu);
                ResultSet rs = pst.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int sutunSayisi = 0;
                sutunSayisi = rsmd.getColumnCount();
                while (rs.next()) {
                            Bilgi temp = new Bilgi();
                    for (int i = 1; i <= sutunSayisi; i++) {
                        name[i] = rsmd.getColumnName(i);
                        temp.setBilgi(rs.getString(i), i);
                    }
                    lList.add(temp);
                }
            } catch (SQLException | ClassCastException e) {
                System.out.println(e.getMessage());
            }
        }
        return lList;
    }
}
