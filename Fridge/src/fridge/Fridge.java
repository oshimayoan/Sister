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

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Yoan Pratama Putra
 */
public class Fridge extends UnicastRemoteObject implements RMI {

    private static String status = null;
    private Registry reg;
    
    public String getStatus() {
        return status;
    }
    
    public Fridge() throws RemoteException{
        super();
    }
    
    public void start() {
        try {
            reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", new Fridge());
            this.status = "Started";
        } catch(Exception ex) {
            System.out.println("new : " + ex);
        }
    }
    
    public void stop(){
        try {
            UnicastRemoteObject.unexportObject(reg, true);
            reg.unbind("server");
            this.status = null;
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void setTemperature(int temp) throws RemoteException {
        System.out.println(temp);
        Main.temperature = temp;
    }

    @Override
    public int getTemperature() throws RemoteException {
        return Main.getTemperature();
    }
    
}
