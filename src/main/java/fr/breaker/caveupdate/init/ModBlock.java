package fr.breaker.caveupdate.init;

import fr.breaker.caveupdate.CaveUpdateMod;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlock
{
    public static final ModBlock INSTANCE = new ModBlock();

    public static final Block AMETHYST_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(1.5f, 15f));
    public static final Block COPPER_ORE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool().strength(3f, 15f));
    public static final Block COPPER_BLOCK = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(1.5f, 15f));

    public void registerAll()
    {
        register(AMETHYST_BLOCK, new Identifier(CaveUpdateMod.MODID, "amethyst_block"));
        register(COPPER_ORE, new Identifier(CaveUpdateMod.MODID, "copper_ore"));
        register(COPPER_BLOCK, new Identifier(CaveUpdateMod.MODID, "copper_block"));
    }

    private void register(Block block, Identifier name)
    {
        Registry.register(Registry.BLOCK, name, block);
        createBlockItem(block, name);
    }

    private void createBlockItem(Block block, Identifier name)
    {
        Registry.register(Registry.ITEM, name, new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }
}
