package com.github.enstroe;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.recipe.CookingRecipeSerializer;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import com.github.enstroe.tools.ModToolMaterials;

import com.github.enstroe.tools.ModShovelItem;
import com.github.enstroe.tools.ModPickaxeItem;
import com.github.enstroe.tools.ModAxeItem;
import com.github.enstroe.tools.ModHoeItem;

import com.github.enstroe.weapons.ModSwordItem;

import com.github.enstroe.items.IronSandItem;
import com.github.enstroe.items.SlagItem;
import com.github.enstroe.items.TamahaganeSteelItem;
import com.github.enstroe.items.CrucibleSteelItem;
import com.github.enstroe.items.ToolSteelItem;
import com.github.enstroe.recipe.ForgeRecipe;
import com.github.enstroe.block.Forge;
import com.github.enstroe.block.entity.ForgeBlockEntity;
import com.github.enstroe.items.CarbonSteelItem;


public class Forgesmith implements ModInitializer {
	
	///////////////////
	/// Private Variables

	private static final String MODID = "forgesmith";


	//Abstract
	public static final FORGE_FURNACE_SCREEN_HANDLER = ForgeScreenHandler::new;
	public static final RecipeSerializer<ForgeRecipe> FORGE_RECIPE_SERIALIZER = new CookingRecipeSerializer(ForgeRecipe::new, 200);
	public static final RecipeType<ForgeRecipe> FORGE_RECIPE_TYPE = new RecipeType<ForgeRecipe>() {
		@Override
		public String toString() {
			return "forge";
		}
	};



	///////////////////
	/// Object Declaration

	//Item Groups
	private static final ItemGroup GROUP_MAIN = FabricItemGroupBuilder.build(new Identifier(MODID, "main"), () -> new ItemStack(Forgesmith.TAMAHAGANE_STEEL));
	private static final ItemGroup GROUP_WEAPONS = FabricItemGroupBuilder.build(new Identifier(MODID, "weapons"), () -> new ItemStack(Forgesmith.CRUCIBLE_STEEL));

	//Blocks
	private static final Block TAMAHAGANE_STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	private static final Block CRUCIBLE_STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	private static final Block TOOL_STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	private static final Block CARBON_STEEL_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	public  static final Block FORGE_BLOCK = new Forge(FabricBlockSettings.of(Material.METAL).hardness(4.0f));
	
