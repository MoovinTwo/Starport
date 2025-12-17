package com.moovintwo.starport;

import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.Objects;


public class MessageListener implements Listener {

    private static final String Deplo_UUID = "1ad8c3cc-7f2f-4595-8b7e-f1708103eafa";
    private static final String Karma_UUID = "e7f27e9a-16f1-46ac-b8dd-aa573379ed14";


    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerMessage(AsyncChatEvent event) {

        event.renderer((player, playerName, message, viewer) -> {

            Component rank;
            if (player.isOp()) {
                rank = Component.text("[ Owner ] ", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(Deplo_UUID)) {
                rank = Component.text("[ Admin ] ", NamedTextColor.GREEN, TextDecoration.BOLD);
            } else if (player.getUniqueId().toString().equals(Karma_UUID)) {
                rank = Component.text("[ Moderator ] ", NamedTextColor.AQUA, TextDecoration.BOLD);
            } else {
                rank = Component.text("[ Member ] ", NamedTextColor.BLUE, TextDecoration.BOLD);
            }

            Component nameComp = Component.text(player.getName(), NamedTextColor.BLUE);
            Component separator = Component.text(" | ", NamedTextColor.GRAY);

            return Component.textOfChildren(rank, nameComp, separator, message);
        });

    }

}
