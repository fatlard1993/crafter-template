package justfatlard.crafter_template.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.CrafterBlock;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.CrafterBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrafterBlock.class)
public abstract class CrafterBlockMixin {

	/**
	 * Cancel crafting if any non-empty slot has only 1 item.
	 * This preserves the item as a "template" - crafting only works
	 * when all occupied slots have at least 2 items.
	 */
	@Inject(method = "dispenseFrom", at = @At("HEAD"), cancellable = true)
	private void preventCraftingWithTemplateOnly(BlockState state, ServerLevel world, BlockPos pos, CallbackInfo ci) {
		if (world.getBlockEntity(pos) instanceof CrafterBlockEntity crafter) {
			NonNullList<ItemStack> stacks = crafter.getItems();

			for (ItemStack stack : stacks) {
				if (!stack.isEmpty() && stack.getCount() <= 1) {
					world.levelEvent(LevelEvent.SOUND_CRAFTER_FAIL, pos, 0);
					ci.cancel();
					return;
				}
			}
		}
	}
}