	//Block Items
	private static final Item TAMAHAGANE_STEEL_BLOCK_ITEM = new BlockItem(TAMAHAGANE_STEEL_BLOCK, new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item CRUCIBLE_STEEL_BLOCK_ITEM = new BlockItem(CRUCIBLE_STEEL_BLOCK, new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item TOOL_STEEL_BLOCK_ITEM = new BlockItem(TOOL_STEEL_BLOCK, new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item CARBON_STEEL_BLOCK_ITEM = new BlockItem(CARBON_STEEL_BLOCK, new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item FORGE_BLOCK_ITEM = new BlockItem(FORGE_BLOCK, new Item.Settings().group(GROUP_MAIN).maxCount(64));

	//Block Entities
	public static final BlockEntityType FORGE_BLOCK_ENTITY = BlockEntityType.Builder.create(ForgeBlockEntity::new, FORGE_BLOCK).build(null);

	//Steel Crafting Compnents
	private static final Item RICH_IRON_SAND = new IronSandItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item POOR_IRON_SAND = new IronSandItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item RICH_IRON_SLAG = new SlagItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item POOR_IRON_SLAG = new SlagItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item TAMAHAGANE_STEEL = new TamahaganeSteelItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item CRUCIBLE_STEEL = new CrucibleSteelItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item TOOL_STEEL = new ToolSteelItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));
	private static final Item CARBON_STEEL = new CarbonSteelItem(new Item.Settings().group(GROUP_MAIN).maxCount(64));

	//Tamahagane Steel Tools
	public static final ToolItem TAMAHAGANE_STEEL_SHOVEL = new ModShovelItem(ModToolMaterials.TAMAHAGANE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TAMAHAGANE_STEEL_PICKAXE = new ModPickaxeItem(ModToolMaterials.TAMAHAGANE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TAMAHAGANE_STEEL_AXE = new ModAxeItem(ModToolMaterials.TAMAHAGANE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TAMAHAGANE_STEEL_HOE = new ModHoeItem(ModToolMaterials.TAMAHAGANE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	
	//Crucible Steel Tools
	public static final ToolItem CRUCIBLE_STEEL_SHOVEL = new ModShovelItem(ModToolMaterials.CRUCIBLE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CRUCIBLE_STEEL_PICKAXE = new ModPickaxeItem(ModToolMaterials.CRUCIBLE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CRUCIBLE_STEEL_AXE = new ModAxeItem(ModToolMaterials.CRUCIBLE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CRUCIBLE_STEEL_HOE = new ModHoeItem(ModToolMaterials.CRUCIBLE_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	
	//Tool Steel Tools
	public static final ToolItem TOOL_STEEL_SHOVEL = new ModShovelItem(ModToolMaterials.TOOL_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TOOL_STEEL_PICKAXE = new ModPickaxeItem(ModToolMaterials.TOOL_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TOOL_STEEL_AXE = new ModAxeItem(ModToolMaterials.TOOL_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem TOOL_STEEL_HOE = new ModHoeItem(ModToolMaterials.TOOL_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));

	//Carbon Steel Tools
	public static final ToolItem CARBON_STEEL_SHOVEL = new ModShovelItem(ModToolMaterials.CARBON_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CARBON_STEEL_PICKAXE = new ModPickaxeItem(ModToolMaterials.CARBON_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CARBON_STEEL_AXE = new ModAxeItem(ModToolMaterials.CARBON_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));
	public static final ToolItem CARBON_STEEL_HOE = new ModHoeItem(ModToolMaterials.CARBON_STEEL, 2, -2.4F, new Item.Settings().group(GROUP_MAIN));

	//Weapons (Temporary)
	public static final ToolItem TAMAHAGANE_STEEL_ARMING_SWORD = new ModSwordItem(ModToolMaterials.TAMAHAGANE_STEEL, 7, -2.4F, new Item.Settings().group(GROUP_WEAPONS));
	public static final ToolItem CRUCIBLE_STEEL_ARMING_SWORD = new ModSwordItem(ModToolMaterials.CRUCIBLE_STEEL, 7, -2.4F, new Item.Settings().group(GROUP_WEAPONS));
	public static final ToolItem TOOL_STEEL_ARMING_SWORD = new ModSwordItem(ModToolMaterials.TOOL_STEEL, 7, -2.4F, new Item.Settings().group(GROUP_WEAPONS));
	public static final ToolItem CARBON_STEEL_ARMING_SWORD = new ModSwordItem(ModToolMaterials.CARBON_STEEL, 7, -2.4F, new Item.Settings().group(GROUP_WEAPONS));

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		///////////////////
		/// Object Registry

		//Screen Handlers
		ScreenHandlerRegistry.registerSimple(new Identifier(MODID, "forge"), FORGE_FURNACE_SCREEN_HANDLER);

		//Forge Recipes
		Registry.register(Registry.RECIPE_TYPE, new Identifier(MODID, "forge"), FORGE_RECIPE_TYPE);

		//Blocks
		Registry.register(Registry.BLOCK, new Identifier(MODID, "tamahagane_steel_block"), TAMAHAGANE_STEEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "crucible_steel_block"), CRUCIBLE_STEEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "tool_steel_block"), TOOL_STEEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "carbon_steel_block"), CARBON_STEEL_BLOCK);
		Registry.register(Registry.BLOCK, new Identifier(MODID, "forge"), FORGE_BLOCK);
		
		//Block Items
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_block"), TAMAHAGANE_STEEL_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_block"), CRUCIBLE_STEEL_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_block"), TOOL_STEEL_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_block"), CARBON_STEEL_BLOCK_ITEM);
		Registry.register(Registry.ITEM, new Identifier(MODID, "forge"), FORGE_BLOCK_ITEM);

		//BlockEntity
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(MODID, "forge"), FORGE_BLOCK_ENTITY);

		// Crafting Components
		Registry.register(Registry.ITEM, new Identifier(MODID, "rich_iron_sand"), RICH_IRON_SAND);
		Registry.register(Registry.ITEM, new Identifier(MODID, "poor_iron_sand"), POOR_IRON_SAND);
		Registry.register(Registry.ITEM, new Identifier(MODID, "rich_iron_slag"), RICH_IRON_SLAG);
		Registry.register(Registry.ITEM, new Identifier(MODID, "poor_iron_slag"), POOR_IRON_SLAG);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel"), TAMAHAGANE_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel"), CRUCIBLE_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel"), TOOL_STEEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel"), CARBON_STEEL);
		
		//Tamahagane Steel Tools
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_shovel"), TAMAHAGANE_STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_pickaxe"), TAMAHAGANE_STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_axe"), TAMAHAGANE_STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_hoe"), TAMAHAGANE_STEEL_HOE);
		
		//Crucible Steel Tools
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_shovel"), CRUCIBLE_STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_pickaxe"), CRUCIBLE_STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_axe"), CRUCIBLE_STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_hoe"), CRUCIBLE_STEEL_HOE);
		
		//Tool Steel Tools
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_shovel"), TOOL_STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_pickaxe"), TOOL_STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_axe"), TOOL_STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_hoe"), TOOL_STEEL_HOE);
		
		//Carbon Steel Tools
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_shovel"), CARBON_STEEL_SHOVEL);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_pickaxe"), CARBON_STEEL_PICKAXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_axe"), CARBON_STEEL_AXE);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_hoe"), CARBON_STEEL_HOE);
		

		//Weapons (Temporary)
		Registry.register(Registry.ITEM, new Identifier(MODID, "tamahagane_steel_arming_sword"), TAMAHAGANE_STEEL_ARMING_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "crucible_steel_arming_sword"), CRUCIBLE_STEEL_ARMING_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "tool_steel_arming_sword"), TOOL_STEEL_ARMING_SWORD);
		Registry.register(Registry.ITEM, new Identifier(MODID, "carbon_steel_arming_sword"), CARBON_STEEL_ARMING_SWORD);


		///////////////////
		/// Debug

		System.out.println("Hello Fabric world!");
	}
}
