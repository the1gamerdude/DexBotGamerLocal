/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dexbot;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.*;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
/**
 *
 * @author Ben
 */
public class DexBot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            JDA jda = new JDABuilder(AccountType.BOT).setToken("NDEwNjM1NDk0OTAxMjg0ODY0.DVwBuQ.loM2d2gXHzZlClx5XNM_tXlBgmU").addEventListener(new MessageListener()).buildBlocking();
        }catch(Exception e) {
            System.out.println("Login failed. Here is the stack trace:");
            e.printStackTrace();
        }
    }
    
}
