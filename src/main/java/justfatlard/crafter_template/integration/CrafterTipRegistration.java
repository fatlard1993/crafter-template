package justfatlard.crafter_template.integration;

import java.util.Optional;
import justfatlard.block_tip.api.BlockTipApi;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.RecipeCache;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.CrafterBlockEntity;

/**
 * Says out loud what a crafter here does differently, and what this one is for.
 *
 * <p>The whole mod is one changed rule and it is invisible: a crafter looks like a crafter, behaves
 * like a crafter, and simply stops one item short. A player who does not already know will read
 * that as the crafter being broken, or as their own counting being wrong.
 *
 * <p>The rule also makes the second half possible. Because the pattern stays loaded, a crafter in
 * this world always knows what it is for, and the card can show it: a picture of the thing it makes
 * rather than nine ingredients the player has to solve in their head. That is worth more the deeper
 * a farm gets, where a wall of identical crafters is the whole point and none of them say which is
 * which.
 *
 * <p>Names block-tip types directly, so it must only be loaded behind the
 * isModLoaded guard in the entry point.
 */
public final class CrafterTipRegistration {
	private CrafterTipRegistration() {}

	private static final String LINE = "Keeps a template";

	/**
	 * Vanilla's own cache, sized as vanilla sizes it.
	 *
	 * <p>A crafting lookup walks every shaped and shapeless recipe in the game, and this one runs on
	 * the look tick rather than on a craft: four times a second for as long as somebody stands
	 * there. The grid it is asked about is the same grid every time, which is exactly the case the
	 * cache exists for.
	 */
	private static final RecipeCache RECIPES = new RecipeCache(10);

	public static void register() {
		BlockTipApi.illustrate((level, pos, state, player) -> {
			if (!state.is(Blocks.CRAFTER)) return null;
			if (!(level.getBlockEntity(pos) instanceof CrafterBlockEntity crafter)) return null;

			return new BlockTipApi.Tip(LINE, makes(crafter, level));
		});
	}

	/**
	 * What the loaded pattern comes out as, as an item id.
	 *
	 * <p>Asked of the grid rather than of anything the crafter records, because a crafter records
	 * nothing: the pattern is the items sitting in it, and the recipe books are the only thing that
	 * knows what those nine come out as. Counts do not matter to a match, so a crafter holding a
	 * bare template - one of each, the state this mod exists to preserve - still answers.
	 *
	 * @return empty where the grid matches no recipe, which is a crafter nobody has set up yet
	 */
	private static String makes(CrafterBlockEntity crafter, ServerLevel level) {
		CraftingInput input = crafter.asCraftInput();
		if (input.isEmpty()) return "";

		Optional<RecipeHolder<CraftingRecipe>> match = RECIPES.get(level, input);
		if (match.isEmpty()) return "";

		ItemStack result = match.get().value().assemble(input);
		return result.isEmpty() ? "" : BuiltInRegistries.ITEM.getKey(result.getItem()).toString();
	}
}
