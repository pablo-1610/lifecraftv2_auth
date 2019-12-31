package com.kokazia.security.commands;

import com.kokazia.api.main.API;
import com.kokazia.api.utils.Data;
import com.kokazia.api.utils.Proxy;
import com.kokazia.security.objects.SecurityPassword;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SecLogin extends Command {


    public SecLogin() {
        super("login");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(!Data.isAuthStored(player.getUniqueId())){
            player.sendMessage("§cVous n'êtes pas inscrit ! Utilisez /register motdepasse motdepasse");
            return false;
        }
        if(args.length == 0 || args.length > 1){
            player.sendMessage("§cUsage : /login motdepasse");
            return false;
        }
        SecurityPassword securityPassword = Data.getSecurityPassword(player.getUniqueId());
        String password = securityPassword.getMdp();
        if(args[0].equalsIgnoreCase(password)){
            player.sendMessage("§aMot de passe correct, connexion...");
            Proxy.connectPlayer(player, "Lobby_01", API.getInstance());
            return true;
        } else {
            player.kickPlayer("§cMot de passe incorrect !\n\n§cSi vous l'avez perdu, contactez un staff sur Discord\n\n§bDiscord: §b");
            return false;
        }
    }
}
