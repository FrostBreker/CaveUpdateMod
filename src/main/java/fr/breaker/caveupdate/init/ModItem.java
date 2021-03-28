package fr.breaker.caveupdate.init;

import fr.breaker.caveupdate.CaveUpdateMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItem
{
    public static final Item AMETHYST_SHARD = new Item(new Item.Settings().group(ItemGroup.MATERIALS));
    public static final Item COPPER_INGOT = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

    public static void registerAll()
    {
        Registry.register(Registry.ITEM, new Identifier(CaveUpdateMod.MODID, "copper_ingot"), COPPER_INGOT);
        Registry.register(Registry.ITEM, new Identifier(CaveUpdateMod.MODID, "amethyst_shard"), AMETHYST_SHARD);
    }
}
