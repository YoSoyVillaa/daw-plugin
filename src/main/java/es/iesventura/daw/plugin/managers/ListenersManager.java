package es.iesventura.daw.plugin.managers;

import es.iesventura.daw.plugin.DawPlugin;
import org.bukkit.event.Listener;

public class ListenersManager {

    private final DawPlugin dawPlugin;

    public ListenersManager(DawPlugin dawPlugin) {
        this.dawPlugin = dawPlugin;
    }

    public void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            dawPlugin.getServer().getPluginManager().registerEvents(listener, dawPlugin);
        }
    }
}
