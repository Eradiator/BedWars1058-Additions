package me.eradiator.bedwars.additions.commands.subcommands;

import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.commands.SubCommands;
import me.eradiator.bedwars.additions.utils.enums.path.MessagePath;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload implements SubCommands {
    @Override
    public String getName() {
        return "reload";
    }

    @Override
    public String getDescription() {
        return "Reload Configuration Files";
    }

    @Override
    public String getPermission() {
        return "bwa.reload";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission(this.getPermission())){
                Main.getInstance().reloadConfig();
                sender.sendMessage("&aReloaded Config.");
            }
            else {
                sender.sendMessage(Main.getMsgUtil().CC(MessagePath.COMMAND_NO_PERMISSION.getString()));
            }
        }
        else {
            Main.getInstance().reloadConfig();
            sender.sendMessage("&aReloaded Config.");
        }
    }
}
