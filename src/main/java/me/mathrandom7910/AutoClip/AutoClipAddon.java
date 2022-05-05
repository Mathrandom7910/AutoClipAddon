package me.mathrandom7910.AutoClip;


import me.mathrandom7910.AutoClip.commands.AVClipCommand;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoClipAddon extends MeteorAddon {
	public static final Logger LOG = LoggerFactory.getLogger(AutoClipAddon.class);

	@Override
	public void onInitialize() {
		LOG.info("Initializing Auto Clip addon");

		// Required when using @EventHandler
		//MeteorClient.EVENT_BUS.registerLambdaFactory("meteordevelopment.addons.template", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
		// Commands
		Commands.get().add(new AVClipCommand());
	}
}
