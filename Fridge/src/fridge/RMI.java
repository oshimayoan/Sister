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

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Yoan Pratama Putra
 */
public interface RMI extends Remote {
    public void setTemperature(int temp, int freezer) throws RemoteException;
    public int getTemperature() throws RemoteException;
    public int getFreezerTemp() throws RemoteException;
    public Object[][] getItemList() throws RemoteException;
    public int getNumItem() throws RemoteException;
    public boolean login(String user, String pass) throws RemoteException;
}
