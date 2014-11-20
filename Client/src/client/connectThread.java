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
    private static int fail = 0; // penanda berapa kali gagal konek ke server kulkas
    public void setFail(int a) {
        fail = a;
    }
    public void run() {
        while(true) {
            try {
                // cek konektivitas ke kulkas selama fail != 3*T
                if(fail < 3)
                    if(Main.ConnectServer())
                        Main.refreshList();
                
                sleep(1000);
            } catch(InterruptedException ex) {
                System.out.println(ex);
            }
        }
    }
}
