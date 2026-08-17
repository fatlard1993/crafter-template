package justfatlard.crafter_template;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements ModInitializer {
	public static final String MOD_ID = "crafter-template";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Guarded class load: CrafterTipRegistration names block-tip types.
		if (net.fabricmc.loader.api.FabricLoader.getInstance().isModLoaded("block-tip")) {
			justfatlard.crafter_template.integration.CrafterTipRegistration.register();
		}

		LOGGER.info("Crafters will now retain 1 item per slot");
	}
}
