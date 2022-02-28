package mindustry2.content;

import mindustry.ctype.*;
import mindustry.entities.bullet.*;

public class Bullets implements ContentList {
	public static BulletType

	// standard
	standardIron;

	@Override
	public void load() {
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
