/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import serverchat1.Client;
import serverchat1.ClientHandler;

/**
 *
 * @author Yamakuzi
 */
public abstract class CommandInter  {
    
    protected Socket socket;
    protected PrintStream out;
    protected BufferedReader reader;
    protected ClientHandler handler;
    protected Client client;
    
    public abstract void execute (String Tokens[]) throws IOException;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }

    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    public void setHandler(ClientHandler handler) {
        this.handler = handler;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    

}
