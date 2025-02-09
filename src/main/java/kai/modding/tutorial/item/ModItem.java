package kai.modding.tutorial.item;

import kai.modding.tutorial.Tutorialmod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    public  static final Item MAGIC_DUST = registerItem("magic_dust", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Tutorialmod.MOD_ID, name), item);
    }

    public static void registerModItems () {
        Tutorialmod.LOGGER.info("Registering Mod Item for " + Tutorialmod.MOD_ID);

        //เป็นการจัดให้อยู่ในกลุ่ม item กลุ่มไหน ในที่นี้บอก ItemGroups.INGREDIENTS <-- ให้อยู่ในกลุ่ม Ingredients
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(MAGIC_DUST);
        });
    }
}
