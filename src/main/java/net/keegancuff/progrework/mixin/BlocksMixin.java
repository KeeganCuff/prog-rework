package net.keegancuff.progrework.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(Blocks.class)
public class BlocksMixin {
    @ModifyArgs(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FlowerBlock;<init>(Lnet/minecraft/entity/effect/StatusEffect;ILnet/minecraft/block/AbstractBlock$Settings;)V"))
    private static void susStewChanges(Args args){
        StatusEffect effect = args.get(0);
        if (effect.equals(StatusEffects.REGENERATION)){
            args.set(0, StatusEffects.HASTE);
        }
    }
}
