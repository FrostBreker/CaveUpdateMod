package fr.breaker.caveupdate;

import fr.breaker.caveupdate.features.MyFeatures;
import fr.breaker.caveupdate.features.MyPiece;
import fr.breaker.caveupdate.init.ModBlock;
import fr.breaker.caveupdate.init.ModItem;
import fr.breaker.caveupdate.init.MyGenerator;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.structure.v1.FabricStructureBuilder;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.*;

public class CaveUpdateMod implements ModInitializer
{
    public static final String MODID = "caveupdate";

    private static ConfiguredFeature<?, ?> ORE_COPPER_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    ModBlock.COPPER_ORE.getDefaultState(),
                    9)) // vein size
            .decorate(Decorator.RANGE.configure(new RangeDecoratorConfig(
                    0,
                    0,
                    64)))
            .spreadHorizontally()
            .repeat(15); // number of veins per chunk

    public static final StructurePieceType MY_PIECE = MyPiece::new;
    private static final StructureFeature<DefaultFeatureConfig> MY_STRUCTURE = new MyFeatures(DefaultFeatureConfig.CODEC);
    private static final ConfiguredStructureFeature<?, ?> MY_CONFIGURED = MY_STRUCTURE.configure(DefaultFeatureConfig.DEFAULT);

    @Override
    public void onInitialize()
    {
        ModItem.registerAll();
        ModBlock.INSTANCE.registerAll();

        RegistryKey<ConfiguredFeature<?, ?>> oreCopperOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("caveupdate", "ore_copper_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCopperOverworld.getValue(), ORE_COPPER_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCopperOverworld);



        Registry.register(Registry.STRUCTURE_PIECE, new Identifier("caveupdate", "my_piece"), MY_PIECE);
        FabricStructureBuilder.create(new Identifier("caveupdate", "my_structure"), MY_STRUCTURE)
                .step(GenerationStep.Feature.SURFACE_STRUCTURES)
                .defaultConfig(32, 8, 12345)
                .adjustsSurface()
                .register();

        RegistryKey<ConfiguredStructureFeature<?, ?>> myConfigured = RegistryKey.of(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN,
                new Identifier("caveupdate", "my_structure"));
        BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_STRUCTURE_FEATURE, myConfigured.getValue(), MY_CONFIGURED);

        BiomeModifications.addStructure(BiomeSelectors.all(), myConfigured);
    }
}
