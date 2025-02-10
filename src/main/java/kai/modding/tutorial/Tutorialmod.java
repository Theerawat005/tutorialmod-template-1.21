package kai.modding.tutorial;

import kai.modding.tutorial.block.ModBlock;
import kai.modding.tutorial.item.ModItem;
import kai.modding.tutorial.item.ModItemGroups;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// very important comment
public class Tutorialmod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItem.registerModItems();
		ModBlock.registerModBlock();
    }
}