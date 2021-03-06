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
public class blockCommand extends CommandInter {

    @Override
    public void execute(String[] Tokens) throws IOException {
        if (Tokens.length > 1) {
                        Client buddy = handler.getByName(Tokens[1]);
                        if (buddy != null) {
                            if (!client.hasBlocked(buddy)) {
                                client.block(buddy);
                            } else {
                                out.println("The person is already blocked");
                            }

                        } else {
                            out.println("Buddy not Found");
                        }
                }
    
    }
}
