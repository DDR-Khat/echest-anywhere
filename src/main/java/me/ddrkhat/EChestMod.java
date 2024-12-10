package me.ddrkhat;

import me.ddrkhat.commands.echest;
import net.fabricmc.api.DedicatedServerModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EChestMod implements DedicatedServerModInitializer
{
	public static final String MOD_ID = "echestanywhere";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitializeServer()
	{
		LOGGER.info("Loading");
		CommandRegistrationCallback.EVENT.register(echest::init);
	}
}