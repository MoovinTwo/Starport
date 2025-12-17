package com.moovintwo.starport;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import static com.moovintwo.starport.UUIDs.*;


public class MessageListener implements Listener {


    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerMessage(AsyncChatEvent event) {

        event.renderer((player, playerName, message, viewer) -> {

            Component rank;
            if (player.getUniqueId().toString().equals(Moovintwo_UUID)) {
                rank = Component.text("[ Owner ] ", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(Alex_UUID)) {
                rank = Component.text("[ Co-Owner ] ", NamedTextColor.DARK_RED, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(ThreadedFlowey)) {
                rank = Component.text("[ Developer ] ", NamedTextColor.DARK_RED, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(Deplo_UUID)) {
                rank = Component.text("[ Admin ] ", NamedTextColor.GREEN, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(Karma_UUID)) {
                rank = Component.text("[ Moderator ] ", NamedTextColor.AQUA, TextDecoration.BOLD);
            } else {
                rank = Component.text("[ Member ] ", NamedTextColor.BLUE, TextDecoration.BOLD);
            }

            Component playerHead = MiniMessage.miniMessage().deserialize("<head:" + player.getName() + "> ");
            Component nameComp = Component.text(player.getName());
            Component separator = Component.text(" | ", NamedTextColor.GRAY);

            return Component.textOfChildren(rank, playerHead, nameComp, separator, message);
        });

    }

}
