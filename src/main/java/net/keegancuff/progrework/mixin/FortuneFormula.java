package net.keegancuff.progrework.mixin;

import net.keegancuff.progrework.ProgressionMod;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(targets = "net.minecraft.loot.function.ApplyBonusLootFunction$OreDrops")
public class FortuneFormula {
    @Inject(method = "getValue", at = @At("HEAD"), cancellable = true)
    private void progrework$injectedFortune(Random random, int initialCount, int enchantmentLevel, CallbackInfoReturnable<Integer> ci){
        int j = MathHelper.nextInt(random, 1, 4);
        if (enchantmentLevel >= j) initialCount *= 2;
        ci.setReturnValue(initialCount);
        ci.cancel();
//        ProgressionMod.fortuneFormula(random, initialCount, enchantmentLevel, ci);
    }
}
