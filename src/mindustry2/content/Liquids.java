package mindustry2.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class Liquids implements ContentList {
	public static Liquid acid;

	@Override
	public void load() {
		acid = new Liquid("acid", StatusEffects.corroded.color) {{
			heatCapacity = 0.1f;
			alwaysUnlocked = true;
			effect = StatusEffects.corroded;
		}};
	}
}
