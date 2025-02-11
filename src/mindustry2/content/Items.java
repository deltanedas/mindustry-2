package mindustry2.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class Items {
	public static Item zinc, iron, diamond, sand, chrome, steel;

	public static void load() {
		zinc = new Item("zinc", Color.valueOf("aaaa7f")) {{
			hardness = 1;
			cost = 0.5f;
			alwaysUnlocked = true;
		}};

		iron = new Item("iron", Color.valueOf("af644f")) {{
			hardness = 2;
			cost = 0.6f;
			alwaysUnlocked = true;
		}};

		diamond = new Item("diamond", Color.valueOf("9ceaea")) {{
			hardness = 2;
			cost = 0.7f;
		}};

		sand = new Item("sand", Color.valueOf("e58027")) {{
			alwaysUnlocked = true;
			lowPriority = true;
		}};

		chrome = new Item("chrome", Color.valueOf("c6c6c6")) {{
			cost = 0.8f;
		}};

		steel = new Item("steel", Color.valueOf("a1a9b0")) {{
			cost = 1f;
		}};
	}
}
