package me.tryingtobehooman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class Commands implements CommandExecutor, TabCompleter {
	Main plugin;
	Items items;

	public Commands(Main main, Items items) {
		this.plugin = main;
		plugin.getCommand("extradifficulty").setExecutor(this);
		this.items = items;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "This command requires arguments!");
			return true;
		}
		final int n;
		try {
			n = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			sender.sendMessage(ChatColor.DARK_GREEN + "The extra difficulty is at " + ChatColor.GOLD + ChatColor.BOLD
					+ plugin.getConfig().getInt("ExtraDifficulty"));
			return true;
		}
		if (n < 0) {
			sender.sendMessage(n + " cannot be less than 0");
			return true;
		} else if (n > items.TIER_AMOUNT) {
			sender.sendMessage(n + " cannot be greater than " + items.TIER_AMOUNT);
			return true;
		}
		plugin.getConfig().set("ExtraDifficulty", n);
		plugin.saveConfig();
		sender.sendMessage(ChatColor.DARK_GREEN + "The extra difficulty has been changed to " + ChatColor.GOLD + ChatColor.BOLD + args[0]);
		Bukkit.getWorlds().forEach(world -> {
			world.getEntities().forEach(entity -> {
				if (entity instanceof LivingEntity) {
					if(entity instanceof Player) {
						return;
					}
					items.getGear((LivingEntity) entity, n - 1);
				}
			});
		});
		return false;
	}

	final List<String> SUGGESTIONS = new ArrayList<String>(Arrays.asList("GET", "0", "1", "2", "3"));

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		List<String> list = new ArrayList<String>();
		if (args.length != 0) {
			StringUtil.copyPartialMatches(args[0], SUGGESTIONS, list);
		}
		return list;
	}
}
