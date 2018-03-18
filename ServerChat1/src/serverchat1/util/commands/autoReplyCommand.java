/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.commands;

import java.io.IOException;

/**
 *
 * @author Yamakuzi
 */
public class autoReplyCommand extends CommandInter {

    @Override
    public void execute(String[] Tokens) throws IOException {
        if (Tokens.length > 1) {
                        client.setAutoreply(Tokens[1]);
                    }
}
}