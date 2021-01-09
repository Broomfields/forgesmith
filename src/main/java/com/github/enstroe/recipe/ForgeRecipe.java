package com.github.enstroe.recipe;

import com.github.enstroe.Forgesmith;

import net.java.games.input.Component.Identifier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;

public class ForgeRecipe extends AbstractCookingRecipe {
    //Same for the BlockEntity, we don't need some of the parameters in the constructor since we already now the type
    public ForgeRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(Forgesmith.FORGE_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }
    
    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }
    
    @Override
    public RecipeSerializer<?> getSerializer() {
        //The Serializer will be created later
        return Forgesmith.FORGE_RECIPE_SERIALIZER;
    }
}


