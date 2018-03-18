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
import java.net.Socket;
import serverchat1.util.BroadCastMessage;
import serverchat1.util.commands.CommandInter;
import serverchat1.util.factory.factory;

/**
 *
 * @author Yamakuzi
 */
public class RequestListener extends Thread {

    private Socket socket;
    private PrintStream out;
    private BufferedReader reader;
    private ClientHandler handler;
    private Client client;

    RequestListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        out = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            login();

            while (true) {
                out.println("(me)> ");
                String line = reader.readLine();
                String[] Tokens = line.split(";;");
                CommandInter cmd = factory.run(Tokens[0]);
                if(cmd!=null)
                {
                    cmd.setClient(client);
                    cmd.setHandler(handler);
                    cmd.setOut(out);
                    cmd.setReader(reader);
                    cmd.execute(Tokens);
                }
               
                else {
                    String msg = client.getUsername() + " says > " + line;
                    BroadCastMessage.broadCastMessage(msg, client, handler.getAll());
                }

            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public void login() {
        try {
            out.println("Welcome to the Server");
            out.println("To send private message, use the command: pm;;user_name;;'message'");
            out.println("To block any user, use the command: block;;'user_name'");
            out.println("To unblock any user, use the command: unblock;;'user_name'");
            out.println("To set auto-reply,use the command: autoreply;;'message'");
            out.println("To see the list of online users, use the command: list");
            out.println("To exit the chat server, use the command: exit");
            out.println("<----------Enjoy---------->");
            out.println("Give your Name");
            String line = reader.readLine();
            out.println("Dear " + line + " Welcome to the server");
            client = new Client(line, socket);
            handler.add(client);
            String msg = client.getUsername() + " has joined the chat room ";
            BroadCastMessage.broadCastMessage(msg, client, handler.getAll());
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

}
