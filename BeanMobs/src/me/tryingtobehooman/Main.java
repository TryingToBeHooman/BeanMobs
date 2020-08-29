package me.tryingtobehooman;

import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import me.tryingtobehooman.listeners.Listeners;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	private static Main instance;
	
	public static Main getInstance() {
		return Main.instance;
	}
	
	public void onEnable() {
		Main.instance = this;
		this.getServer().getPluginManager().registerEvents((Listener)new Listeners(), (Plugin)this);
	}
	
	public void onDisable() {
		Main.instance = null;
	}
}
