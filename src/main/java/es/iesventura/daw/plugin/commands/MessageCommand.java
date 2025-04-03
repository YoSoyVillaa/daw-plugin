package es.iesventura.daw.plugin.commands;

import es.iesventura.daw.plugin.DawPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MessageCommand extends Command {

    private final DawPlugin dawPlugin;

    public MessageCommand(DawPlugin dawPlugin) {
        super("mensaje");
        this.dawPlugin = dawPlugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, @NotNull String @NotNull [] args) {
        // El comando solo lo pueden ejecutar jugadores
        if (!(sender instanceof Player)) {
            sender.sendPlainMessage("Este comando solo lo pueden ejecutar jugadores");
            return false;
        }

        Player player = (Player) sender;

        // Comprobamos si el jugador tiene permisos para ejecutar el comando
        if (!player.hasPermission("daw.plugin.message")) {
            player.sendPlainMessage("No tienes permisos!");
            return false;
        }

        // Comprobamos si el jugador ha introducido los argumentos necesarios
        if (args.length < 2) {
            player.sendPlainMessage("Uso correcto: /mensaje <player> <message>");
            return false;
        }

        String playerName = args[0];
        Player target = dawPlugin.getServer().getPlayerExact(playerName);

        // Comprobamos si el jugador existe
        if (target == null) {
            player.sendPlainMessage("El player no existe");
            return false;
        }

        // Comprobamos si el jugador es el mismo que el que ha ejecutado el comando
        if (target.getUniqueId().equals(player.getUniqueId())) {
            player.sendPlainMessage("No puedes enviarte un mensaje a ti mismo");
            return false;
        }

        // Creamos el mensaje
        String message = String.join(" ", args).substring(playerName.length() + 1);
        player.sendPlainMessage("Mensaje enviado a " + target.getName());
        target.sendPlainMessage("Mensaje de " + player.getName() + ": " + message);

        return true;
    }
}
