package org.shsts.tinactory.content.network;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import org.shsts.tinactory.core.common.SmartEntityBlock;
import org.shsts.tinycorelib.api.registrate.entry.IBlockEntityType;
import org.shsts.tinycorelib.api.registrate.entry.IMenuType;

import java.util.function.Supplier;

import static org.shsts.tinactory.content.network.MachineBlock.WORKING;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class FixedBlock extends SmartEntityBlock {
    public FixedBlock(Properties properties, Supplier<IBlockEntityType> entityType,
        @Nullable IMenuType menu) {
        super(properties.strength(2f, 6f), entityType, menu);
    }

    @Override
    protected BlockState createDefaultBlockState() {
        return super.createDefaultBlockState()
            .setValue(WORKING, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WORKING);
    }
}
