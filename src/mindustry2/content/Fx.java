package mindustry2.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import mindustry.entities.*;

import static arc.graphics.g2d.Draw.*;

public class Fx {
	public static final Effect

	// wet, but acid
	corroded = new Effect(80f, e -> {
		color(Liquids.acid.color);
		alpha(Mathf.clamp(e.fin() * 2f));

		Fill.circle(e.x, e.y, e.fout());
	}),

	casing1 = mindustry.content.Fx.casing1,
	shootSmall = mindustry.content.Fx.shootSmall,
	shootSmallSmoke = mindustry.content.Fx.shootSmallSmoke;
}
