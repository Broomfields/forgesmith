package com.github.enstroe;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.github.enstroe.tools.ModToolMaterials;

import com.github.enstroe.items.TamahaganeSteelItem;
import com.github.enstroe.items.CrucibleSteelItem;
import com.github.enstroe.items.ToolSteelItem;
import com.github.enstroe.items.CarbonSteelItem;


public class Forgesmith implements ModInitializer {
	
	///////////////////
	/// Private Variables

	private static final String MODID = "forgesmith";


	///////////////////
	/// Item Declaration

	private static final ItemGroup FORGESMITH_GROUP = FabricItemGroupBuilder.build(new Identifier(MODID, "group"), () -> new ItemStack(Forgesmith.CRUCIBLE_STEEL));

	private static final Item TAMAHAGANE_STEEL = new TamahaganeSteelItem(new Item.Settings().group(FORGESMITH_GROUP).maxCount(64));
	private static final Item CRUCIBLE_STEEL = new CrucibleSteelItem(new Item.Settings().group(FORGESMITH_GROUP).maxCount(64));
	private static final Item TOOL_STEEL = new ToolSteelItem(new Item.Settings().group(FORGESMITH_GROUP).maxCount(64));
	private static final Item CARBON_STEEL = new CarbonSteelItem(new Item.Settings().group(FORGESMITH_GROUP).maxCount(64));


	public static final ToolItem TOOL_STEEL_SWORD = new SwordItem(ModToolMaterials.TAMAHAGANE_STEEL, 7, -2.4F, new Item.Settings().group(FORGESMITH_GROUP));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		///////////////////
		/// Item Registry

		// Crafting Components
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel"), TAMAHAGANE_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel"), CRUCIBLE_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel"), TOOL_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel"), CARBON_STEEL);
		
		
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_sword"), TOOL_STEEL_SWORD);
		

		///////////////////
		/// Debug

		System.out.println("Hello Fabric world!");
	}
}
