/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package remoteinterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Riyadi Efendi Sembel, Yoan Pratama Putra, Ritos Penyawang, Andreas Budiman
 */
public interface RemoteInterface extends Remote {
    public void setData(String txt) throws RemoteException;
}
