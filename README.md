# OP Breaking Tools

All tools drop OP loot when they break. This plugin provides a way to change the OP loot that is dropped through a configurable `config.yml` file.

## Features

- Tools drop OP loot when they break.
- Configurable loot items and enchantments.
- Commands to start, stop, and reload the plugin.
- Customizable messages through language files.

## Commands

### /opbreakingtools start

Use this command to start the plugin. This will enable the plugin to drop OP loot when tools break.

### /opbreakingtools stop

Use this command to stop the plugin. This will disable the plugin from dropping OP loot when tools break.

### /opbreakingtools reload

Use this command to reload the plugin. This will reload the config and language files.

### /opbreakingtools help

Use this command to display the help message with available commands.

## Configuration

The plugin uses a `config.yml` file to manage settings. Here is an example configuration:

```yaml
loot:
  - material: ENDER_PEARL
    amount: 1-3
  - material: GOLDEN_APPLE
    amount: 3-5
  - material: GOLDEN_CARROT
    amount: 16-32
  - material: IRON_INGOT
    amount: 6-10
  - material: DIAMOND
    amount: 6-10
  - material: IRON_HELMET
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: DIAMOND_HELMET
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: IRON_CHESTPLATE
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: DIAMOND_CHESTPLATE
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: IRON_LEGGINGS
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: DIAMOND_LEGGINGS
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: IRON_BOOTS
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: DIAMOND_BOOTS
    enchantments:
      - type: UNBREAKING
        level: 3
      - type: PROTECTION
        level: 1-6
  - material: IRON_AXE
    enchantments:
      - type: SHARPNESS
        level: 1-6
  - material: DIAMOND_AXE
    enchantments:
      - type: SHARPNESS
        level: 1-6
  - material: IRON_SWORD
    enchantments:
      - type: SHARPNESS
        level: 1-6
  - material: DIAMOND_SWORD
    enchantments:
      - type: SHARPNESS
        level: 1-6
  - material: TRIDENT
    enchantments:
      - type: RIPTIDE
        level: 3
      - type: UNBREAKING
        level: 3
  - material: DIAMOND_PICKAXE
    enchantments:
      - type: EFFICIENCY
        level: 5-10
      - type: UNBREAKING
        level: 3
  - material: NETHERITE_SWORD
    enchantments:
      - type: SHARPNESS
        level: 1-6
      - type: UNBREAKING
        level: 3
  - material: NETHERITE_AXE
    enchantments:
      - type: SHARPNESS
        level: 1-6
      - type: UNBREAKING
        level: 3
  - material: NETHERITE_PICKAXE
    enchantments:
      - type: EFFICIENCY
        level: 5-10
      - type: UNBREAKING
        level: 3
  - material: ELYTRA
  - material: ENCHANTED_GOLDEN_APPLE
    amount: 1-2
  - material: TOTEM_OF_UNDYING
  - material: MACE
    enchantments:
      - type: DENSITY
        level: 0-4
      - type: FIRE_ASPECT
        level: 0-1
```

## Language

Customizable messages are stored in

en_us.lang.yml

. Here is an example:

```yaml
# Prefix which will be shown before all the messages.
prefix: "<gold>OP Break Tools <gray>»<white>"
help-title: "<gold>Help: <b>%command%"
# Messages for commands:
commands:
  # /opbreakingtools reload
  reload: "<green>Configurations and languages reloaded."
  # /opbreakingtools start
  start:
    # Message when the game is started.
    started: "<green>Game started."
    # Message when the game is already running.
    already-running: "<red>Game is already running."
  # /opbreakingtools stop
  stop:
    # Message when the game is stopped.
    stopped: "<green>Game stopped."
    # Message when the game is not running.
    not-running: "<red>Game is not running."
  # /opbreakingtools help
  help: |-
    <yellow>/opbreakingtools start <gray>- <white>Use this command to start the plugin. This will enable the plugin to drop OP loot when tools break.
    <yellow>/opbreakingtools stop <gray>- <white>Use this command to stop the plugin. This will disable the plugin from dropping OP loot when tools break.
    <yellow>/opbreakingtools reload <gray>- <white>Use this command to reload the plugin's configurations and languages.
    <yellow>/opbreakingtools help <gray>- <white>Show this help message.
```

## Permissions

The plugin uses the following permissions:

- `opbreakingtools`: Permission to use the `/opbreakingtools` command.

## Installation

1. Download the plugin jar file.
2. Place the jar file in your server's `plugins` directory.
3. Start or restart your server.
4. Configure the plugin by editing the

config.yml

 and

en_us.lang.yml

 files in the `plugins/opbreakingtools` directory.
5. Use the `/opbreakingtools` commands to manage the plugin.

## Authors

- TejasLamba2006

## Dependencies

- BlueSlimeCore (required)
- PlaceholderAPI (optional)
