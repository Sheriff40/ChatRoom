/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.commands;

import java.io.IOException;
import java.io.PrintStream;
import serverchat1.Client;

/**
 *
 * @author Yamakuzi
 */
public class exitCommand extends CommandInter{

    @Override
    public void execute(String[] Tokens) throws IOException {
        handler.remove(client);
                    client.getSocket().close();
                    String msg = client.getUsername() + " has logged out";
                    for(Client c:handler.getAll())
                    {
                        if((!client.hasBlocked(c)))
                        {
                            PrintStream exitMsg = new PrintStream(c.getSocket().getOutputStream());
                            exitMsg.println(msg);
                        }
                    }
    
}
}
