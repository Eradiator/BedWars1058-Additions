package me.eradiator.bedwars.additions.commands;

import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.commands.subcommands.reload;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

import java.util.ArrayList;
import java.util.List;

public class MainCommand extends BukkitCommand {
    ArrayList<SubCommands> subCmd = new ArrayList<>();

    public MainCommand( String name) {
        super(name);
        this.setPermission("bwa.main");
        subCmd.add(new reload());
    }

    @Override
    public boolean execute( CommandSender sender,  String commandLabel,  String[] args) {
        if (args.length < 1) {
            sender.sendMessage(Main.getMsgUtil().CC("&cInvalid arguments."));
            return false;
        }
        else{
            for (int i = 0; i< subCmd.size(); i++) {
                if (args[0].equalsIgnoreCase(subCmd.get(i).getName())) {
                    subCmd.get(i).perform(sender , args);
                }
                else {
                    sender.sendMessage(Main.getMsgUtil().CC("&cCommand not Found."));
                }
            }
            return true;
        }
    }


    @Override
    public List<String> tabComplete( CommandSender sender,  String alias,  String[] args) throws IllegalArgumentException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<subCmd.size();i++) {
            list.add(subCmd.get(i).getName().toLowerCase());
        }
        return list;
    }

}
