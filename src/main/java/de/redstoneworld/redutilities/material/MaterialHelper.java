package de.redstoneworld.redutilities.material;

import com.destroystokyo.paper.MaterialTags;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;

import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

public class MaterialHelper {

    /**
     * This method returns a list of Materials based on the Set of input strings.
     *
     * @param inputSet (Set of Strings) the input String
     * @return (Set of Materials) the resulted Materials
     */
    public static Set<Material> getMaterials(Set<String> inputSet) {
        if ((inputSet == null) || (inputSet.isEmpty())) return null;

        Set<Material> materials = EnumSet.noneOf(Material.class);

        for (String input : inputSet.stream().toList()) {
            materials.addAll(getMaterials(input));
        }

        return materials;
    }

    /**
     * This method returns a list of Materials based on the input string. Various formats
     * of specifications are supported here:
     *
     * <ul>
     *   <li>Material Tag starting with "#" or "tag=" - see <a href="https://minecraft.wiki/w/Block_tag_(Java_Edition)">Minecraft-Wiki Article</a> 
     *   for the Vanilla Material Tags and <a href="https://jd.papermc.io/paper/1.21.1/org/bukkit/Tag.html">PaperMC Java-Doc</a> for the Bukkit 
     *   implementation</li>
     *   <li>Regex via "r="</li>
     *   <li>clean MATERIAL names with wildcards via "*"</li>
     *   <li>clean MATERIAL names</li>
     * </ul>
     *
     * <br/><br/>
     * Basic-Design by <a href="https://github.com/Phoenix616">Phoenix616</a>
     *
     * @param input (String) the input String
     * @return (Set of Materials) the resulted Materials
     */
    public static Set<Material> getMaterials(String input) {
        if ((input == null) || (input.isEmpty())) return null;

        Set<Material> materials = EnumSet.noneOf(Material.class);

        // Material-Tag Definition:
        if ((input.startsWith("#")) || (input.startsWith("tag="))) {
            String nameSpace = "";
            String tagName = "";

            if (input.startsWith("#")) {
                tagName = input.substring(1).toLowerCase();
            } else if (input.startsWith("tag=")) {
                tagName = input.substring(4).toLowerCase();
            }

            String[] parts = tagName.split(":");
            if (parts.length == 1) {
                nameSpace = NamespacedKey.MINECRAFT;
                tagName = parts[0].toLowerCase();
            } else if (parts.length == 2) {
                nameSpace = parts[0].toLowerCase();
                tagName = parts[1].toLowerCase();
            }

            Tag<Material> tag;

            // Blocks:
            tag = Bukkit.getTag(Tag.REGISTRY_BLOCKS, new NamespacedKey(nameSpace, tagName), Material.class);

            // Items:
            if (tag == null) {
                tag = Bukkit.getTag(Tag.REGISTRY_ITEMS, new NamespacedKey(nameSpace, tagName), Material.class);
            }

            if (tag == null) {
                try {
                    Field field = MaterialTags.class.getField(tagName);
                    tag = (Tag<Material>) field.get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }

            if (tag != null) {
                materials.addAll(tag.getValues());
            }

        // Regex Definition:
        } else if (input.startsWith("r=") || input.contains("*")) {
            Pattern p = Pattern.compile(input.startsWith("r=") ? input.substring(2) : input.replace("*", "(.*)"));

            for (Material material : Material.values()) {
                if (p.matcher(material.name()).matches()) {
                    materials.add(material);
                }
            }

        // clean Material-Name Definition:
        } else {
            materials.add(Material.valueOf(input.toUpperCase()));

        }

        return materials;
    }

}
