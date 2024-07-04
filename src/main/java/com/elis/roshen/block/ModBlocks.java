package com.elis.roshen.block;

import com.elis.roshen.Roshen;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block Poroshenko = registerBlock("poroshenko_block",
            new Block(AbstractBlock.Settings.copy(Blocks.OBSIDIAN).sounds(BlockSoundGroup.ANVIL)));

    private static Block registerBlock(String name, Block block){
        Roshen.LOGGER.info("Registering {} block", name);

        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Roshen.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM,
                Identifier.of(Roshen.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    private static void addBlocksToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries){
        entries.add(Poroshenko);
    }
    public static void registerModBlocks(){
        Roshen.LOGGER.info("Registering ModBlocks blocks for " + Roshen.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addBlocksToBuildingBlocksTabItemGroup);
    }
}
