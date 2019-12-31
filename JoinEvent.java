package com.evogames.proxy.listeners;

import com.evogames.proxy.objects.BungeeConnection;
import com.evogames.proxy.utils.DiscordWebhook;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.PreLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.IOException;
import java.util.List;

public class JoinEvent implements Listener {
    @EventHandler
    public void joiin(PostLoginEvent e){
        updateforPlayer(e.getPlayer());

    }



    @EventHandler
    public void pre(PreLoginEvent e) throws IOException {
        String name = e.getConnection().getName();
        String ver = String.valueOf(e.getConnection().getVersion());
        String toSend = "[" + ver + "] " + name + " --> ";
        String ok = "Pseudo Correct --> Connexion";
        String no = "Pseudo Incorrect --> Kick";
        if(name.matches("^\\w{3,16}$")) {
            DiscordWebhook.send("https://discordapp.com/api/webhooks/661352654416642068/M0m0WSiPB7SnguRSKfQ_wIKo9DUPIkPbBI3YCYI93UzasE89Coh5KU4S0lTWFzpbFNOu", toSend + ok);
        } else {
            DiscordWebhook.send("https://discordapp.com/api/webhooks/661352654416642068/M0m0WSiPB7SnguRSKfQ_wIKo9DUPIkPbBI3YCYI93UzasE89Coh5KU4S0lTWFzpbFNOu", toSend + no);
            e.setCancelReason(new TextComponent("§cVotre pseudonyme n'est pas valide !"));
            e.setCancelled(true);
        }
    }
    public static void updateforPlayer(ProxiedPlayer proxiedPlayer){
        proxiedPlayer.setTabHeader(new TextComponent("§bBienvenue sur §c§lLife§f§lCraft §b! Amusez-vous bien !\n§b"), new TextComponent("\n§bRejoignez notre §3Discord §b-> §cdiscord.gg/KXcRerj"));

    }



}
