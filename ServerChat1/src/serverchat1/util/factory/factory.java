/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat1.util.factory;

import java.util.HashMap;

import serverchat1.util.commands.CommandInter;
import serverchat1.util.commands.autoReplyCommand;
import serverchat1.util.commands.blockCommand;
import serverchat1.util.commands.exitCommand;
import serverchat1.util.commands.listCommand;
import serverchat1.util.commands.pmCommand;
import serverchat1.util.commands.unblockCommand;

/**
 *
 * @author Yamakuzi
 */
public class factory {
    public static HashMap<String,CommandInter> commands;
    
    public static void initHash()
    {
        commands = new HashMap<>();
        commands.put("PM",new pmCommand());
        commands.put("BLOCK",new blockCommand());
        commands.put("UNBLOCK",new unblockCommand());
        commands.put("LIST",new listCommand());
        commands.put("EXIT",new exitCommand());
        commands.put("AUTOREPLY",new autoReplyCommand());
        
    }
    
    public static CommandInter run(String key)
    {
        initHash();
        String key1 = key.toUpperCase();
        if(commands.containsKey(key1))
        {
            return commands.get(key1);
        }
    return null;
    }
    
}
