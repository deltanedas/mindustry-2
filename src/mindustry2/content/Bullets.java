package mindustry2.content;

import mindustry.ctype.*;
import mindustry.entities.bullet.*;

public class Bullets {
	public static BulletType

	// standard
	standardIron;

	public static void load() {
		standardIron = new BasicBulletType(2.5f, 9) {{
			width = 7f;
			height = 9f;
			lifetime = 60f;
			shootEffect = Fx.shootSmall;
			smokeEffect = Fx.shootSmallSmoke;
			ammoMultiplier = 2;
		}};
	}
}
