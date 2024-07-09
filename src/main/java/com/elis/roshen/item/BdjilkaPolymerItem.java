package com.elis.roshen.item;

import com.elis.roshen.Roshen;
import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BdjilkaPolymerItem extends Item implements PolymerItem {

    public BdjilkaPolymerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack itemStack, @Nullable Item.TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.of("Bjjjjjj!"));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.APPLE;
    }

    @Override
    public ItemStack getPolymerItemStack(ItemStack itemStack, TooltipType tooltipType, RegistryWrapper.WrapperLookup lookup, @Nullable ServerPlayerEntity player) {
        return PolymerItem.super.getPolymerItemStack(itemStack, tooltipType, lookup, player);
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player){
        return PolymerResourcePackUtils.requestModel(Items.APPLE,
                Identifier.of(Roshen.MOD_ID, "item/bdjilka"))
                .value();
    }
}
