package dexbot;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

/**
 * 
 * @author Ben
 */
public class MessageListener extends ListenerAdapter{
    
    /**
     * The method that listens for bot commands.
     * @param event an event containing information about a Message sent in a channel
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        JDA jda = event.getJDA();
        User author = event.getAuthor();
        MessageChannel channel = event.getChannel();
        String msg = event.getMessage().getContentRaw();
        
        if(msg.startsWith("!")) {
            if(author.isBot()) {
                return;
            }
            if(msg.equalsIgnoreCase("!ping")) {
                channel.sendMessage("Pong!").queue();
            }
            if(msg.equalsIgnoreCase("!help")) {
                Response.gitHelp();
            }
        }
    }
    
}
