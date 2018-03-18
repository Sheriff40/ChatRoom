/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import serverchat1.util.BroadCastMessage;

/**
 *
 * @author Yamakuzi
 */
public class Client {
    private String Username;
    private Socket socket;
    private String autoreply ="";
    List<Client> blockList = new ArrayList<>();

    public Client(String Username, Socket socket) {
        this.Username = Username;
        this.socket = socket;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getAutoreply() {
        return autoreply;
    }

    public void setAutoreply(String autoreply) {
        this.autoreply = autoreply;
    }
    
    public void block(Client client)
    {
      
        blockList.add(client);
        
    }
    
    public void unblock(Client client)
    {
        blockList.remove(client);
    }
    
    public List<Client> getList()
    {
        return blockList;
    }
    
    public boolean hasBlocked(Client client)
    {
        return blockList.contains(client);
    }
}
