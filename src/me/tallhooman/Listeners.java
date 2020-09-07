package me.tallhooman;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class Listeners implements Listener {
	Main plugin;
	Items items;

	public Listeners(Main main, Items items) {
		this.plugin = main;
		this.items = items;
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void creatureSpawn(CreatureSpawnEvent event) {
		int tier = plugin.getConfig().getInt("ExtraDifficulty");
		if (tier < 0) {
			plugin.getLogger().warning(tier + " is be less than 0");
			return;
		} else if (tier > items.TIER_AMOUNT) {
			plugin.getLogger().warning(tier + " is greater than " + items.TIER_AMOUNT);
			return;
		} else if (tier == 0) {
			return;
		}
		items.gitGud(event.getEntity(), tier - 1);

	}
}