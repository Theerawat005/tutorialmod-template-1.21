package kai.modding.tutorial.widget;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.lang.reflect.Constructor;

public class SkillsButton extends ButtonWidget {

    public SkillsButton(int x, int y, int width, int height, Text message, PressAction onPress, Identifier texture) {
        super(x, y, width, height, message, onPress, (button) -> Text.literal(""));
    }

    public static Identifier createIdentifier(String namespace, String path) {
        try {
            Constructor<Identifier> constructor = Identifier.class.getDeclaredConstructor(String.class, String.class);
            constructor.setAccessible(true);
            return constructor.newInstance(namespace, path);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create Identifier", e);
        }
    }

    Identifier texture = createIdentifier("minecraft", "textures/item/iron_pickaxe.png");


    @Override
    public void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        super.renderWidget(context, mouseX, mouseY, delta);
        // วาดไอคอนของปุ่ม
        context.drawTexture(texture, this.getX(),this.getY()
                , 0, 0, this.getWidth(), this.getHeight(),
                this.getWidth(), this.getHeight());

        // แสดง Tooltip เมื่อเอาเมาส์ไปชี้ที่ปุ่ม
        if (this.isHovered()) { // ตรวจสอบว่าตัวชี้เมาส์อยู่บนปุ่มหรือไม่
            context.drawTooltip(
                    MinecraftClient.getInstance().textRenderer,
                    Text.literal("Skill"), // ข้อความที่ต้องการให้แสดง
                    mouseX, mouseY
            );
        }
    }
}
