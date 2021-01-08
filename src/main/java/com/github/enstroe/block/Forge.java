package com.github.enstroe.block;

import com.github.enstroe.block.entity.ForgeBlockEntity;

import org.jetbrains.annotations.Nullable;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.FurnaceBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

// Do not forget that we need every class to extends the abstract furnace classes or it won't work!
public class Forge extends AbstractFurnaceBlock {
    public Forge(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new ForgeBlockEntity();
    }

    @Override
    public void openScreen(World world, BlockPos pos, PlayerEntity player) {
        // This is called by the onUse method inside AbstractFurnaceBlock so
        // it is a little bit different of how you open the screen for normal container
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof FurnaceBlockEntity) {
            player.openHandledScreen((NamedScreenHandlerFactory) blockEntity);
            // Optional: increment player's stat
            player.incrementStat(Stats.INTERACT_WITH_FURNACE);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void openScreen(World world, BlockPos pos, PlayerEntity player) {
        // TODO Auto-generated method stub

    }
}

