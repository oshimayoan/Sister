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

package client;

/**
 *
 * @author Yoan Pratama Putra
 */
public class connectThread extends Thread {
    public void run() {
        while(true) {
            try {
                // cek konektivitas ke kulkas
                int con = Main.ConnectServer();
                sleep(1000);
                
                if(con > 0) Main.asyncList();
            } catch(InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
