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

## Learning It

The whole mod is one changed rule and it is invisible: a crafter looks like a crafter, behaves like a crafter, and simply stops one item short. Anyone who does not already know will read that as the crafter being broken, or as their own counting being wrong.

With [block-tip](https://github.com/justfatlard/block-tip) installed, looking at a crafter says so: *"Keeps one of each - the pattern stays"*.

There is nothing to craft and nothing to fetch here, so there is no quest worth writing. The fact just needs saying at the moment somebody is looking at the block.

Optional and guarded: without block-tip the mod behaves exactly as before.

## Installation

Install server-side alongside its declared dependencies (see `fabric.mod.json`). Vanilla clients need nothing. Version targets live in `gradle.properties` (Minecraft, loader, Fabric API) and `fabric.mod.json` (Java).

## License

MIT, see [LICENSE](LICENSE).
