package de.redstoneworld.redutilities.player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Messages {

    @SuppressWarnings("deprecation")
    public static void sendActionbarMsg(Player player, String message) {
        player.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

    }
    
}
