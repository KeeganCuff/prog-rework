package net.keegancuff.progrework.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ComposterBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class SieveBlock extends Block {

    public static final int MAX_LEVEL = 3;

    public static final IntProperty LEVEL = IntProperty.of("sieve_level", 0, MAX_LEVEL);
    public static final Property<SieveInput> INPUT = EnumProperty.of("sieve_input", SieveInput.class);

    public SieveBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
        builder.add(INPUT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int curLevel = state.get(LEVEL);
        ItemStack stack = player.getStackInHand(hand);
        if (curLevel == 0 && (stack.isOf(Items.SAND) || stack.isOf(Items.GRAVEL))){
            insertInput(state, world, pos, player, stack);
            return ActionResult.SUCCESS;
        } else if (curLevel != 0){
            decrementLevel(state, world, pos);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    private static void decrementLevel(BlockState state, World world, BlockPos pos){
        if (state.get(LEVEL) != 0){
            BlockState newState = state.with(LEVEL, state.get(LEVEL)-1);
            if (newState.get(LEVEL) == 0){
                newState = newState.with(INPUT, SieveInput.EMPTY);
            }
            SieveInput input = state.get(INPUT);
            playEffects(state, world, pos, false, input);
            world.setBlockState(pos, newState);
            if (world.getRandom().nextInt(input.getChance() * 3) == 0) {
                dropStack(world, pos, new ItemStack(input.getOutput(), 1));
            }

        }
    }

    private static void insertInput(BlockState state, World world, BlockPos pos, PlayerEntity player, ItemStack stack){
        assert (state.get(LEVEL) == 0);
        BlockState newState = state.with(LEVEL, MAX_LEVEL);
        SieveInput input = stack.isOf(Items.SAND) ? SieveInput.SAND : SieveInput.GRAVEL;
        newState = newState.with(INPUT, input);
        playEffects(state, world, pos, true, input);
        world.setBlockState(pos, newState);
        if (!player.getAbilities().creativeMode) {
            stack.decrement(1);
        }
    }

    private static void playEffects(BlockState state, World world, BlockPos pos, boolean fill, SieveInput input) {
        if (input.equals(SieveInput.SAND))
            world.playSoundAtBlockCenter(pos, fill ? SoundEvents.BLOCK_SAND_PLACE : SoundEvents.BLOCK_SAND_PLACE, SoundCategory.BLOCKS, 0.4f, 1.0f, false);
        else
            world.playSoundAtBlockCenter(pos, fill ? SoundEvents.BLOCK_GRAVEL_PLACE : SoundEvents.BLOCK_GRAVEL_PLACE, SoundCategory.BLOCKS, 0.4f, 1.0f, false);
        double topCoord = state.getOutlineShape(world, pos).getEndingCoord(Direction.Axis.Y, 0.5, 0.5) + 0.03125;
        Random random = world.getRandom();
        for (int i = 0; i < 10; ++i) {
            double g = random.nextGaussian() * 0.02;
            double h = random.nextGaussian() * 0.02;
            double j = random.nextGaussian() * 0.02;
            world.addParticle(ParticleTypes.COMPOSTER, (double)pos.getX() + (double)0.13125f + (double)0.7375f * (double)random.nextFloat(), (double)pos.getY() + topCoord + (double)random.nextFloat() * (1.0 - topCoord), (double)pos.getZ() + (double)0.13125f + (double)0.7375f * (double)random.nextFloat(), g, h, j);
        }
    }

}
