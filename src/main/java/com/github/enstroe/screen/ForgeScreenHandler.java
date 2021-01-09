package com.github.enstroe.screen;

import com.github.enstroe.Forgesmith;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;

public class ForgeScreenHandler extends AbstractFurnaceScreenHandler {
    public ForgeScreenHandler(int i, PlayerInventory playerInventory) {
        super(Forgesmith.FORGE_SCREEN_HANDLER, Forgesmith.FORGE_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory);
    }

    public ForgeScreenHandler(int i, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(Forgesmith.FORGE_SCREEN_HANDLER, Forgesmith.FORGE_RECIPE_TYPE, RecipeBookCategory.FURNACE, i, playerInventory, inventory, propertyDelegate);
    }
}