package kai.modding.tutorial.mixin;


import kai.modding.tutorial.screen.SkillsScreen;
import kai.modding.tutorial.widget.SkillsButton;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.reflect.Constructor;

@Mixin(InventoryScreen.class)
public abstract class InventoryScreenMixin extends HandledScreen<PlayerScreenHandler> {

	public InventoryScreenMixin(PlayerScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}

	private static Identifier createIdentifier(String namespace, String path) {
		try {
			Constructor<Identifier> constructor = Identifier.class.getDeclaredConstructor(String.class, String.class);
			constructor.setAccessible(true);
			return constructor.newInstance(namespace, path);
		} catch (Exception e) {
			throw new RuntimeException("Failed to create Identifier", e);
		}
	}

	Identifier texture = createIdentifier("minecraft", "textures/item/iron_pickaxe.png");

	@Inject(method = "init", at =@At("TAIL"))
	private void onInit(CallbackInfo ci) {
		int buttonX = this.x - 20;
		int buttonY = this.y ;

		SkillsButton skillsButton = new SkillsButton(
				buttonX,
				buttonY,
				20,20,
				Text.of(""),
				button -> {
					MinecraftClient.getInstance().setScreen(new SkillsScreen(Text.of("")));
				},
				texture
		);
		this.addDrawableChild(skillsButton);
	}
}