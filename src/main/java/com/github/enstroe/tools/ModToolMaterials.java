package com.github.enstroe.tools;

import com.github.enstroe.items.TamahaganeSteelItem;
import com.github.enstroe.items.CrucibleSteelItem;
import com.github.enstroe.items.ToolSteelItem;
import com.github.enstroe.items.CarbonSteelItem;

import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    //Steel Constructors
    TAMAHAGANE_STEEL("tamahagane_steel", 0.6f, 6.3f, 2.2f, 2, 12, () -> Ingredient.ofItems(new TamahaganeSteelItem(new Item.Settings()))), //Tamahagane

    CRUCIBLE_STEEL("crucible_steel", 0.6f, 6.3f, 2.2f, 2, 12, () -> Ingredient.ofItems(new CrucibleSteelItem(new Item.Settings()))), //Crucible

    TOOL_STEEL("tool_steel", 0.6f, 6.3f, 2.2f, 2, 12, () -> Ingredient.ofItems(new ToolSteelItem(new Item.Settings()))), //Tool

    CARBON_STEEL("carbon_steel", 0.6f, 6.3f, 2.2f, 2, 12, () -> Ingredient.ofItems(new CarbonSteelItem(new Item.Settings()))); //Carbon

    //Allows for expansion with future tool sets

    private final String Name;
    private final int BaseSteelDurability = 768;
    private final float DurabilityMultiplier;
    private final float MiningSpeed;
    private final float AttackDamage;
    private final int MiningLevel;
    private final int Enchantability;
    private final Lazy<Ingredient> RepairIngredientSupplier;

    ModToolMaterials(String name, float durabilityMultiplier, float miningSpeed, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredientSupplier) {
        this.Name = name;
        this.DurabilityMultiplier = durabilityMultiplier;
        this.MiningSpeed = miningSpeed;
        this.AttackDamage = attackDamage;
        this.MiningLevel = miningLevel;
        this.Enchantability = enchantability;
        this.RepairIngredientSupplier = new Lazy<>(repairIngredientSupplier);
    }


    public String getName() {
        return Name;
    }

    @Override
    public int getDurability() {
        return (int)(BaseSteelDurability * DurabilityMultiplier);
    }
    
    @Override
    public float getMiningSpeedMultiplier() {
        return MiningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return AttackDamage;
    }

    @Override
    public int getMiningLevel() {
        return MiningLevel;
    }

    @Override
    public int getEnchantability() {
        return Enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return RepairIngredientSupplier.get();
    }
}