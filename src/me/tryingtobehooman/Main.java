package me.tryingtobehooman;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		this.saveDefaultConfig();
		Items items = new Items();
		this.getServer().getPluginManager().registerEvents(new Listeners(this, items), this);
	}
	
	public void onDisable() {
	}
}
