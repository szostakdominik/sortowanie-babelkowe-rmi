package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Sortowanie extends Remote {
    public int[] sortuj_rosnaco(String a) throws RemoteException;
    public int[] sortuj_malejaco(String a) throws RemoteException;
}
