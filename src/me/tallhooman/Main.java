package me.tallhooman;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public void onEnable() {
		this.saveDefaultConfig();
		Items items = new Items(this);
		new Listeners(this, items);
		new Commands(this, items);
	}
	
	public void onDisable() {
	}
}
