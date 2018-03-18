/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.commands;

import java.io.IOException;
import serverchat1.Client;
import serverchat1.util.BroadCastMessage;

/**
 *
 * @author Yamakuzi
 */
public class unblockCommand extends CommandInter{

    @Override
    public void execute(String[] Tokens) throws IOException {
        if (Tokens.length > 1) {
                        Client buddy = handler.getByName(Tokens[1]);
                        if (buddy != null) {
                            if ((client.hasBlocked(buddy))) {
                                client.unblock(buddy);
                                String msg = client.getUsername() + " has unblock you ";
                                BroadCastMessage.broadCastMessage(msg, client, buddy);
                            } else {
                                out.println("The person is not blocked");
                            }

                        } else {
                            out.println("Buddy not Found");
                        }
        }
    
}
}
