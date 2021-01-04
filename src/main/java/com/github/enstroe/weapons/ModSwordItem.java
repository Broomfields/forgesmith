package com.github.enstroe.weapons;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.Item.Settings;


public class ModSwordItem extends SwordItem {

    //Default Constructor
    public ModSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }


    
}