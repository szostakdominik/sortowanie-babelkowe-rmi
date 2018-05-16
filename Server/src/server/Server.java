package server;

import gui.GUI;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import rmi.Sortowanie;

public class Server implements Sortowanie {
    
    private GUI gui;
    
    public Server(GUI g) {
        gui = g;
    }
    
    public void bindStub() {
        try {
            LocateRegistry.createRegistry(1099);
            Sortowanie stub = (Sortowanie) UnicastRemoteObject.exportObject(this, 1099);
            Registry reg = LocateRegistry.getRegistry();
            reg.bind("Sortowanie", stub);
            gui.getTextArea().setText(">>>>> Serwer gotowy do pracy.");
        } catch(Exception e) {
            gui.getTextArea().setText(gui.getTextArea().getText() + "\n>>>>> Wystąpił błąd: " + e.toString());
        }
    }
    
    public int[] sortuj_rosnaco(String a) throws RemoteException {
        gui.getTextArea().setText(gui.getTextArea().getText() + 
                "\n>>>>> Sortowanie zostało wywołane.");
        String[] str = a.split(",");
        int[] tab = new int[str.length];
        for(int i=0;i<str.length;i++){
               tab[i] = Integer.parseInt(str[i]);   
        }
        
        int temp;
        int zmiana = 1;
        while(zmiana > 0){
            zmiana = 0;
            for(int i=0; i<tab.length-1; i++){
                if(tab[i]>tab[i+1]){
                    temp = tab[i+1];
                    tab[i+1] = tab[i];
                    tab[i] = temp;
                    zmiana++;
                }
            }
        }
        gui.getTextArea().setText(gui.getTextArea().getText() + 
                "\n>>>>> Sortowanie zostało wykonane.");
        return tab;
    }
    
    public int[] sortuj_malejaco(String a) throws RemoteException {
        gui.getTextArea().setText(gui.getTextArea().getText() + 
                "\n>>>>> Sortowanie zostało wywołane.");
        String[] str = a.split(",");
        int[] tab = new int[str.length];
        for(int i=0;i<str.length;i++){
            tab[i] = Integer.parseInt(str[i]);
        }
        
        int temp;
        int zmiana = 1;
        while(zmiana > 0){
            zmiana = 0;
            for(int i=0; i<tab.length-1; i++){
                if(tab[i]<tab[i+1]){
                    temp = tab[i+1];
                    tab[i+1] = tab[i];
                    tab[i] = temp;
                    zmiana++;
                }
            }
        }
        gui.getTextArea().setText(gui.getTextArea().getText() + 
                "\n>>>>> Sortowanie zostało wykonane.");
        return tab;
    }

}
