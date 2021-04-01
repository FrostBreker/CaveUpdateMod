package fr.breaker.caveupdate.init;

import fr.breaker.caveupdate.CaveUpdateMod;
import fr.breaker.caveupdate.blocks.LightningRod;
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
    public static final Block BUDDING_AMETHYST = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool().strength(1.5f, 1.5f).breakInstantly().dropsNothing().nonOpaque());
    public static final Block CALCITE = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool().strength(0.75f, 0.75f));
    public static final Block AMETHYST_CLUSTER = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2).requiresTool().strength(1.5f, 1.5f).nonOpaque().luminance(5));
    public static final Block CANDLE = new Block(FabricBlockSettings.of(Material.STONE).strength(0.1f, 0.1f).luminance(12).nonOpaque());
    public static final Block TUFF = new Block(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 0).requiresTool().strength(1.5f, 6f));
    public static final Block LIGHTNING_ROD = new LightningRod(FabricBlockSettings.of(Material.BARRIER).breakByTool(FabricToolTags.PICKAXES, 1).requiresTool().strength(1.5f, 1.5f).nonOpaque());


    public void registerAll()
    {
        register(AMETHYST_BLOCK, new Identifier(CaveUpdateMod.MODID, "amethyst_block"));
        register(COPPER_ORE, new Identifier(CaveUpdateMod.MODID, "copper_ore"));
        register(COPPER_BLOCK, new Identifier(CaveUpdateMod.MODID, "copper_block"));
        register(BUDDING_AMETHYST, new Identifier(CaveUpdateMod.MODID, "budding_amethyst"));
        register(AMETHYST_CLUSTER, new Identifier(CaveUpdateMod.MODID, "amethyst_cluster"));
        register(CALCITE, new Identifier(CaveUpdateMod.MODID, "calcite"));
        register(CANDLE, new Identifier(CaveUpdateMod.MODID, "candle"));
        register(TUFF, new Identifier(CaveUpdateMod.MODID, "tuff"));
        register(LIGHTNING_ROD, new Identifier(CaveUpdateMod.MODID, "lightning_rod"));
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
