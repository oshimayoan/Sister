/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import remoteinterface.RemoteInterface;

/**
 *
 * @author Riyadi Efendi Sembel, Yoan Pratama Putra, Ritos Penyawang, Andreas Budiman
 */
public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.connectServer();
    }

    private void connectServer() {
        try{
            Registry reg = LocateRegistry.getRegistry("127.0.0.1", 1099);
            RemoteInterface rmi = (RemoteInterface) reg.lookup("server");
            System.out.println("Connected to server");
//            String txt = rmi.getData("Yoan");
//            System.out.println(txt);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
}
