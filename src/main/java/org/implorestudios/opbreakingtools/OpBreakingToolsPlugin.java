package org.implorestudios.opbreakingtools;

import com.github.sirblobman.api.configuration.ConfigurationManager;
import com.github.sirblobman.api.language.LanguageManager;
import com.github.sirblobman.api.language.replacer.Replacer;
import com.github.sirblobman.api.plugin.ConfigurablePlugin;
import com.github.sirblobman.api.shaded.adventure.text.minimessage.MiniMessage;

import lombok.Getter;
import net.kyori.adventure.text.Component;


import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.implorestudios.opbreakingtools.command.opbreakingtools.OpBreakingToolsCommand;
import org.implorestudios.opbreakingtools.event.GameEvents;

@Getter
public final class OpBreakingToolsPlugin extends ConfigurablePlugin {
    public static OpBreakingToolsPlugin plugin;
    public static OpLoot oploot;
    public static Component mmString(String string) {
        String text = MiniMessage.miniMessage().serialize(MiniMessage.miniMessage().deserialize(string));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    public static Component mm(CommandSender audience, String key) {
        String text = MiniMessage.miniMessage().serialize(plugin.getLanguageManager().getMessageWithPrefix(audience, key));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    public static Component mm(CommandSender audience, String key, Replacer... replacer) {
        String text = MiniMessage.miniMessage().serialize(plugin.getLanguageManager().getMessageWithPrefix(audience, key, replacer));
        return net.kyori.adventure.text.minimessage.MiniMessage.miniMessage().deserialize(text);
    }
    private YamlConfiguration mainConfig;
    @Override
    public void onLoad() {
        this.loadConfig();
    }

    @Override
    public void onEnable() {
        plugin = this;
        oploot = new OpLoot();
        this.loadLanguages();
        this.registerCommands();
        this.registerListeners();
        getLogger().info("OpBreakingTools plugin has been enabled.");
    }

    public void reload() {
        this.loadConfig();
        this.loadLanguages();
        this.registerCommands();
        this.registerListeners();
        getLogger().info("OpBreakingTools plugin has been reloaded.");
    }

    @Override
    public void onDisable() {
        getLogger().info("OpBreakingTools plugin has been disabled.");
    }

    private void loadConfig() {
        ConfigurationManager configurationManager = getConfigurationManager();
        configurationManager.saveDefault("config.yml");
        configurationManager.reload("config.yml");
        this.mainConfig = configurationManager.get("config.yml");
        getLogger().info("Configuration loaded");
    }

    private void loadLanguages() {
        LanguageManager languageManager = getLanguageManager();
        languageManager.saveDefaultLanguageFiles();
        languageManager.reloadLanguages();
        languageManager.onPluginEnable();
        getLogger().info("Languages loaded");
    }

    private void registerCommands() {
        new OpBreakingToolsCommand(this).register();
        getLogger().info("Commands registered");
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new GameEvents(), this);
        getLogger().info("Events registered");
    }
}