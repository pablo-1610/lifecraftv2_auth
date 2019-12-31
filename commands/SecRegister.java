package com.kokazia.security.commands;

import com.kokazia.api.main.API;
import com.kokazia.api.utils.Data;
import com.kokazia.api.utils.Proxy;
import com.kokazia.security.objects.SecurityPassword;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SecRegister extends Command {


    public SecRegister() {
        super("register");
    }

    @Override
    public boolean execute(CommandSender sender, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        Player player = (Player) sender;
        if(Data.isAuthStored(player.getUniqueId())){
            player.sendMessage("§cVous êtes déjà inscrit ! Utilisez /login motdepasse");
            return false;
        }
        if(args.length == 0 || args.length == 1 || args.length > 2){
            player.sendMessage("§cUsage : /register motdepasse motdepasse");
            return false;
        }
        if(args[0].equals(args[1])){
            player.sendMessage("§aCompte créé, connexion...");
            SecurityPassword securityPassword = new SecurityPassword(player.getUniqueId(), args[0]);
            Data.createSecurityPassword(securityPassword);
            Proxy.connectPlayer(player, "Lobby_01", API.getInstance());
            return true;
        } else {
            player.sendMessage("§cLes mots de passes ne correspondent pas !");
            return false;
        }
    }
}
