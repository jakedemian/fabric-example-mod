package com.example.item;

import com.example.ExampleMod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class ModItems {
    // Register the Glider item - modify this to use preRegistered item pattern
    public static final Item GLIDER = registerItem("glider");
    
    // Register an item
    private static Item registerItem(String name) {
        // Create the item key
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), 
            Identifier.of(ExampleMod.MOD_ID, name));
        
        // Create item settings with registry key
        Item.Settings settings = new Item.Settings().registryKey(itemKey);
        
        // Create and register the item
        Item item = new Item(settings);
        return Registry.register(Registries.ITEM, itemKey, item);
    }

    // Initialize the items and add them to item groups
    public static void initialize() {
        // Add Glider to the tools item group
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register(content -> content.add(GLIDER));
    }
} 