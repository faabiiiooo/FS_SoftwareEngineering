package lesson13_portProbe.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import lesson13_portProbe.PortProbe;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Scan extends Thread {

    private int startPort, endPort;
    private PortProbe_Model model;
    private final int ID;

    public boolean finished = false;

    private final ObservableList<CoPort> tempPorts = FXCollections.observableArrayList();

    public Scan(int id, PortProbe_Model model, int startPort, int endPort){
        this.model = model;
        this.startPort = startPort;
        this.endPort = endPort;
        this.ID = id;
        this.setDaemon(true);
    }

    public void run() {

       synchronized (model.getPorts()) {
            while (startPort < endPort) {
                try (Socket s = new Socket()) {

                    s.connect(new InetSocketAddress("127.0.0.1", startPort),2);

                    model.getPorts().add(new CoPort(startPort,"open"));
                    System.out.println(finished);


                } catch (IOException e) {
                    System.out.println(ID+": StartPort: "+startPort);
                    //System.out.println(ID+": EndPort: "+endPort);
                    model.getPorts().add(new CoPort(startPort,"closed"));
                } finally {
                    startPort++;
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e){

                    }
                }
            }
            finished = true;
           model.setFinished(this.ID, finished);

       }
    }

    public ObservableList<CoPort> getTempPorts(){return this.tempPorts; }
}
