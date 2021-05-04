package io.github.fourinchknife.smv;

import net.devtech.arrp.api.RRPCallback;
import net.devtech.arrp.api.RuntimeResourcePack;
import net.devtech.arrp.json.lang.JLang;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;

import java.util.Optional;

public class FourInchKnifeSMV implements ModInitializer {
	public static final RuntimeResourcePack RESOURCE_PACK = RuntimeResourcePack.create("fourinchknifesmv:test");
	@Override
	public void onInitialize() {
		final String modID = "fourinchknife-smv";
		final Optional<ModContainer> container =
				FabricLoader.getInstance().getModContainer(modID);
		String version = container.map(
				modContainer -> modContainer.getMetadata().getVersion().getFriendlyString()
		).orElse("???");

		JLang translation = JLang.lang();
		translation.entry("fourinchknifesmv.version",version);
		translation.entry("fourinchknifesmv.title","FourInchKnife's Mods v"+version);
		RESOURCE_PACK.addLang(RuntimeResourcePack.id("en_us"), translation);
		RRPCallback.EVENT.register(a -> a.add(RESOURCE_PACK));
	}
}
