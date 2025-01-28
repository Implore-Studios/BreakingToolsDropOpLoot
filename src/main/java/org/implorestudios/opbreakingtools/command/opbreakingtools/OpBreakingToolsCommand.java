package org.implorestudios.opbreakingtools.command.opbreakingtools;

import com.github.sirblobman.api.command.Command;
import com.github.sirblobman.api.language.replacer.StringReplacer;
import lombok.NonNull;
import org.bukkit.command.CommandSender;
import org.implorestudios.opbreakingtools.OpBreakingToolsPlugin;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class OpBreakingToolsCommand extends Command {
    public OpBreakingToolsCommand(@NonNull OpBreakingToolsPlugin plugin) {
        super(plugin, "opbreakingtools");
        setPermissionName("opbreakingtools.command");
        addSubCommand(new ReloadSubcommand(plugin));
        addSubCommand(new StartSubCommand(plugin));
        addSubCommand(new StopSubCommand(plugin));
    }
    @Override
    protected @NonNull List<String> onTabComplete(@NonNull CommandSender sender, String @NonNull [] args) {
        return Collections.emptyList();
    }

    @Override
    protected boolean execute(@NonNull CommandSender commandSender, String @NonNull [] strings) {
        Objects.requireNonNull(getLanguageManager()).sendMessage(commandSender, "help-title", new StringReplacer("%command%", "/opbreakingtools"));
        Objects.requireNonNull(getLanguageManager()).sendMessage(commandSender, "commands.help");
        return true;
    }
}
