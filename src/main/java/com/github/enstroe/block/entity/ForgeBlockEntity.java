package com.github.enstroe.block.entity;

import com.github.enstroe.Forgesmith;

import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;

public class ForgeBlockEntity extends AbstractFurnaceBlockEntity {
    //Since we already now the BlockEntityType and RecipeType we don't need them in the constructor's parameters
    public ForgeBlockEntity() {
        super(Forgesmith.FORGE_BLOCK_ENTITY, Forgesmith.TEST_RECIPE_TYPE);
    }
 
    @Override
    public Text getContainerName() {
        //you should use a translation key instead but this is easier
        return Text.of("test furnace");
    }
 
    @Override
    public ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new ForgeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }
}

