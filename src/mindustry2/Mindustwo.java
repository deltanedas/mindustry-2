package mindustry2;

import mindustry2.content.*;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.TechTree;
import mindustry.core.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.type.*;
import mindustry.ui.dialogs.*;

import arc.struct.Seq;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;

import static mindustry.content.TechTree.TechNode;

public class Mindustwo extends Mod {
	public Mindustwo() {
		Log.warn("Mindustry 2 loaded, expect death");

		Events.on(ClientLoadEvent.class, e -> {
			Log.info("Have @ things", Vars.ui.research.nodes.size);
			Vars.ui.research.nodes.clear();
			Time.runTask(10f, () -> {
				BaseDialog dialog = new BaseDialog("frog");
				dialog.cont.add("mindustry 2").row();
				dialog.cont.image(Core.atlas.find("mindustry-2-frog")).pad(20f).row();
				dialog.cont.button("I see", dialog::hide).size(100f, 50f);
				dialog.show();
			});
		});
	}

	@Override
	public void loadContent() {
		// mindustry
		Vars.content = new ContentLoader();
		TechTree.all.clear();

		// mindustry 2
		StatusEffects.load();
		Items.load();
		Liquids.load();
		Bullets.load();
		UnitTypes.load();
		Blocks.load();
		TechTree.roots = Seq.with(new TechNode(null, Blocks.coreAnuke, new ItemStack[] {}));

		// fix the menu renderer, everything is sand and acid
		mindustry.content.Blocks.air = Blocks.air;
		mindustry.content.Blocks.sand = Blocks.sand;
		mindustry.content.Blocks.shale = Blocks.sand;
		mindustry.content.Blocks.ice = Blocks.sand;
		mindustry.content.Blocks.moss = Blocks.sand;
		mindustry.content.Blocks.sandWall = Blocks.sandWall;
		mindustry.content.Blocks.shaleWall = Blocks.sandWall;
		mindustry.content.Blocks.iceWall = Blocks.sandWall;

		mindustry.content.Blocks.sporeMoss = Blocks.sand;
		mindustry.content.Blocks.stone = Blocks.basalt;
		mindustry.content.Blocks.salt = Blocks.basalt;
		mindustry.content.Blocks.sporeWall = Blocks.sandWall;
		mindustry.content.Blocks.sporePine = Blocks.sandWall;
		mindustry.content.Blocks.duneWall = Blocks.sandWall;
		mindustry.content.Blocks.stoneWall = Blocks.sandWall;
		mindustry.content.Blocks.saltWall = Blocks.sandWall;

		mindustry.content.Blocks.basalt = Blocks.basalt;
		mindustry.content.Blocks.hotrock = Blocks.hotrock;
		mindustry.content.Blocks.magmarock = Blocks.magmarock;

		mindustry.content.Blocks.darkPanel3 = Blocks.basalt;
		mindustry.content.Blocks.darkPanel4 = Blocks.basalt;
		mindustry.content.Blocks.darkMetal = Blocks.basalt;

		mindustry.content.Blocks.water = Blocks.acid;
		mindustry.content.Blocks.deepwater = Blocks.deepAcid;
		mindustry.content.Blocks.sandWater = Blocks.sandAcid;

		Seq<Block> ores = Vars.content.blocks().select(b -> b instanceof OreBlock);;
		Log.info("Ores: @", ores);
	}
}
