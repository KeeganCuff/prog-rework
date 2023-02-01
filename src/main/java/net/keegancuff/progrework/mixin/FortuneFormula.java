package net.keegancuff.progrework.mixin;

import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.loot.function.ApplyBonusLootFunction$OreDrops")
public class FortuneFormula {
    @Inject(method = "getValue", at = @At("HEAD"))
    private void progrework$injectedFortune(Random random, int initialCount, int enchantmentLevel, CallbackInfoReturnable<Integer> ci){
        if (enchantmentLevel <= 0){ // if no fortune
            ci.setReturnValue(initialCount);
            ci.cancel();
        }
        int i = random.nextInt(4); // generated from 0 to 3
        if (i < enchantmentLevel){ // i == 0 for enchantmentLevel 1, i == 0 or i == 1 for eL 2, 0 1 or 2 for eL 3
            ci.setReturnValue(initialCount * 2);
            ci.cancel();
        }
        ci.setReturnValue(initialCount);
        ci.cancel();
    }
}
