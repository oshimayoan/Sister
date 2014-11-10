/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        return 5;
    }
    
}
