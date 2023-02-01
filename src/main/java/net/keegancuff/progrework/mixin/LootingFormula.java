package net.keegancuff.progrework.mixin;

import net.minecraft.loot.function.LootingEnchantLootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LootingEnchantLootFunction.class)
public class LootingFormula {
    @ModifyVariable(method = "process", at = @At("STORE"))
    private double injected(float f){
        return Math.min(1f, f);
    }
}
