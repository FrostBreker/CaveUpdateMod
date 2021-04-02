package fr.breaker.caveupdate.init;

import fr.breaker.caveupdate.features.MyPiece;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePiece;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class MyGenerator
{
    private static final Identifier IGLOO_TOP = new Identifier("igloo/top");

    public static void addPieces(StructureManager manager, BlockPos pos, BlockRotation rotation, List<StructurePiece> pieces) {
        pieces.add(new MyPiece(manager, pos, IGLOO_TOP, rotation));
    }
}
