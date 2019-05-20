package lesson13_client_1;

import lesson13_server_1.Server_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client_1 {

    public static void main(String[] args){
        Server_1 server = new Server_1();
        server.start();
        connect();
    }


    private static  void connect(){

        try(Socket s = new Socket("127.0.0.1",8080);
            BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter writer = new PrintWriter(s.getOutputStream())){

            //System.out.println("test");

            writer.write("GET HTTP/1.0\r\n");
            writer.write("User-Agent: BroswerF\r\n");
            writer.write("Host: 127.0.0.1 : 8080\r\n");
            writer.write("Accept: text/html, */*\r\n\r\n");
            writer.flush();

            String lineIn = "";

            while(reader.readLine()!= null){
                lineIn += reader.readLine();
            }

            System.out.println(lineIn);



        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
