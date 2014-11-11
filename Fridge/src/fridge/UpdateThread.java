/*
 * Copyright (C) 2014 Windows 8
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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 8
 */
public class UpdateThread extends Thread{
    /*
    
    Pass argument object itu cuman pass pointer gak pass object aslinya
    Jadi kalo dirubah object nya disini yang asli juga kerubah
    DAN pass pointer itu cuman 4 bytes. no prob;
    
    private Main server;
    public UpdateThread(Main server){
        this.server=server;
    }
    Cant be done though, karena lu gabungin main class dengan UserInterface
    
    */
    public UpdateThread(){
        
    }
    public void run(){
        while(true){
            try {
                sleep(1000);
                Main.changeTemperature();
                //not a good practice, can break program if textfield not yet created, THATS WHY YOU START THIS THREAD AFTER INITIAIZATION DONE
            } catch (InterruptedException ex) {
                Logger.getLogger(UpdateThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
