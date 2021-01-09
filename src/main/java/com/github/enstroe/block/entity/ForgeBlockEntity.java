package com.github.enstroe.block.entity;

import com.github.enstroe.Forgesmith;
import com.github.enstroe.screen.ForgeScreenHandler;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class ForgeBlockEntity extends AbstractFurnaceBlockEntity {
    public ForgeBlockEntity() {
        super(Forgesmith.FORGE_BLOCK_ENTITY, Forgesmith.FORGE_RECIPE_TYPE);
    }

    @Override
    public Text getContainerName() {
        return Text.of("test furnace");
    }

    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ForgeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}