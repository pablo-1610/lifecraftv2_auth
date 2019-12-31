package com.kokazia.security.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class SecQuitEvent implements Listener {
    @EventHandler
    public void quit(PlayerQuitEvent e){
        e.setQuitMessage("");
    }
}
