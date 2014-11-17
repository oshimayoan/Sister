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
public class Temperature extends MySQL {
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;
    
    public int getTemp() {
        con = connect(con);
        if(con != null) {
            try {
                String query = "SELECT TemperatureFridge FROM temperature WHERE TemperatureID = 1";
                stmt = con.prepareStatement(query);
                rs = stmt.executeQuery(query);
                int temp = 0;
                if(rs.next())
                    temp = rs.getInt(1);
                return temp;
            } catch(SQLException ex) {
                System.out.println(ex);
            } finally {
                close(con);
            }
        }
        return 0;
    }
}
