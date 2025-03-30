package es.iesventura.daw.plugin;

import es.iesventura.daw.plugin.listeners.PlayerJoinListener;
import es.iesventura.daw.plugin.listeners.WeatherChangeListener;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class DawPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        getServer().getPluginManager().registerEvents(new WeatherChangeListener(), this);
    }

    @Override
    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
            player.sendPlainMessage("Adiós!");
        }
    }
}
