package fr.breaker.caveupdate;

import fr.breaker.caveupdate.init.ModBlock;
import fr.breaker.caveupdate.init.ModItem;
import net.fabricmc.api.ModInitializer;

public class CaveUpdateMod implements ModInitializer
{
    public static final String MODID = "caveupdate";

    @Override
    public void onInitialize()
    {
        ModItem.registerAll();
        ModBlock.INSTANCE.registerAll();
    }
}
