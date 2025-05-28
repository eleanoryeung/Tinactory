package org.shsts.tinactory.api.logistics;

import javax.annotation.ParametersAreNonnullByDefault;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Represent a collection of items without specific slots.
 * All these APIs ignores the stack limit of ItemStack.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public interface IItemCollection extends IPort {
    @Override
    default PortType type() {
        return PortType.ITEM;
    }

    /**
     * If this returns false, insertItem with the same stack must return the entire stack.
     */
    boolean acceptInput(ItemStack stack);

    /**
     * Returns the remaining items not inserted. The passed and returned ItemStack should be safely modified.
     */
    ItemStack insertItem(ItemStack stack, boolean simulate);

    /**
     * Returns the items taken. The passed and returned ItemStack should be safely modified.
     */
    ItemStack extractItem(ItemStack item, boolean simulate);

    /**
     * Extract any item and returns the items taken. The returned ItemStack should be safely modified.
     */
    ItemStack extractItem(int limit, boolean simulate);

    int getItemCount(ItemStack item);

    /**
     * DO NOT change the returned ItemStack.
     */
    Collection<ItemStack> getAllItems();

    void setItemFilter(List<? extends Predicate<ItemStack>> filters);

    void resetItemFilter();
}
