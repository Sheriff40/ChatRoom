/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yamakuzi
 */
public class ClientHandler {
    List<Client> clients = new ArrayList<>();
    
    public void add(Client client)
    {
        clients.add(client);
    }
    
    public void remove(Client client)
    {
        clients.remove(client);
    }
    
    public Client getByName(String Name)
    {
        for(Client c:clients)
        {
            if(c.getUsername().equalsIgnoreCase(Name))
            {
                return c;
            }
        }
        return null;
    }
    
    public Client getBySocket(Socket socket)
    {
        for(Client c:clients)
        {
            if(c.getSocket().equals(socket))
            {
                return c;
            }
        }
        return null;
    }
    
    public List<Client> getAll()
    {
        return clients;
    }
    
          
}
