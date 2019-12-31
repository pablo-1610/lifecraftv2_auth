package com.kokazia.security.listeners;

import com.kokazia.api.objects.Message;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class SecCmdExecution implements Listener {
    @EventHandler(priority = EventPriority.HIGH)
    public void cmd(PlayerCommandPreprocessEvent e){
        String msg = e.getMessage().replaceAll("/", "");
        if(msg.startsWith("login") || msg.startsWith("register")){
            return;
        } else {
            e.setCancelled(true);
            Message.COMMAND_DISABLE.sendContent(e.getPlayer());
            return;
        }
    }
}
