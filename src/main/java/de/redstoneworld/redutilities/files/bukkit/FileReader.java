package de.redstoneworld.redutilities.files.bukkit;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.Configuration;

public class FileReader {
    
    Configuration configuration;
    
    // Configuration sections following the standard structure of the RedstoneWorld plugins.
    private String configPartMessages = "messages";
    private String configPartFeatures = "features";
    
    public void setConfig(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * This method sets the configuration part for messages.
     * 
     * @param configPartMessages (String) config part
     */
    public void setConfigPartMessages(String configPartMessages) {
        this.configPartMessages = configPartMessages;
    }

    /**
     * This method sets the configuration part for features.
     *
     * @param configPartFeatures (String) config part
     */
    public void setConfigPartFeatures(String configPartFeatures) {
        this.configPartFeatures = configPartFeatures;
    }

    private String getConfigPartMessages() {
        return configPartMessages;
    }

    private String getConfigPartFeatures() {
        return configPartFeatures;
    }

    /**
     * This method reads the specific messages in config.yml and replaces
     * the minecraft color codes with a valid character.
     *
     * @param key YAML key
     * @param args placeholder without "%" and value for the placeholder
     *
     * @return the config messages (String)
     */
    public String getLang(String key, String... args) {
        String lang = configuration.getString(configPartMessages + "." + key, "&cUnknown language key &6" + key);
        for (int i = 0; i + 1 < args.length; i += 2) {
            lang = lang.replace("%" + args[i] + "%", args[i + 1]);
        }
        return ChatColor.translateAlternateColorCodes('&', lang);
    }

    public boolean getBooleanOption(String key) {
        return configuration.getBoolean(configPartFeatures + "." + key);
    }

    public int getIntOption(String key) {
        return configuration.getInt(configPartFeatures + "." + key);
    }

    public String getStringOption(String key) {
        return configuration.getString(configPartFeatures + "." + key);
    }
    
}
