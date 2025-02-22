package kai.modding.tutorial.screen;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;
import java.lang.reflect.Constructor;

public class SkillsScreen extends Screen {

    private static Identifier createIdentifier(String namespace, String path) {
        try {
            Constructor<Identifier> constructor =
                    Identifier.class.getDeclaredConstructor(String.class, String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(namespace, path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Identifier", e);
        }
    }

    private static final Identifier JODS_BACKGROUND =
            createIdentifier("tutorialmod", "textures/gui/jobs_screen.png");
    private static final Identifier MINER_JOB =
            createIdentifier("minecraft", "textures/item/iron_pickaxe.png");
    private static final Identifier LUMBERJACK_JOB =
            createIdentifier("minecraft", "textures/item/iron_axe.png");

    private final int backgroundWidth = 256;
    private final int backgroundHeight = 256;
    private final int iconSize = 24;

    public SkillsScreen(Text title) {
        super(title);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        int designWidth = 256;
        int designHeight = 256;

        int offsetX = (this.width - designWidth) / 2;
        int offsetY = (this.height - designHeight) / 2;

        context.getMatrices().push(); // บันทึกสถานะของ MatrixStack
        context.getMatrices().translate(offsetX, offsetY, 0);

        // วาด Background ที่ตำแหน่งที่ต้องการในระบบพิกัด design
        context.drawTexture(JODS_BACKGROUND,
                0, 0,
                0, 0,
                backgroundWidth,
                backgroundHeight);

        context.drawCenteredTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                Text.literal("Skill"),
                designWidth / 2,
                (int)(designHeight * 0.3) - 95,
                0xFFFFFF
        );

        context.drawCenteredTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                Text.literal("Miner"),
                (int)(designWidth * 0.5) - 100,
                (int)(designHeight * 0.3) - 62,
                0xffd100
        );

        context.drawTexture(
                MINER_JOB,
                (int)(designWidth * 0.5) - 115,
                (int)(designHeight * 0.3) - 52,
                0, 0,
                iconSize, iconSize,
                iconSize, iconSize
        );

        // วาดข้อความและไอคอน Lumberjack
        context.drawCenteredTextWithShadow(
                MinecraftClient.getInstance().textRenderer,
                Text.literal("Lumberjack"),
                (int)(designWidth * 0.5) - 85,
                (int)(designHeight * 0.3) - 8,
                0xffd100
        );

        context.drawTexture(
                LUMBERJACK_JOB,
                (int)(designWidth * 0.5) - 115,
                (int)(designHeight * 0.3) + 3,
                0, 0,
                iconSize, iconSize,
                iconSize, iconSize
        );
        context.getMatrices().pop();
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == GLFW.GLFW_KEY_E || keyCode == GLFW.GLFW_KEY_J) {
            MinecraftClient.getInstance().setScreen(null);
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}
