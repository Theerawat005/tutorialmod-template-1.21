package kai.modding.tutorial.block;

import kai.modding.tutorial.Tutorialmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlock {
    public static final Block MAGIC_ORE = registerBlock("magic_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(4.0f, 4.0f)
                            .sounds(BlockSoundGroup.STONE)
                            .requiresTool()));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new Block(AbstractBlock.Settings.create().strength(5.0f,6.0f)
                    .sounds(BlockSoundGroup.METAL)
                    .requiresTool()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Tutorialmod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Tutorialmod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlock() {
        Tutorialmod.LOGGER.info("Registering Mod Block for "+ Tutorialmod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlock.MAGIC_ORE);
            fabricItemGroupEntries.add(ModBlock.MAGIC_BLOCK);
        });
    }
}
