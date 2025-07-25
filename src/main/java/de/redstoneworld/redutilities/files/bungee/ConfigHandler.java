package de.redstoneworld.redutilities.files.bungee;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

public class ConfigHandler {

    private static ConfigHandler instance;

    private Configuration config;
    private final Plugin plugin;
    private File configFile;

    public ConfigHandler(Plugin plugin) {
        instance = this;

        this.plugin = plugin;
        load("config.yml");
    }

    public ConfigHandler(Plugin plugin, String fileName) {
        instance = this;

        this.plugin = plugin;
        load(fileName);
    }

    private void load(String fileName) {
        configFile = new File(plugin.getDataFolder(), fileName);

        try {
            // Create Data folder
            if (!plugin.getDataFolder().exists()) {
                plugin.getLogger().log(Level.INFO, "Creating the plugin folder");

                plugin.getDataFolder().mkdirs();
            }

            // Copy default config if it doesn't exist
            if (!configFile.exists()) {
                plugin.getLogger().log(Level.INFO, "Copy default file: " + fileName);

                FileOutputStream outputStream = new FileOutputStream(configFile);
                InputStream in = plugin.getResourceAsStream(fileName);
                in.transferTo(outputStream);
            }

            // Load config
            config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(configFile);
            plugin.getLogger().log(Level.INFO, "Loaded file: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveConfig() {
        String fileName = configFile.getName();
        plugin.getLogger().log(Level.INFO, "Saving file: " + fileName);

        try {
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reloadConfig() {
        String fileName = configFile.getName();
        plugin.getLogger().log(Level.INFO, "Reloading file: " + fileName);

        load(configFile.getName());
    }

    public static ConfigHandler getInstance() {
        return instance;
    }

    public Configuration getConfig() {
        return config;
    }
}