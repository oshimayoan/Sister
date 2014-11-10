/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fridge;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Yoan Pratama Putra
 */
public interface RMI extends Remote {
    public void setData(String txt) throws RemoteException;
}
