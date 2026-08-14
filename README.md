# Crafter Template

A Fabric mod that makes the Crafter block retain 1 item in each slot, preserving your recipe pattern as a template.

## How It Works

Place your recipe ingredients in the Crafter with **at least 2 of each item**. The Crafter will craft normally until any slot reaches 1 item, then it stops - preserving that item as a template.

**Example:** Put 10 planks and 5 sticks in a Crafter set up to craft sticks from planks. It will craft until one ingredient hits 1 item remaining, then stop. The remaining items lock in your recipe pattern.

### Why This Is Useful

- **Recipe locking** - The template items prevent other recipes from being accidentally crafted
- **Automation friendly** - Feed items via hopper, output goes out, template stays put
- **No duplication** - Items are consumed normally, just stops before the last one

### Good to Know

- **Any** non-empty slot with 1 item blocks crafting, not just slots that are part of the recipe. Keep unused slots empty or disabled.
- Loading exactly 1 of an item means the Crafter will never craft with it; you need at least 2 to start.
- Unstackable items (tools, etc.) always have a count of 1 and will always block crafting.
- Disabled Crafter slots are unaffected and work normally.

## Installation

Install alongside its declared dependencies (see `fabric.mod.json`).

Works on both dedicated servers and singleplayer. The mod's behavior is entirely server-side; on dedicated servers, only the server needs the mod installed.

## Requirements

Targets the Minecraft, Fabric Loader, Fabric API, and Java versions declared in this mod's `gradle.properties`; check there for the exact currently-supported version.

## License

MIT License - see [LICENSE](LICENSE)
