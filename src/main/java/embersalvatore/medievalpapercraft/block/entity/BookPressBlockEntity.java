package embersalvatore.medievalpapercraft.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BookPressBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemStackHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch(slot){
                case 0 -> stack.getItem() == Items.INK_SAC;
                case 1 -> stack.getItem() == Items.PAPER;
                case 2 -> stack.getItem() == Items.LEATHER;
                default -> super.isItemValid(slot, stack);
            };
        }

    };

    private final static int INK_INPUT_SLOT = 0;
    private final static int PAPER_INPUT_SLOT = 0;
    private final static int LEATHER_INPUT_SLOT = 0;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 60;

    public BookPressBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.BOOK_PRESS_BLOCK_ENTITY.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch(pIndex){
                    case 0 -> BookPressBlockEntity.this.progress;
                    case 1 -> BookPressBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch(pIndex){
                    case 0 -> BookPressBlockEntity.this.progress = pValue;
                    case 1 -> BookPressBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemStackHandler.serializeNBT());

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemStackHandler.deserializeNBT(pTag.getCompound("inventory"));
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Bookpress");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return
    }
}
