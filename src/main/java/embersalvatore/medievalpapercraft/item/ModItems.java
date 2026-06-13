package embersalvatore.medievalpapercraft.item;

import embersalvatore.medievalpapercraft.MedievalPapercraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MedievalPapercraft.MODID);

    //public static final RegistryObject<Item> LOVELY_ITEM = ITEMS.register("lovely_item", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
