package com.kokazia.security.listeners;

import com.kokazia.api.main.API;
import com.kokazia.api.utils.Data;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SecJoinEvent implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent e){
        API.getInstance().reloadConfig();
        e.setJoinMessage("");
        Player player = e.getPlayer();
        Bukkit.getOnlinePlayers().forEach(o -> o.hidePlayer(player));
        if(API.getInstance().getConfig().getBoolean("wl")){
            if(API.getInstance().getConfig().getStringList("wllist").contains(player.getName())){ } else {
                player.kickPlayer("§c§lLife§f§lCraft§c est actuellement en maintenance !\n\n§cSeul quelques personnes autorisées peuvent s'y connecter\n\n§cPour en savoir plus rejoignez notre §bDiscord §3-> §bdiscord.gg/qQRyaqe");
                return;
            }
        }
        e.getPlayer().teleport(e.getPlayer().getWorld().getSpawnLocation());
        e.getPlayer().setGameMode(GameMode.ADVENTURE);
        for(int i = 0; i < 100; i++) player.sendMessage("");
        player.sendMessage(
                ""
                + "§8>> §eBienvenue sur §c§lLife§f§lCraft §e" + e.getPlayer().getName()
                + "\n§8>> §eUn problème avec votre compte ? Venez sur notre Discord !"
                + "\n§8>> §eSite §6• §7lifecraft.fr"
                + "\n§8>> §eBoutique §6• §7lifecraft.fr/shop"
        );
        if(Data.isAuthStored(player.getUniqueId())){
            player.sendMessage(
                    ""
                    + "\n\n"
                    + "§8>> §eCe compte est déjà inscrit !"
                    + "\n§bConnectez-vous ! (§e/login motdepasse§b) pour jouer !"
            );
        } else {
            player.sendMessage(
                    ""
                            + "\n\n"
                            + "§8>> §eCe compte n'est pas inscrit !"
                            + "\n§bInscrivez-vous ! (§e/register motdepasse motdepasse§b) pour jouer !"
            );
        }
    }
}
