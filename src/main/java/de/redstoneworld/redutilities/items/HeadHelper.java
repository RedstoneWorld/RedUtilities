package de.redstoneworld.redutilities.items;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;

public class HeadHelper {

    /**
     * This method gets a ItemStack object from a player head with custom texture.
     * The texture is defined with a 'base64' encoded texture string specification.
     *
     * @param base64Texture The base64 encoded string representing the texture.
     * @return ItemStack of the skull with the specified texture
     */
    public static ItemStack getCustomHead(String base64Texture) {
        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        if (skullMeta == null) return head;

        PlayerProfile profile = org.bukkit.Bukkit.createProfile(UUID.randomUUID(), null);

        profile.getProperties().add(new ProfileProperty("textures", base64Texture));

        skullMeta.setPlayerProfile(profile);
        head.setItemMeta(skullMeta);

        return head;
    }
}
