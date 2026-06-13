package embersalvatore.medievalpapercraft.block.entity;

import embersalvatore.medievalpapercraft.MedievalPapercraft;
import embersalvatore.medievalpapercraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MedievalPapercraft.MODID);

    public static final RegistryObject<BlockEntityType<BookPressBlockEntity>> BOOK_PRESS_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("book_press_block_entity", () -> BlockEntityType.Builder.of(BookPressBlockEntity::new,
                    ModBlocks.BOOK_PRESS.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
