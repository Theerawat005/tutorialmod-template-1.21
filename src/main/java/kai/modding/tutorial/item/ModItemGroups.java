package kai.modding.tutorial.item;

import kai.modding.tutorial.Tutorialmod;
import kai.modding.tutorial.block.ModBlock;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MAGIC_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Tutorialmod.MOD_ID, "magic_items"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItem.MAGIC_DUST))
                    .displayName(Text.translatable("itemgroup.tutorialmod.magic_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItem.MAGIC_DUST);
                        entries.add(ModItem.RAW_MAGIC_ORE);
                        entries.add(ModItem.MAGIC_ORE_INGOT);
                    }).build());

    public static final ItemGroup MAGIC_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Tutorialmod.MOD_ID, "magic_blocks"), FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlock.MAGIC_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.magic_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlock.MAGIC_ORE);
                        entries.add(ModBlock.MAGIC_BLOCK);
                    }).build());


    public static void registerItemGroups() {
        Tutorialmod.LOGGER.info("Registering Item Groups for" + Tutorialmod.MOD_ID);
    }
}
