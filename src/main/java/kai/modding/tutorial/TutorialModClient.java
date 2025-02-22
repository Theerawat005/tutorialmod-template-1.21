package kai.modding.tutorial;

import kai.modding.tutorial.init.KeybindsInit;
import kai.modding.tutorial.screen.SkillsScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

public class TutorialModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // ลงทะเบียน Keybinding
        KeybindsInit.register();

        // ตรวจจับว่าผู้เล่นกดปุ่ม J หรือไม่
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if (KeybindsInit.OPEN_SKILLS_KEY.isPressed()) {
                if (minecraftClient.currentScreen == null){
                    minecraftClient.setScreen(new SkillsScreen(Text.of("Skills")));
                }
            }
        });
    }
}
