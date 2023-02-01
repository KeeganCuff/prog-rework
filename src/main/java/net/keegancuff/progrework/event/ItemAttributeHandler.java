package net.keegancuff.progrework.event;

import com.google.common.collect.Multimap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.item.v1.ModifyItemAttributeModifiersCallback;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;

public class ItemAttributeHandler implements ModifyItemAttributeModifiersCallback {
    @Override
    public void modifyAttributeModifiers(ItemStack stack, EquipmentSlot slot, Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers) {
//        if (stack.isOf(Items.GOLDEN_SWORD) && slot.getEntitySlotId() == EquipmentSlot.MAINHAND.getEntitySlotId()){
//            attributeModifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier("gold_damage_override", 4f, EntityAttributeModifier.Operation.ADDITION ));
//        }
    }
}
