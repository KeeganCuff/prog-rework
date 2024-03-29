package net.keegancuff.progrework.mixin;

import net.minecraft.block.entity.MobSpawnerBlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DungeonFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DungeonFeature.class)
public class HuskSpawner {
    private static final EntityType<?>[] DESERT_MOB_SPAWNER_ENTITIES = new EntityType[]{EntityType.SKELETON, EntityType.HUSK, EntityType.ZOMBIE, EntityType.SPIDER};
    @Inject(method = "generate", at = @At("RETURN"))
    private void injected(FeatureContext<DefaultFeatureConfig> context, CallbackInfoReturnable ci){
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        if (world.getBiome(pos).matchesKey(BiomeKeys.DESERT) && world.getBlockEntity(pos) instanceof MobSpawnerBlockEntity mobSpawnerBlockEntity){
            mobSpawnerBlockEntity.setEntityType(getMobSpawnerEntity(random), random);
        }
    }

    private EntityType<?> getMobSpawnerEntity(Random random) {
        return Util.getRandom(DESERT_MOB_SPAWNER_ENTITIES, random);
    }
}
