package justfatlard.crafter_template.integration;

import justfatlard.block_tip.api.BlockTipApi;

/**
 * Says out loud what a crafter here does differently.
 *
 * <p>The whole mod is one changed rule and it is invisible: a crafter looks like
 * a crafter, behaves like a crafter, and simply stops one item short. A player
 * who does not already know will read that as the crafter being broken, or as
 * their own counting being wrong.
 *
 * <p>There is nothing to craft and nothing to fetch, so there is no quest here
 * worth writing. The fact just needs saying at the moment somebody is looking at
 * the block, which is what block-tip is.
 *
 * <p>Names block-tip types directly, so it must only be loaded behind the
 * isModLoaded guard in the entry point.
 */
public final class CrafterTipRegistration {
	private CrafterTipRegistration() {}

	public static void register() {
		BlockTipApi.line("minecraft:crafter", "Keeps a template");
	}
}
