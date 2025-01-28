package org.implorestudios.opbreakingtools.command.opbreakingtools;

import com.github.sirblobman.api.command.Command;

import lombok.NonNull;

import org.bukkit.command.CommandSender;
import org.implorestudios.opbreakingtools.OpBreakingToolsPlugin;
import org.implorestudios.opbreakingtools.OpLoot;

import java.util.List;

public class StopSubCommand extends Command {
    private @NonNull OpBreakingToolsPlugin plugin;
    
        public StopSubCommand(@NonNull OpBreakingToolsPlugin plugin) {
            super(plugin, "stop");
            this.plugin = plugin;
    }

    @Override
    protected @NonNull List<String> onTabComplete(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        return List.of();
    }

    @Override
    protected boolean execute(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        if (!OpLoot.isGameStarted()) {
            sendMessageWithPrefix(commandSender, "commands.stop.not-started");
            return false;
        }
        OpLoot.setGameStarted(false);
        sendMessageWithPrefix(commandSender, "commands.stop.stopped");
       
        return true;
    }
}

