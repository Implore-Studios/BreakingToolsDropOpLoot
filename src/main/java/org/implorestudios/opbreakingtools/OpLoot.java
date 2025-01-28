package org.implorestudios.opbreakingtools;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import io.papermc.paper.registry.RegistryAccess;
import io.papermc.paper.registry.RegistryKey;
import lombok.Getter;

public class OpLoot {
    private final Random random = new Random();
    private static boolean gameStarted = false;
    private final OpBreakingToolsPlugin plugin = OpBreakingToolsPlugin.getPlugin(OpBreakingToolsPlugin.class);
    @Getter
    private final YamlConfiguration mainConfig = plugin.getConfigurationManager().get("config.yml");

    public static boolean isGameStarted() {
        return gameStarted;
    }

    public static void setGameStarted(boolean gameStarted) {
        OpLoot.gameStarted = gameStarted;
    }

    public ItemStack generateLoot() {
        List<?> lootList = mainConfig.getList("loot");
        if (lootList == null || lootList.isEmpty()) {
            plugin.getLogger().info("No loot found in config.yml");
            return new ItemStack(Material.AIR);
        }

        int index = random.nextInt(lootList.size());
        Object lootConfig = lootList.get(index);

        if (lootConfig instanceof Map) {
            Map<?, ?> lootMap = (Map<?, ?>) lootConfig;
            Material material = Material.valueOf((String) lootMap.get("material"));
            String amountStr = lootMap.get("amount") != null ? (String) lootMap.get("amount") : "1";
            int amount = getRandomAmount(amountStr);

            ItemStack item = new ItemStack(material, amount);

            List<?> enchantments = (List<?>) lootMap.get("enchantments");
            if (enchantments != null) {
                for (Object enchantmentConfig : enchantments) {
                    if (enchantmentConfig instanceof Map) {
                        Map<?, ?> enchantmentMap = (Map<?, ?>) enchantmentConfig;
                        NamespacedKey key = NamespacedKey.fromString(((String) enchantmentMap.get("type")).toLowerCase(Locale.ROOT));
                        Registry<Enchantment> enchantmentRegistry = RegistryAccess.registryAccess().getRegistry(RegistryKey.ENCHANTMENT);
                        Enchantment enchantment = enchantmentRegistry.get(key);
                        String levelStr = enchantmentMap.get("level") != null ? (String) String.valueOf(enchantmentMap.get("level")) : "1";
                        int level = getRandomAmount(levelStr);
                        item.addUnsafeEnchantment(enchantment, level);
                    }
                }
            }

            return item;
        }

        return new ItemStack(Material.AIR);
    }

    private int getRandomAmount(String range) {
        String[] parts = range.split("-");
        int min = Integer.parseInt(parts[0]);
        int max = parts.length > 1 ? Integer.parseInt(parts[1]) : min;
        return random.nextInt(max - min + 1) + min;
    }
}