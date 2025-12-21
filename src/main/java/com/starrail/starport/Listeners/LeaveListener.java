package com.starrail.starport.Listeners;

import com.starrail.starport.Starport;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.Random;

public class LeaveListener implements Listener {

    private final Starport plugin;

    public LeaveListener(Starport plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerLeave(PlayerQuitEvent event) {

        Player player = event.getPlayer();
        Component rank = plugin.getRankManager().getRank(player.getUniqueId()).component();
        if (rank == null) rank = Component.empty();

        Component playerHead = MiniMessage.miniMessage().deserialize("<head:" + event.getPlayer().getName() + "> ");
        Component playerName = Component.text(player.getName());

        Random random = new Random();
        Component quitMessage;
        int randomInt = random.nextInt(1,5);
        if (randomInt == 1) {
            quitMessage = Component.text(" has left the server");
        } else if (randomInt == 2) {
            quitMessage = Component.text(" has left the party");
        } else if (randomInt == 3) {
            quitMessage = Component.text(" has gone to touch grass");
        } else if (randomInt == 4) {
            quitMessage = Component.text(" has been summoned to Valhalla");
        } else {
            quitMessage = Component.text(" fell asleep");
        }

        event.quitMessage(Component.textOfChildren(rank, playerHead, playerName, quitMessage));
    }




}
