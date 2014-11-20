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
    private Temperature tempClass;
    private Item itemClass;
    
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
            status = "Running";
        } catch(RemoteException ex) {
            System.out.println("new : " + ex);
        }
    }
    
    public void stop(){
        try {
            UnicastRemoteObject.unexportObject(reg, true);
            reg.unbind("server");
            status = null;
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void setTemperature(int temp, int freezer) throws RemoteException {
        tempClass = new Temperature();
        tempClass.setTemp(temp, freezer);
    }

    @Override
    public int getTemperature() throws RemoteException {
        tempClass = new Temperature();
        return tempClass.getTemp();
    }

    @Override
    public int getFreezerTemp() throws RemoteException {
        tempClass = new Temperature();
        return tempClass.getFreezer();
    }

    @Override
    public Object[][] getItemList() {
        itemClass = new Item();
        return itemClass.getItems();
    }

    @Override
    public int getNumItem() throws RemoteException {
        itemClass = new Item();
        return itemClass.getNumItem();
    }

    @Override
    public boolean login(String user, String pass) throws RemoteException {
        User usr = new User();
        if(usr.Login(user, pass))
            return true;
        return false;
    }
    
}
