package de.redstoneworld.redutilities.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class Teleport {
    
    /**
     * This method teleports the player to the specified location. Before the teleport, however, 
     * the velocity is set to zero so that the player does not take over any fall damage due to 
     * the previous fall / fly. This is mainly relevant in the 'Survival-Mode'.
     * 
     * @param player (Player) the target player
     * @param targetLocation (Location) the target teleport-location
     */
    public static void teleportSafely(Player player, Location targetLocation) {
        player.setVelocity(new Vector(0, 0, 0));
        player.teleport(targetLocation);
    }

}
