package de.redstoneworld.redutilities.entity;

import io.papermc.paper.tag.EntityTags;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Tag;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;

public class EntityHelper {

    /**
     * This method returns a list of EntityTypes based on the Set of input strings.
     * 
     * @param inputSet (Set of Strings) the input String
     * @return (Set of EntityTypes) the resulted EntityTypes
     */
    public static Set<EntityType> getEntityTypes(Set<String> inputSet) {
        if ((inputSet == null) || (inputSet.isEmpty())) return null;
        
        Set<EntityType> entities = EnumSet.noneOf(EntityType.class);
        
        for (String input : inputSet.stream().toList()) {
            entities.addAll(getEntityTypes(input));
        }
        
        return entities;
    }
    
    /**
     * This method returns a list of EntityTypes based on the input string. Various formats 
     * of specifications are supported here:
     * 
     * <ul>
     * <li>EntityType-Tag starting with "#" or "tag=" (see <a href="https://minecraft.wiki/w/Tag#Entity_type_tags_2">Minecraft-Wiki</a> 
     * <i>(Vanilla Minecraft implementation)</i> and <a href="https://jd.papermc.io/paper/1.21.1/org/bukkit/Tag.html">PaperMC Java-Doc</a> 
     * <i>(Bukkit implementation)</i> for the EntityType-Tag lists)</li>
     * <li>Regex via "r="</li>
     * <li>clean ENTITY-TYPE names with wildcards via "*"</li>
     * <li>clean ENTITY-TYPE names</li>
     * </ul>
     * 
     * <b>Note:</b> Currently, the expanding <a href="https://jd.papermc.io/paper/1.21.1/io/papermc/paper/tag/EntityTags.html">EntitySetTags</a> 
     * from PaperMC are not supported here.
     * 
     * <br/><br/>
     * Basic-Design by <a href="https://github.com/Phoenix616">Phoenix616</a>
     * 
     * @param input (String) the input String
     * @return (Set of EntityTypes) the resulted EntityTypes
     */
    public static Set<EntityType> getEntityTypes(String input) {
        if ((input == null) || (input.isEmpty())) return null;
        
        Set<EntityType> entities = EnumSet.noneOf(EntityType.class);
        
        // EntityType-Tag Definition:
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
            
            Tag<EntityType> tag;
            
            // EntityTypes:
            tag = Bukkit.getTag(Tag.REGISTRY_ENTITY_TYPES, new NamespacedKey(nameSpace, tagName), EntityType.class);
            
            if (tag == null) {
                try {
                    Field field = EntityTags.class.getField(tagName);
                    tag = (Tag<EntityType>) field.get(null);
                } catch (NoSuchFieldException | IllegalAccessException e) {
                    throw new IllegalArgumentException(e.getMessage());
                }
            }

            if (tag != null) {
                entities.addAll(tag.getValues());
            }
            
        // Regex Definition:
        } else if (input.startsWith("r=") || input.contains("*")) {
            Pattern p = Pattern.compile(input.startsWith("r=") ? input.substring(2) : input.replace("*", "(.*)"));
            
            for (EntityType entity : EntityType.values()) {
                if (p.matcher(entity.name()).matches()) {
                    entities.add(entity);
                }
            }
            
        // clean EntityType-Name Definition:
        } else {
            entities.add(EntityType.valueOf(input.toUpperCase()));
            
        }
        
        return entities;
    }
    
}
