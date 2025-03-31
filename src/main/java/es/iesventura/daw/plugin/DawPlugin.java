package es.iesventura.daw.plugin;

import es.iesventura.daw.plugin.listeners.PlayerJoinListener;
import es.iesventura.daw.plugin.listeners.WeatherChangeListener;
import es.iesventura.daw.plugin.managers.ListenersManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class DawPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ListenersManager listenersManager = new ListenersManager(this);
        listenersManager.registerListeners(
                new PlayerJoinListener(),
                new WeatherChangeListener()
        );
    }

    @Override
    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
            player.sendPlainMessage("Adiós!");
        }
    }
}
