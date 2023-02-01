package net.keegancuff.progrework.item;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    WOOD(MiningLevels.WOOD, 100, 3.0f, 0.0f, 15, () -> Ingredient.fromTag(ItemTags.PLANKS)),
    STONE(MiningLevels.STONE, 210, 4.5f, 1.0f, 5, () -> Ingredient.fromTag(ItemTags.STONE_TOOL_MATERIALS)),
    IRON(MiningLevels.IRON, 520, 6.5f, 2.0f, 14, () -> Ingredient.ofItems(Items.IRON_INGOT)),
    DIAMOND(MiningLevels.DIAMOND, 1561, 8.0f, 3.0f, 10, () -> Ingredient.ofItems(Items.DIAMOND)),
    GOLD(MiningLevels.WOOD, 180, 12.0f, 3.0f, 22, () -> Ingredient.ofItems(Items.GOLD_INGOT)),
    NETHERITE(MiningLevels.NETHERITE, 2031, 9.0f, 4.0f, 15, () -> Ingredient.ofItems(Items.NETHERITE_INGOT));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairIngredient;

    private ModToolMaterials(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = new Lazy(repairIngredient);
    }

    public int getDurability() {
        return this.itemDurability;
    }

    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage;
    }

    public int getMiningLevel() {
        return this.miningLevel;
    }

    public int getEnchantability() {
        return this.enchantability;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
