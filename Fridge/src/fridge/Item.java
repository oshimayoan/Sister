/*
 * Copyright (C) 2014 Yoan Pratama Putra
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package fridge;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Yoan Pratama Putra
 */
public class Item extends MySQL {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public void addItem(String itemName) {
        con = connect(con);
        if(con != null) {
            try {
                // cek apakah ada barang yang sama di kulkas
                String query = "SELECT count(*) FROM item WHERE ItemName = '" + itemName + "'";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                int cek = 0;
                if(rs.next())
                    cek = rs.getInt(1);
                
                // jika ada
                if(cek > 0) {
                    query = "UPDATE item SET ItemQuantity = ItemQuantity + 1 WHERE ItemName = '" + itemName + "'";
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                } else { // jika tidak ada
                    query = "INSERT INTO item (ItemName, ItemQuantity) VALUES ('" + itemName + "', '1')";
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                }
            } catch(SQLException ex) {
                System.out.println(ex);
            } finally {
                try {
                    if(con != null)
                        close(con);
                    if(stmt != null)
                        stmt.close();
                } catch(SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
    
    public void removeItem(String itemName) {
        con = connect(con);
        if(con != null) {
            try {
                // cek sisa barang yang akan dihapus dari database
                String query = "SELECT ItemQuantity FROM item WHERE ItemName = '" + itemName + "'";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                int left = 0;
                if(rs.next())
                    left = rs.getInt(1);
                
                // jika masih > 1
                if(left > 1) {
                    query = "UPDATE item SET ItemQuantity = ItemQuantity - 1 WHERE ItemName = '" + itemName + "'";
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                } else { // jika sisa 1
                    query = "DELETE FROM item WHERE ItemName = '" + itemName + "'";
                    stmt = con.createStatement();
                    stmt.executeUpdate(query);
                }
            } catch(SQLException ex) {
                System.out.println(ex);
            } finally {
                try {
                    if(con != null)
                        close(con);
                    if(stmt != null)
                        stmt.close();
                } catch(SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
    }
    
    public ArrayList getItems() {
        con = connect(con);
        if(con != null) {
            try {
                String query = "SELECT ItemName, ItemQuantity FROM item";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                ArrayList<List> data = new ArrayList<>();
                while(rs.next()) {
                    List tmp = new List();
                    tmp.setName(rs.getString(1));
                    tmp.setQuantity(rs.getInt(2));
                    data.add(tmp);
                }
                return data;
            } catch(SQLException ex) {
                System.out.println(ex);
            } finally {
                try {
                    if(con != null)
                        close(con);
                    if(stmt != null)
                        stmt.close();
                    if(rs != null)
                        rs.close();
                } catch(SQLException ex) {
                    System.out.println(ex);
                }
            }
        }
        return null;
    }
}
