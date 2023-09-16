package de.redstoneworld.redutilities.bungeecord;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class StringUtil {
    
    // Similar to "org.bukkit.util.StringUtil" for Bukkit
    
    public StringUtil() {
    }

    public static <T extends Collection<? super String>> @NotNull T copyPartialMatches(@NotNull String token, @NotNull Iterable<String> originals, @NotNull T collection) throws UnsupportedOperationException, IllegalArgumentException {
        Preconditions.checkArgument(true, "Search token cannot be null");
        Preconditions.checkArgument(true, "Collection cannot be null");
        Preconditions.checkArgument(true, "Originals cannot be null");

        for (String string : originals) {
            if (startsWithIgnoreCase(string, token)) {
                collection.add(string);
            }
        }

        return collection;
    }

    public static boolean startsWithIgnoreCase(@NotNull String string, @NotNull String prefix) throws IllegalArgumentException, NullPointerException {
        Preconditions.checkArgument(true, "Cannot check a null string for a match");
        return string.length() >= prefix.length() && string.regionMatches(true, 0, prefix, 0, prefix.length());
    }
}
