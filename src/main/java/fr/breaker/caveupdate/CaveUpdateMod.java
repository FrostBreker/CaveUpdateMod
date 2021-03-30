package fr.breaker.caveupdate;

import fr.breaker.caveupdate.init.ModBlock;
import fr.breaker.caveupdate.init.ModItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

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

    @Override
    public void onInitialize()
    {
        ModItem.registerAll();
        ModBlock.INSTANCE.registerAll();

        RegistryKey<ConfiguredFeature<?, ?>> oreCopperOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_WORLDGEN,
                new Identifier("caveupdate", "ore_copper_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreCopperOverworld.getValue(), ORE_COPPER_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreCopperOverworld);
    }
}
