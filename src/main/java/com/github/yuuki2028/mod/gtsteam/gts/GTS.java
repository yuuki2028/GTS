package com.github.yuuki2028.mod.gtsteam.gts;

import gregtech.api.GregTechAPI;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;


@Mod(
        modid = GTS.MOD_ID,
        name = GTS.MOD_NAME,
        version = GTS.VERSION

)
@SuppressWarnings("WeakerAccess")
public class GTS {

    public static final String MOD_ID = "gts";
    public static final String MOD_NAME = "GTS";
    public static final String VERSION = "2019.3-1.3.2";

    /**
     * This is the instance of your mod as created by Forge. It will never be null.
     */
    @Mod.Instance(MOD_ID)
    public static GTS INSTANCE;

    /**
     * This is the first initialization event. Register tile entities here.
     * The registry events below will have fired prior to entry to this method.
     */
    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
    }

    /**
     * This is the second initialization event. Register custom recipes
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GregTechAPI.registerMetaTileEntity(2551, new SteamImprovedCoalBoiler(gregtechId("steam_boiler_improved_coal_bronze"), false));
        GregTechAPI.registerMetaTileEntity(2552, new SteamImprovedCoalBoiler(gregtechId("steam_boiler_improved_coal_steel"), true));
        GregTechAPI.registerMetaTileEntity(2553, new SteamHighImprovedCoalBoiler(gregtechId("steam_boiler_high_improved_coal_bronze"), false));
        GregTechAPI.registerMetaTileEntity(2554, new SteamHighImprovedCoalBoiler(gregtechId("steam_boiler_high_improved_coal_steel"), true));
        GregTechAPI.registerMetaTileEntity(2555,new SteamHumidification(gregtechId("steam_Humidification"), false));
        GregTechAPI.registerMetaTileEntity(2556,new SteamHumidification(gregtechId("steam_high_Humidification"), true));
        GregTechAPI.registerMetaTileEntity(2557,new SteamBowling(gregtechId("steam_bowling"), false));
        GregTechAPI.registerMetaTileEntity(2558,new SteamBowling(gregtechId("steam_high_bowling"), true));

        GTSReciepMaps.BOWLING_RECIPES.recipeBuilder().EUt(100).duration(100)
                .fluidInputs(new FluidStack(FluidRegistry.WATER,200))
                .chancedOutput(new ItemStack(net.minecraft.init.Blocks.COBBLESTONE,1),8000,0)
                .chancedOutput(OreDictionary.getOres("oreCopper").get(0),1200,0)
                .chancedOutput(OreDictionary.getOres("oreTin").get(0),1000,0)
                .chancedOutput(OreDictionary.getOres("oreIron").get(0),400,+10)
                .chancedOutput(OreDictionary.getOres("oreSilver").get(0),100,+10)
        .buildAndRegister();
    }
    private static ResourceLocation gregtechId(String name) {
        return new ResourceLocation(GTS.MOD_ID,name);
    }
    /**
     * This is the final initialization event. Register actions from other mods here
     */
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {

    }

    /**
     * Forge will automatically look up and bind blocks to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Blocks {
      /*
          public static final MySpecialBlock mySpecialBlock = null; // placeholder for special block below
      */
    }

    /**
     * Forge will automatically look up and bind items to the fields in this class
     * based on their registry name.
     */
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class Items {
      /*
          public static final ItemBlock mySpecialBlock = null; // itemblock for the block above
          public static final MySpecialItem mySpecialItem = null; // placeholder for special item below
      */
    }

    /**
     * This is a special class that listens to registry events, to allow creation of mod blocks and items at the proper time.
     */
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        /**
         * Listen for the register event for creating custom items
         */
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
           /*
             event.getRegistry().register(new ItemBlock(Blocks.myBlock).setRegistryName(MOD_ID, "myBlock"));
             event.getRegistry().register(new MySpecialItem().setRegistryName(MOD_ID, "mySpecialItem"));
            */
        }

        /**
         * Listen for the register event for creating custom blocks
         */
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
           /*
             event.getRegistry().register(new MySpecialBlock().setRegistryName(MOD_ID, "mySpecialBlock"));
            */
        }
    }
    /* EXAMPLE ITEM AND BLOCK - you probably want these in separate files
    public static class MySpecialItem extends Item {

    }

    public static class MySpecialBlock extends Block {

    }
    */
}
