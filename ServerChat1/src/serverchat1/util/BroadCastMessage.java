/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util;

import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import serverchat1.Client;

/**
 *
 * @author Yamakuzi
 */
public class BroadCastMessage {

    public static void broadCastMessage(String msg,Client client, List<Client> clients) throws IOException {
        for (Client c:clients) {
            if (!c.equals(client)) {
                PrintStream pbs = new PrintStream(c.getSocket().getOutputStream());
                pbs.println(msg);
            
                }
       }
    }
    
    public static void broadCastMessage(String msg,Client client, Client buddy) throws IOException {
        
            if (buddy!=null) {
                PrintStream pbs = new PrintStream(buddy.getSocket().getOutputStream());
                pbs.println(msg);
                }
       }
    
}