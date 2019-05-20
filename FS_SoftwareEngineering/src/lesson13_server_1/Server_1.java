package lesson13_server_1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_1 extends Thread {

    private final Integer port = 8080;


    public void run(){
        try(ServerSocket s = new ServerSocket(port,10,null)){
            System.out.println("Listening on Port "+port);

            while(true){
                try(Socket so = s.accept();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(so.getInputStream()));
                    PrintWriter writer = new PrintWriter(so.getOutputStream());) {

                    writer.print("HTTP/1.0 200\r\n");
                    writer.print("Content-Type: text/plain\r\n");
                    writer.print("\r\n");

                    String lineIn = "";
                    while((lineIn = reader.readLine()) != null && lineIn.length() != 0 ){
                        lineIn = reader.readLine();
                    }

                    String out = "Hello! this is your Server Response";
                    writer.print(out);
                    writer.flush();

                    System.out.println(lineIn);



                }catch (Exception e){

            }
            }
        } catch (Exception e){

        }

    }


}
