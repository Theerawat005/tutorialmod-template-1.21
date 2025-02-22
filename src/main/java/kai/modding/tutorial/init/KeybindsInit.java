package kai.modding.tutorial.init;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeybindsInit {
    public static final String CATEGORY = "Mod Tutorial"; // หมวดหมู่ใน Settings
    public static final String SKILLS_KEY = "Skills"; // ชื่อคีย์

    // สร้าง KeyBinding (กด J เพื่อเปิด JobsScreen)
    public static final KeyBinding OPEN_SKILLS_KEY = new KeyBinding(
            SKILLS_KEY, // ชื่อ Key
            InputUtil.Type.KEYSYM, // ประเภทปุ่ม (KEYSYM = ปุ่มคีย์บอร์ด)
            GLFW.GLFW_KEY_J, // ปุ่ม J
            CATEGORY // หมวดหมู่
    );

    public static void register() {
        KeyBindingHelper.registerKeyBinding(OPEN_SKILLS_KEY);
    }
}
