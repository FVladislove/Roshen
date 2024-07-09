package com.elis.roshen.item;

import com.elis.roshen.Roshen;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import eu.pb4.polymer.core.api.item.PolymerItemUtils;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item POLYMER_BDJILKA = registerItem("bdjilka",
            new BdjilkaPolymerItem(new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .alwaysEdible()
                            .snack()
                            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 15*20, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15*20, 1), 1.0f)
                            .build())));


    private static void addItemsToFoodAndDrinkTabItemGroup(FabricItemGroupEntries entries){
        entries.add(POLYMER_BDJILKA);
    }

    private static Item registerItem(String name, Item item){
        Roshen.LOGGER.info("Registering {} item", name);
        return Registry.register(Registries.ITEM, Identifier.of(Roshen.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Roshen.LOGGER.info("Registering Mod items for " + Roshen.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkTabItemGroup);

        ItemGroup.Builder builder = PolymerItemGroupUtils.builder();
        builder.icon(() -> new ItemStack(ModItems.POLYMER_BDJILKA, 1));
        builder.displayName(Text.of("Poroshenko Polymer"));

        builder.entries(((displayContext, entries) -> entries.add(ModItems.POLYMER_BDJILKA)));

        ItemGroup polymerGroup = builder.build();
        PolymerItemGroupUtils.registerPolymerItemGroup(Identifier.of(Roshen.MOD_ID), polymerGroup);
    }
}
