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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yoan Pratama Putra
 */
public class MySQL {
    private final String url = "jdbc:mysql://localhost/fridge";
    private final String user = "root";
    private final String pass = "";
    
    public Connection connect(Connection con) {
        try {
            try {
                // membuka koneksi ke database mysql
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (Exception ex) {
                System.out.println(ex);
            }
            con = DriverManager.getConnection(url, user, pass);
            return con;
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public void close(Connection con) {
        try {
            // menutup koneksi ke database mysql
            if(con != null) {
                con.close();
                con = null;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    
}
