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
    public String getStatus() {
        return status;
    }
    
    public Fridge() throws RemoteException{
        super();
    }
    
    public void start() {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", new Fridge());
            status = "Started";
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void stop(){
        try {
            
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
    private static String data = null;
    public String getData() {
        return data;
    }

    @Override
    public void setData(String txt) throws RemoteException {
        System.out.println(txt);
        this.data = txt;
        Main.xxx = txt;
    }
    
}
