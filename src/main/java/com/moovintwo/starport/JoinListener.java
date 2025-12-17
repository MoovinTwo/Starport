package com.moovintwo.starport;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

import static com.moovintwo.starport.UUIDs.*;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        Component rank;
        if (player.getUniqueId().toString().equals(Moovintwo_UUID)) {
            rank = Component.text("[ Owner ] ", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD);
        } else if (player.getUniqueId().toString().equals(Alex_UUID)) {
            rank = Component.text("[ Co-Owner ] ", NamedTextColor.DARK_RED, TextDecoration.BOLD);
        } else if (player.getUniqueId().toString().equals(ThreadedFlowey)) {
            rank = Component.text("[ Developer ] ", NamedTextColor.LIGHT_PURPLE, TextDecoration.BOLD);
        } else if (player.getUniqueId().toString().equals(Deplo_UUID)) {
            rank = Component.text("[ Admin ] ", NamedTextColor.GREEN, TextDecoration.BOLD);
        } else if (player.getUniqueId().toString().equals(Karma_UUID)) {
            rank = Component.text("[ Moderator ] ", NamedTextColor.AQUA, TextDecoration.BOLD);
        } else {
            rank = Component.text("[ Member ] ", NamedTextColor.BLUE, TextDecoration.BOLD);
        }

        Component playerHead = MiniMessage.miniMessage().deserialize("<head:" + event.getPlayer().getName() + "> ");
        Component playerName = Component.text(player.getName());

        Random random = new Random();
        Component joinMessage;
        int randomInt = random.nextInt(1,3);
        if (randomInt == 1) {
            joinMessage = Component.text(" has joined the server");
        } else if (randomInt == 2) {
            joinMessage = Component.text(" has slid into the party");
        } else {
            joinMessage = Component.text(" is in the server now");
        }

        event.joinMessage(Component.textOfChildren(rank, playerHead, playerName, joinMessage));
    }
}

