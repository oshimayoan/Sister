/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package smartrefrigerator;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import remoteinterface.RemoteInterface;

/**
 *
 * @author Riyadi Efendi Sembel, Yoan Pratama Putra, Ritos Penyawang, Andreas Budiman
 *
public class Server extends UnicastRemoteObject implements RemoteInterface{
    
    public Server() throws RemoteException{
        super();
    }
        
    @Override
    public String getData(String txt) throws RemoteException {
        txt = "String = " + txt;
        return txt;
    }
    
    public static void main(String args[]){
        try{
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.rebind("server", new Server());
            System.out.println("Server started");
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}*/
