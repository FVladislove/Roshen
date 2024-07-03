package com.elis.roshen.item;

import com.elis.roshen.Roshen;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item Bdjilka = registerItem("bdjilka",
            new Item(new Item.Settings()
                    .food(new FoodComponent.Builder()
                            .alwaysEdible()
                            .snack()
                            .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 15*20, 1), 1.0f)
                            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 15*20, 1), 1.0f)
                            .build())));


    private static void addItemsToFoodAndDrinkTabItemGroup(FabricItemGroupEntries entries){
        entries.add(Bdjilka);
    }

    private static Item registerItem(String name, Item item){
        Roshen.LOGGER.info("Registering" + name + " item");
        return Registry.register(Registries.ITEM, Identifier.of(Roshen.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Roshen.LOGGER.info("Registering Mod items for" + Roshen.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkTabItemGroup);
    }
}
