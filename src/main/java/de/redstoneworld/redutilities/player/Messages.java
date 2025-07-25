package de.redstoneworld.redutilities.player;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Messages {

    /**
     * This method sends the desired message to the player as an
     * <a href="https://minecraft.wiki/w/Action_bar" target="_blank">Actionbar</a> message.
     *
     * @param player (Player) the target player
     * @param message (String) the Actionbar message
     */
    @SuppressWarnings("deprecation")
    public static void sendActionbarMsg(Player player, String message) {
        player.sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

    }

}
