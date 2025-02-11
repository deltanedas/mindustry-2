package mindustry2.content;

// FIXME: no annotations jar
//import mindustry.annotations.Annotations.*;
import mindustry.ctype.*;
import mindustry.type.*;
import mindustry.type.weapons.*;

public class UnitTypes {
/*	// mech
	public static @EntityDef(value = {Unitc.class}, legacy = true) UnitType worm;

	@Override
	public void load() {
		worm = new UnitType("worm") {{
			speed = 0.8f;
			hitSize = 8f;
			health = 150;
			weapons.add(new Weapon("large-weapon") {{
				reload = 20f;
				x = 4f;
				y = 2f;
				top = false;
				ejectEffect = Fx.casing1;
				bullet = Bullets.standardIron;
			}});
		}};
	}*/
	public static UnitType worm;

	public static void load() {
		mindustry.content.UnitTypes.load();
		worm = mindustry.content.UnitTypes.dagger;
	}
}
