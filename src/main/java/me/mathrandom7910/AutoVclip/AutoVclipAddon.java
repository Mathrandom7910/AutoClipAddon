package me.mathrandom7910.AutoVclip;


import me.mathrandom7910.AutoVclip.commands.AVClipCommand;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.commands.Commands;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AutoVclipAddon extends MeteorAddon {
	public static final Logger LOG = LoggerFactory.getLogger(AutoVclipAddon.class);

	@Override
	public void onInitialize() {
		LOG.info("Initializing Meteor Addon Template");

		// Required when using @EventHandler
		//MeteorClient.EVENT_BUS.registerLambdaFactory("meteordevelopment.addons.template", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));
		// Commands
		Commands.get().add(new AVClipCommand());
	}
}
