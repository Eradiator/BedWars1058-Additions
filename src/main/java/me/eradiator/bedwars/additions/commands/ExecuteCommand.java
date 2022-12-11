package me.eradiator.bedwars.additions.commands;

import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import me.eradiator.bedwars.additions.utils.enums.path.MessagePath;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ExecuteCommand extends BukkitCommand {

    public ExecuteCommand(String name) {
        super(name);
        this.description = "Make Players Execute Commands Using This Command";
        this.setPermission(MainPath.EXECUTE_CMD_PERMISSION.getString());
        this.setUsage(MessagePath.EXECUTE_CMD_USAGE.getString());
        this.setAliases(MainPath.EXECUTE_CMD_ALIASES.getStringList());
    }

    @Override
    public boolean execute( CommandSender sender,  String commandLabel,  String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission(Objects.requireNonNull(this.getPermission()))) {
                if (args.length < 1) {
                    sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_USAGE.getString()));
                }
                else if (args.length > 1) {
                    StringBuilder s = new StringBuilder();
                    for (int i = 1; i< args.length ; i++) {
                        s.append(args[i]);
                        s.append(" ");
                    }
                    Player target = Bukkit.getPlayer(args[0]);
                    String cmd = s.toString();
                    cmd = cmd.stripTrailing();
                    if (target == null){
                        if (args[0].equalsIgnoreCase("**")||args[0].equalsIgnoreCase("*")) {
                            List<Player> players = ((Player) sender).getWorld().getPlayers();
                            if (args[0].equalsIgnoreCase("*")) {
                                for (int i = 0; i< players.size();i++) {
                                    if (players.contains(((Player) sender))) {
                                        players.remove(((Player)sender));
                                    }
                                    players.get(i).performCommand(cmd);
                                }
                            }
                            else {
                                for (int i = 0; i< players.size();i++) {
                                    players.get(i).performCommand(cmd);
                                }
                            }
                        }
                        else {
                            sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_PLAYER_NOT_FOUND.getString()));
                        }
                    }
                    else {
                        target.performCommand(cmd);
                    }
                }
                else {
                    sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_USAGE.getString()));
                }
            }
            else {
                sender.sendMessage(Main.getMsgUtil().CC(MessagePath.COMMAND_NO_PERMISSION.getString()));
            }
        }
        else {
            if (args.length < 1) {
                sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_USAGE.getString()));
            }
            else if (args.length > 1) {
                StringBuilder s = new StringBuilder();
                for (int i = 1; i< args.length ; i++) {
                    s.append(args[i]);
                    s.append(" ");
                }
                Player target = Bukkit.getPlayer(args[0]);
                String cmd = s.toString();
                cmd = cmd.stripTrailing();
                if (target == null){
                    sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_PLAYER_NOT_FOUND.getString()));
                }
                else {
                    target.performCommand(cmd);
                }
            }
            else {
                sender.sendMessage(Main.getMsgUtil().CC(MessagePath.EXECUTE_CMD_USAGE.getString()));
            }
        }
        return true;
    }


    @Override
    public List<String> tabComplete( CommandSender sender,  String alias,  String[] args) throws IllegalArgumentException {
        List<String> players = new ArrayList<>();
        players.add("**");
        players.add("*");
        if (args.length == 1) {
            Player[] player = new Player[((Player) sender).getWorld().getPlayers().size()];
            ((Player) sender).getWorld().getPlayers().toArray(player);
            for (int i =0; i<player.length;i++) {
                players.add(player[i].getName());
            }
            return players;
        }
        else {
            return players;
        }
    }
}
