package lesson13_portProbe.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lesson13_portProbe.PortProbe;

import java.util.ArrayList;

public class PortProbe_Model {

    private final ObservableList<CoPort> ports = FXCollections.observableArrayList();
    private final ArrayList<Boolean> finishedList = new ArrayList<>();




    public void scanPorts(){

        ArrayList<Scan> scanners = new ArrayList<>();
        int startPort = 1, endPort = 0;
        Scan s;
       for(int i = 0; i < 1000; i++){
           finishedList.add(false);

           if(i == 0) {
              // endPort = (PortProbe.MAX_PORTNUM / 10) + 5;
               endPort=535;
               s = new Scan(i,this,startPort,endPort);
               scanners.add(s);
               s.start();
           } else {
               startPort = endPort;
               endPort = startPort + (PortProbe.MAX_PORTNUM / 1000);
               s = new Scan(i,this, startPort, endPort);
               scanners.add(s);
               s.start();
           }

       }
       boolean allFinished = false;
       int countFinished = 0;
        /*
       while (!allFinished){
           for(Scan sc : scanners){
               if(sc.finished == true){
                   countFinished++;
               }
           }
           if(countFinished == 999){
               allFinished = true;
           }
       }*/
       for(Scan sc : scanners){
          try {
              sc.join();
              this.collectLists(scanners);
          } catch (InterruptedException e){

          }
       }



    }

    public void setFinished(int id, boolean finished){
        synchronized (this.finishedList){
            this.finishedList.set(id,finished);
        }
    }

    private void collectLists(ArrayList<Scan> scanners){
        for(int i = 0; i < 999; i++){
            synchronized (ports) {
                ports.addAll(scanners.get(i).getTempPorts());
            }
        }
        /*for(CoPort p : ports){
            System.out.println(p);
        }*/
    }

    public ObservableList<CoPort> getPorts(){ return this.ports; }
}
