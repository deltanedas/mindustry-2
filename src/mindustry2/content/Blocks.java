package mindustry2.content;

import arc.graphics.*;
import mindustry.*;
import mindustry.ctype.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.sandbox.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.meta.*;

import static mindustry.type.ItemStack.*;

public class Blocks {
	public static Block
		// environment
		air, spawn, cliff, acid, deepAcid, sandAcid, sand, sandWall,
		shale, shaleWall, ice, iceWall, moss, dirt, dacite, stone, salt,
		basalt, hotrock, magmarock,

		// ores
		oreZinc, oreIron, oreDiamond, oreChrome,

		// crafting
		siliconSmelter, blastFurnace,

		// sandbox
		powerSource, powerVoid, itemSource, itemVoid, liquidSource, liquidVoid, payloadSource, payloadVoid, illuminator,

		// defense
		zincWall, zincWallLarge, steelWall, steelWallLarge, door, doorLarge,

		// transport
		duct, steelDuct, junction, itemBridge, router, overflowGate,

		// power
		solarPanel, largeSolarPanel,
		battery, batteryLarge, powerNode, powerNodeLarge,

		// production
		mechanicalDrill, pneumaticDrill,

		// storage
		coreAnuke, container, vault, unloader,

		// turrets
		duo;

	public static void load() {
		// environment
		air = new AirBlock("air");
		spawn = new SpawnBlock("spawn");
		cliff = new Cliff("cliff") {{
			inEditor = false;
			saveData = true;
		}};

		// Register build blocks
		// no reference is needed here since they can be looked up by name later
		for (int i = 1; i <= Vars.maxBlockSize; i++) {
			new ConstructBlock(i);
		}

		acid = new Floor("shallow-acid", 0) {{
			speedMultiplier = 0.75f;
			liquidDrop = Liquids.acid;
			isLiquid = true;
			status = StatusEffects.corroded;
			statusDuration = 90f;
			cacheLayer = CacheLayer.water;
			albedo = 0.9f;
		}};

		deepAcid = new Floor("deep-acid", 0) {{
			speedMultiplier = 0.3f;
			variants = 0;
			liquidDrop = Liquids.acid;
			liquidMultiplier = 1.5f;
			isLiquid = true;
			status = StatusEffects.corroded;
			statusDuration = 120f;
			drownTime = 200f;
			cacheLayer = CacheLayer.water;
			albedo = 0.9f;
		}};

		sandAcid = new ShallowLiquid("sand-acid") {{
			speedMultiplier = 0.9f;
			statusDuration = 50f;
			albedo = 0.9f;
		}};

		sand = new Floor("sand") {{
			itemDrop = Items.sand;
			playerUnmineable = true;
		}};

		sandWall = new StaticWall("sand-wall") {{
			variants = 2;
			sandAcid.asFloor().wall = acid.asFloor().wall = deepAcid.asFloor().wall = this;
		}};

		shale = new Floor("shale") {{
			variants = 3;
			attributes.set(Attribute.oil, 1.6f);
		}};

		shaleWall = new StaticWall("shale-wall");

		ice = new Floor("ice") {{
			dragMultiplier = 0.35f;
			speedMultiplier = 0.9f;
			attributes.set(Attribute.water, 0.4f);
			albedo = 0.65f;
		}};


		iceWall = new StaticWall("ice-wall") {{
			albedo = 0.6f;
		}};

		moss = new Floor("moss") {{
			variants = 3;
			attributes.set(Attribute.spores, 0.15f);
		}};

		dirt = new Floor("dirt");

		dacite = new Floor("dacite");

		stone = new Floor("stone");

		salt = new Floor("salt") {{
			variants = 0;
			attributes.set(Attribute.water, -0.3f);
			attributes.set(Attribute.oil, 0.3f);
		}};

		basalt = new Floor("basalt") {{
			attributes.set(Attribute.water, -0.25f);
		}};

		hotrock = new Floor("hotrock") {{
			attributes.set(Attribute.heat, 0.5f);
			attributes.set(Attribute.water, -0.5f);
			blendGroup = basalt;

			emitLight = true;
			lightRadius = 30f;
			lightColor = Color.orange.cpy().a(0.15f);
		}};

		magmarock = new Floor("magmarock") {{
			attributes.set(Attribute.heat, 0.75f);
			attributes.set(Attribute.water, -0.75f);
			blendGroup = basalt;

			emitLight = true;
			lightRadius = 50f;
			lightColor = Color.orange.cpy().a(0.30f);
		}};

		// ores
		oreZinc = new OreBlock(Items.zinc) {{
			oreDefault = true;
			oreThreshold = 0.81f;
			oreScale = 23.47619f;
		}};

		oreIron = new OreBlock(Items.iron) {{
			oreDefault = true;
			oreThreshold = 0.828f;
			oreScale = 23.952381f;
		}};

		// storage
		coreAnuke = new CoreBlock("core-anuke") {{
			requirements(Category.effect, BuildVisibility.editorOnly, with(Items.zinc, 1000, Items.chrome, 800));
			alwaysUnlocked = true;

			unitType = UnitTypes.worm;
			health = 1100;
			itemCapacity = 4000;
			size = 3;

			unitCapModifier = 8;
		}};

		// overrides for menu
		mindustry.content.Blocks.oreCopper = oreZinc;
		mindustry.content.Blocks.oreLead = oreIron;
		mindustry.content.Blocks.oreScrap = oreZinc;
		mindustry.content.Blocks.oreCoal = oreIron;
		mindustry.content.Blocks.oreTitanium = oreZinc;
		mindustry.content.Blocks.oreThorium = oreIron;
	}
}
