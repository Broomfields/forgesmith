package com.github.enstroe.recipe;

import com.github.enstroe.Forgesmith;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;

public class ForgeRecipe extends AbstractCookingRecipe {
    public ForgeRecipe(Identifier id, String group, Ingredient input, ItemStack output, float experience, int cookTime) {
        super(Forgesmith.FORGE_RECIPE_TYPE, id, group, input, output, experience, cookTime);
    }

    @Override
    public ItemStack getRecipeKindIcon() {
        return new ItemStack(Items.BLACKSTONE);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Forgesmith.FORGE_RECIPE_SERIALIZER;
    }
}