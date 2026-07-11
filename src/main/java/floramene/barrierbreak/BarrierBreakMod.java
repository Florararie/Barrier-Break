package floramene.barrierbreak;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BarrierBreakMod implements ModInitializer {
	public static final String MOD_ID = "barrierbreak";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Barrier is now instantly breakable in survival.");
	}
}
