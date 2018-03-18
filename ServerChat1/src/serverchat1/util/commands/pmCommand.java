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
public class pmCommand extends CommandInter {

    @Override
    public void execute(String Tokens[]) throws IOException {
        if (Tokens.length > 2) {
            Client buddy = handler.getByName(Tokens[1]);
            if (buddy != null) {
                if (!client.hasBlocked(buddy)) {
                    if (!buddy.hasBlocked(client)) {
                        PrintStream by = new PrintStream(buddy.getSocket().getOutputStream());
                        String msg = client.getUsername() + " personally says " + Tokens[2];
                        by.println(msg);
                        if (buddy.getAutoreply().length() > 0) {
                            out.println(buddy.getUsername() + " says " + buddy.getAutoreply());
                        }
                    } else {
                        out.println(buddy.getUsername() + " not found");
                    }

                } else {
                    out.println("You have blocked this person");
                }

            } else {
                out.println(buddy.getUsername() + " does not exist");
            }

        }
    }

}
