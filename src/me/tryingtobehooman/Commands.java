package me.tryingtobehooman;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;

public class Commands implements CommandExecutor {
	Main plugin;
	Items items;

	public Commands(Main main, Items items) {
		this.plugin = main;
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
			sender.sendMessage(ChatColor.RED + args[0] + " is not a number!");
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
		sender.sendMessage(ChatColor.DARK_GREEN + "The extra difficulty has been changed to " + args[0]);
		Bukkit.getWorlds().forEach(world -> {
			world.getEntities().forEach(entity -> {
				if (!entity.getScoreboardTags().contains("beanmobsgear")) {
					return;
				}
				if (entity instanceof LivingEntity) {
					items.getGear((LivingEntity) entity, n);
				}
			});
		});
		return false;
	}
}
