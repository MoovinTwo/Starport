package com.moovintwo.starport;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.joinMessage(MiniMessage.miniMessage().deserialize("<head:" + event.getPlayer().getName() + "> <username> has Joined the Server", Placeholder.component("username", Component.text(event.getPlayer().getName())) ));
    }
}

