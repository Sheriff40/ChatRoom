/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Yamakuzi
 */
public class ServerChat1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try
        {
          int port = 9000;
          ServerSocket server = new ServerSocket(port);
            System.out.println("Connected to port: " + port);
            ClientHandler handler = new ClientHandler();
            while(true)
            {
                Socket socket = server.accept();
                RequestListener listener = new RequestListener(socket,handler);
                listener.start();
            }
            
            
        }
        catch(IOException ioe)
        {
            System.out.println(ioe.getMessage());
            
        }
        
        
    }
    
}
