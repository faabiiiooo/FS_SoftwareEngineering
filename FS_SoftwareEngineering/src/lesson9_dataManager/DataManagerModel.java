package lesson9_dataManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;

import java.io.*;
import java.nio.file.Files;
import java.rmi.server.ExportException;
import java.util.ArrayList;
import java.util.Observable;

public class DataManagerModel {

   private final ObservableList<Data> dataStore = FXCollections.observableArrayList();

   public DataManagerModel(){

       File listToImport = new File(
               "C:/Users/fabio/IdeaProjects/FS_SoftwareEngineering/FS_SoftwareEngineering/src/lesson9_dataManager/save/savedList.txt");

       try(BufferedReader reader = new BufferedReader(new FileReader(listToImport))) {

           String line;
           String[] dataAttributes = new String[5];
           while ((line = reader.readLine()) != null) {
               dataAttributes = line.split(";");
               this.dataStore.add(new Data(dataAttributes[0],
                       dataAttributes[1],
                       dataAttributes[2],
                       Double.parseDouble(dataAttributes[3]),
                       Integer.parseInt(dataAttributes[4])));

           }
       } catch (Exception e){

       }


   }


   public void addItem(){
       dataStore.add(new Data());
       System.out.println(dataStore.size());

   }

   public ObservableList<Data> getItems(){
       return this.dataStore;
   }

   public void saveToFile(Event event){

       File savedList = new File(
               "C:/Users/fabio/IdeaProjects/FS_SoftwareEngineering/FS_SoftwareEngineering/src/lesson9_dataManager/save/savedList.txt");

      try(BufferedWriter writer = new BufferedWriter(new FileWriter(savedList))){

         writer.write(dataToString());

         writer.close();
      } catch (Exception e){
            e.printStackTrace();
      }

   }

   private String dataToString(){
       String dataAsString="";
       for(Data d : dataStore){
           dataAsString += d.toString();
       }

       return  dataAsString;
   }


}
