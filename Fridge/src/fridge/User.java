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

/**
 *
 * @author Yoan Pratama Putra
 */
public class User extends MySQL {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    private String query = null;
    private String user;
    private String pass;
    
    public boolean Login(String a, String b) {
        con = connect(con);
        if(con != null) {
            try {
                // ambil data barang dari kulkas
                query = "SELECT UserName, UserPassword FROM user WHERE UserID";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                if(rs.next()) {
                    this.user = rs.getString(1);
                    this.pass = rs.getString(2);
                }
                if(this.user.equals(a) & this.pass.equals(b))
                    return true;
            } catch(SQLException ex) {
                System.out.println(ex);
            }
        }
        return false;
    }
}
