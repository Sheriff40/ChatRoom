/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.commands;

import java.io.IOException;
import serverchat1.Client;

/**
 *
 * @author Yamakuzi
 */
public class listCommand extends CommandInter {

    @Override
    public void execute(String Tokens[]) throws IOException {
        for (Client c : handler.getAll()) {
            if ((!c.hasBlocked(client)) && (!client.hasBlocked(c))) {
                out.println(c.getUsername() + "\r\n");
            }
        }

    }
}