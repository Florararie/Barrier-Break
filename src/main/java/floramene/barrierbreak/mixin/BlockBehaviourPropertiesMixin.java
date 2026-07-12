package floramene.barrierbreak.mixin;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockBehaviour.Properties.class)
public abstract class BlockBehaviourPropertiesMixin {

    @Shadow
    public abstract BlockBehaviour.Properties strength(float destroyTime, float explosionResistance);

    @Shadow
    public abstract BlockBehaviour.Properties pushReaction(PushReaction pushReaction);

    @Inject(
        method = "setId",
        at = @At("RETURN")
    )
    public void makeBarrierInstaBreak(ResourceKey<Block> resourceKey, CallbackInfoReturnable<BlockBehaviour.Properties> cir) {
        Identifier id = resourceKey.identifier();

        if (id.getNamespace().equals("minecraft") && id.getPath().equals("barrier")) {
            this.strength(0.0F, 3600000.0F);
            this.pushReaction(PushReaction.NORMAL);
        }
    }
}
