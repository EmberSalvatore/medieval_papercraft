package embersalvatore.medievalpapercraft.tabs;

import embersalvatore.medievalpapercraft.MedievalPapercraft;
import embersalvatore.medievalpapercraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class CreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MedievalPapercraft.MODID);

    public static final RegistryObject<CreativeModeTab> MEDIEVAL_PAPERCRAFT_MAIN_TAB = CREATIVE_MODE_TABS.register("medieval_papercraft_main_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetab.medieval_papercraft_main_tab"))
            .icon(() -> new ItemStack(ModBlocks.BOOK_PRESS.get()))
            .displayItems((pParameters, pOutput) -> {

                pOutput.accept(ModBlocks.BOOK_PRESS.get());

            })
            .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
