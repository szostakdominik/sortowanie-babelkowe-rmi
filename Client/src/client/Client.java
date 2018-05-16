package client;

import gui.GUI;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import rmi.Sortowanie;

public class Client {

    private GUI gui;
    private Sortowanie stub;
    
    public Client(GUI g) {
        gui = g;
    }
    
    public Sortowanie getStub() {
        return stub;
    }
    
    public void connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry();
            Sortowanie stub = (Sortowanie) reg.lookup("Sortowanie");
            this.stub = stub;
        } catch(Exception e) {
            gui.getResultText().setDisabledTextColor(Color.red);
            gui.getResultText().setText("Brak połączenia z serwerem.");
        }
    }
    
}
