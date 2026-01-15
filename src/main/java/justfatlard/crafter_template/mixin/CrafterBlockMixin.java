package justfatlard.crafter_template.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CrafterBlock;
import net.minecraft.block.entity.CrafterBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrafterBlock.class)
public abstract class CrafterBlockMixin {

	/**
	 * Cancel crafting if any non-empty slot has only 1 item.
	 * This preserves the item as a "template" - crafting only works
	 * when all recipe slots have at least 2 items.
	 */
	@Inject(method = "craft", at = @At("HEAD"), cancellable = true)
	private void preventCraftingWithTemplateOnly(BlockState state, ServerWorld world, BlockPos pos, CallbackInfo ci) {
		if (world.getBlockEntity(pos) instanceof CrafterBlockEntity crafter) {
			DefaultedList<ItemStack> stacks = crafter.getHeldStacks();

			for (ItemStack stack : stacks) {
				// If any non-empty slot has only 1 item, don't allow crafting
				if (!stack.isEmpty() && stack.getCount() <= 1) {
					ci.cancel();
					return;
				}
			}
		}
	}
}
