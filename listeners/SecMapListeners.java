package com.kokazia.security.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class SecMapListeners implements Listener {
    @EventHandler
    public void build(BlockPlaceEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void b(BlockBreakEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void hunger(FoodLevelChangeEvent e){
        e.setFoodLevel(20);
    }

    @EventHandler
    public void chat(AsyncPlayerChatEvent e){
        e.getPlayer().sendMessage("§cVous ne pouvez pas parler ici !");
        e.setCancelled(true);
    }

    @EventHandler
    public void changr(WeatherChangeEvent e){
        e.setCancelled(true);
    }
}
