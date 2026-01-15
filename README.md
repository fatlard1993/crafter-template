# Crafter Template

A Fabric mod that makes the Crafter block retain 1 item in each slot, preserving your recipe pattern as a template.

![Minecraft 1.21.11](https://img.shields.io/badge/Minecraft-1.21.11-green)
![Fabric](https://img.shields.io/badge/Mod%20Loader-Fabric-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

## How It Works

Place your recipe ingredients in the Crafter with **at least 2 of each item**. The Crafter will craft normally until any slot reaches 1 item, then it stops - preserving that item as a template.

**Example:** Put 10 planks and 5 sticks in a Crafter set up for crafting sticks → planks recipe. It will craft until one ingredient hits 1 item remaining, then stop. The remaining items lock in your recipe pattern.

### Why This Is Useful

- **Recipe locking** - The template items prevent other recipes from being accidentally crafted
- **Automation friendly** - Feed items via hopper, output goes out, template stays put
- **No duplication** - Items are consumed normally, just stops before the last one

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.11
2. Download and install [Fabric API](https://modrinth.com/mod/fabric-api)
3. Download the latest release of Crafter Template
4. Place the jar file in your `mods` folder

Works on both dedicated servers and singleplayer. On servers, only the server needs the mod installed.

## Requirements

- Minecraft 1.21.11
- Fabric Loader 0.18.1+
- Fabric API

## License

MIT License - see [LICENSE](LICENSE)
