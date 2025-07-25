package de.redstoneworld.redutilities.misc;

import java.util.Locale;

public class LocaleHelper {

    /**
     * This method converts a locale string (e.g., "de", "de_DE", "en-US", "fr_CA_POSIX")
     * into a Java 'Locale' object.
     *
     * Supports both underscore "_" and hyphen "-" as separators.
     * Examples:
     * "de"             -> new Locale("de")
     * "de_DE"          -> new Locale("de", "DE")
     * "en-US"          -> new Locale("en", "US")
     * "fr_CA_POSIX"    -> new Locale("fr", "CA", "POSIX")
     *
     * If the input is null or empty, the system default locale is returned.
     *
     * @param localeStr the locale string to parse
     * @return the corresponding Locale object
     */
    public static Locale getLocale(String localeStr) {
        if (localeStr == null || localeStr.trim().isEmpty()) {
            return Locale.getDefault();
        }

        // Normalize separators: convert hyphens to underscores
        String normalized = localeStr.replace('-', '_');
        String[] parts = normalized.split("_", -1); // -1 to include empty trailing parts if any

        switch (parts.length) {
            case 1:
                return new Locale(parts[0]); // language only
            case 2:
                return new Locale(parts[0], parts[1]); // language + country
            case 3:
                return new Locale(parts[0], parts[1], parts[2]); // language + country + variant
            default:
                throw new IllegalArgumentException("Invalid locale format: " + localeStr);
        }
    }

}
