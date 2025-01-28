package org.implorestudios.opbreakingtools.event;

import lombok.Getter;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.implorestudios.opbreakingtools.OpBreakingToolsPlugin;
import org.implorestudios.opbreakingtools.OpLoot;

public class GameEvents implements Listener {
    private final OpBreakingToolsPlugin plugin = OpBreakingToolsPlugin.getPlugin(OpBreakingToolsPlugin.class);
    @Getter
    private final YamlConfiguration mainConfig  =  plugin.getConfigurationManager().get("config.yml");
    @EventHandler
      public void onItemDamage(PlayerItemDamageEvent event) {
        if (!OpLoot.isGameStarted()) {
            return;
        }
         if (event.getItem().getType().getMaxDurability() - ((Damageable)event.getItem().getItemMeta()).getDamage() - event.getDamage() <= 0) {
            ItemStack item = OpBreakingToolsPlugin.oploot.generateLoot();
            plugin.getLogger().info("Item: " + item);
            event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getLocation(), item);
         }

      }
}