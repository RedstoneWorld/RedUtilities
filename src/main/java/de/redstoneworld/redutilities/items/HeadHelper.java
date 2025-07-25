package de.redstoneworld.redutilities.items;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
        // Create a new ItemStack of type PLAYER_HEAD
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);

        // Get the SkullMeta from the ItemStack
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        if (skullMeta == null) {
            return skull; // Return default skull if meta cannot be modified
        }
 
        // Create a GameProfile with a random UUID and dummy name
        GameProfile profile = new GameProfile(UUID.randomUUID(), "dummy_name");
        profile.getProperties().put("textures", new Property("textures", base64Texture));

         try {
            // Access the "profile" field dynamically
            Field profileField = null;
            for (Field field : skullMeta.getClass().getDeclaredFields()) {
                if (field.getType().getName().contains("ResolvableProfile") || field.getType().equals(GameProfile.class)) {
                    profileField = field;
                    break;
                }
            }
 
            if (profileField != null) {
                profileField.setAccessible(true);
 
                if (profileField.getType().getName().contains("ResolvableProfile")) {
                    // Create a ResolvableProfile wrapper for the GameProfile
                    Constructor<?> constructor = profileField.getType().getConstructor(GameProfile.class);
                    Object resolvableProfile = constructor.newInstance(profile);
                    profileField.set(skullMeta, resolvableProfile);
                } else {
                    // For older versions, set the GameProfile directly
                    profileField.set(skullMeta, profile);
                }
            }
        } catch (Exception e) {
             e.printStackTrace();
         }

        // Apply the modified SkullMeta to the ItemStack
        skull.setItemMeta(skullMeta);

        return skull;
     }
    
}
