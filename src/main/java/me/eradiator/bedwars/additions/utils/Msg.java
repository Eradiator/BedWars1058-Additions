package me.eradiator.bedwars.additions.utils;

import com.andrei1058.bedwars.api.language.Messages;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MessagePath;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg {
    public  String CC(String message){
        return ChatColor.translateAlternateColorCodes('&' , message);
    }
    public  void player(Player player , String message){
        player.sendMessage(CC(prefix(message)));
    }
    public  void console(String message){
        Bukkit.getConsoleSender().sendMessage(CC(prefix(message)));
    }
    public  void sender(CommandSender sender , String message){
        sender.sendMessage(CC(prefix(message)));
    }
    public  String prefix(String message){
        return MessagePath.PREFIX.getString()+message;
    }
}
