package ru.ICY.lamp;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;
import ru.ICY.lamp.IC2.TileEntities.*;
import ru.ICY.lamp.IC2.blocks.*;
import ru.ICY.lamp.Other.CreativeTab;

import java.io.File;

@Mod(
        modid = ModMain.MOD_ID,
        name = ModMain.MOD_NAME,
        version = ModMain.VERSION,
        dependencies = "required-after:ic2"
)
public class ModMain {
    public static final String MOD_ID = "lamp_addon";
    public static final String MOD_NAME = "EU lamp addon";
    public static final String VERSION = "1.0-SNAPSHOT";
    public static Logger logger = null;

    public static int miniLampCapacity=50;
    public static double miniLampInput=5;
    public static double miniLampLightLevel=0.5;

    public static int lampCapacity=100;
    public static double lampInput=10;
    public static double lampLightLevel=1;



    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger=event.getModLog();
        GameRegistry.registerTileEntity(LampICTileEntity.class,new ResourceLocation(MOD_ID,"LampTileEntity"));
        GameRegistry.registerTileEntity(MiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"MiniLampTileEntity"));

        GameRegistry.registerTileEntity(RedLampICTileEntity.class,new ResourceLocation(MOD_ID,"RedLampTileEntity"));
        GameRegistry.registerTileEntity(RedMiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"RedMiniLampTileEntity"));

        GameRegistry.registerTileEntity(BlueLampICTileEntity.class,new ResourceLocation(MOD_ID,"BlueLampTileEntity"));
        GameRegistry.registerTileEntity(BlueMiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"BlueMiniLampTileEntity"));

        GameRegistry.registerTileEntity(GreenLampICTileEntity.class,new ResourceLocation(MOD_ID,"GreenLampTileEntity"));
        GameRegistry.registerTileEntity(GreenMiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"GreenMiniLampTileEntity"));

        GameRegistry.registerTileEntity(YellowLampICTileEntity.class,new ResourceLocation(MOD_ID,"YellowLampTileEntity"));
        GameRegistry.registerTileEntity(YellowMiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"YellowMiniLampTileEntity"));

        GameRegistry.registerTileEntity(PurpleLampICTileEntity.class,new ResourceLocation(MOD_ID,"PurpleLampTileEntity"));
        GameRegistry.registerTileEntity(PurpleMiniLampICTileEntity.class,new ResourceLocation(MOD_ID,"PurpleMiniLampTileEntity"));

        Configuration config = new Configuration(new File("config/lamp_addon.cfg"));
        config.load();
        miniLampCapacity=config.get("MiniLamp","capacity",miniLampCapacity).getInt();
        lampCapacity=config.get("Lamp","capacity",lampCapacity).getInt();
        miniLampInput=config.get("MiniLamp","input",miniLampInput).getDouble();
        lampInput=config.get("Lamp","input",lampInput).getDouble();
        miniLampLightLevel=config.get("MiniLamp","light",miniLampLightLevel).getDouble();
        lampLightLevel=config.get("Lamp","light",lampLightLevel).getDouble();
        config.save();
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {}
    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {}
    public static final CreativeTab tab = new CreativeTab(
            "custom_tab1",
            Item.getItemFromBlock(net.minecraft.init.Blocks.BEDROCK).getDefaultInstance()
    );
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class CustomBlocks {
        public static final Block lamp_on = null;
        public static final Block lamp_off = null;
        public static final Block mini_lamp_on = null;
        public static final Block mini_lamp_off = null;

        public static final Block red_lamp_on = null;
        public static final Block red_lamp_off = null;
        public static final Block red_mini_lamp_on = null;
        public static final Block red_mini_lamp_off = null;

        public static final Block blue_lamp_on = null;
        public static final Block blue_lamp_off = null;
        public static final Block blue_mini_lamp_on = null;
        public static final Block blue_mini_lamp_off = null;

        public static final Block purple_lamp_on = null;
        public static final Block purple_lamp_off = null;
        public static final Block purple_mini_lamp_on = null;
        public static final Block purple_mini_lamp_off = null;

        public static final Block green_lamp_on = null;
        public static final Block green_lamp_off = null;
        public static final Block green_mini_lamp_on = null;
        public static final Block green_mini_lamp_off = null;

        public static final Block yellow_lamp_on = null;
        public static final Block yellow_lamp_off = null;
        public static final Block yellow_mini_lamp_on = null;
        public static final Block yellow_mini_lamp_off = null;
    }
    @GameRegistry.ObjectHolder(MOD_ID)
    public static class CusomItems {
        public static final Item lamp_on = null;
        public static final Item lamp_off = null;
        public static final Item mini_lamp_on = null;
        public static final Item mini_lamp_off = null;

        public static final Item red_lamp_on = null;
        public static final Item red_lamp_off = null;
        public static final Item red_mini_lamp_on = null;
        public static final Item red_mini_lamp_off = null;

        public static final Item blue_lamp_on = null;
        public static final Item blue_lamp_off = null;
        public static final Item blue_mini_lamp_on = null;
        public static final Item blue_mini_lamp_off = null;

        public static final Item purple_lamp_on = null;
        public static final Item purple_lamp_off = null;
        public static final Item purple_mini_lamp_on = null;
        public static final Item purple_mini_lamp_off = null;

        public static final Item green_lamp_on = null;
        public static final Item green_lamp_off = null;
        public static final Item green_mini_lamp_on = null;
        public static final Item green_mini_lamp_off = null;

        public static final Item yellow_lamp_on = null;
        public static final Item yellow_lamp_off = null;
        public static final Item yellow_mini_lamp_on = null;
        public static final Item yellow_mini_lamp_off = null;
    }
    @Mod.EventBusSubscriber
    public static class ObjectRegistryHandler {
        @SubscribeEvent
        public static void addBlocks(RegistryEvent.Register<Block> event) {
            event.getRegistry().registerAll(
                    //todo убрать лишнее из вкладки в креативе?
                    //todo прочность блоков и добыча
                    new LampBlock("lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new LampBlock("lamp_off", Material.GLASS, tab,0f),
                    new MiniLampBlock("mini_lamp_on",tab, (float) miniLampLightLevel),
                    new MiniLampBlock("mini_lamp_off",tab,0f),

                    new RedLampBlock("red_lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new RedLampBlock("red_lamp_off", Material.GLASS, tab,0f),
                    new RedMiniLampBlock("red_mini_lamp_on",tab, (float) miniLampLightLevel),
                    new RedMiniLampBlock("red_mini_lamp_off",tab,0f),

                    new BlueLampBlock("blue_lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new BlueLampBlock("blue_lamp_off", Material.GLASS, tab,0f),
                    new BlueMiniLampBlock("blue_mini_lamp_on",tab, (float) miniLampLightLevel),
                    new BlueMiniLampBlock("blue_mini_lamp_off",tab,0f),

                    new PurpleLampBlock("purple_lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new PurpleLampBlock("purple_lamp_off", Material.GLASS, tab,0f),
                    new PurpleMiniLampBlock("purple_mini_lamp_on",tab, (float) miniLampLightLevel),
                    new PurpleMiniLampBlock("purple_mini_lamp_off",tab,0f),

                    new GreenLampBlock("green_lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new GreenLampBlock("green_lamp_off", Material.GLASS, tab,0f),
                    new GreenMiniLampBlock("green_mini_lamp_on",tab, (float) miniLampLightLevel),
                    new GreenMiniLampBlock("green_mini_lamp_off",tab,0f),

                    new YellowLampBlock("yellow_lamp_on", Material.GLASS, tab, (float) lampLightLevel),
                    new YellowLampBlock("yellow_lamp_off", Material.GLASS, tab,0f),
                    new YellowMiniLampBlock("yellow_mini_lamp_on",tab, (float) miniLampLightLevel),
                    new YellowMiniLampBlock("yellow_mini_lamp_off",tab,0f)
            );
        }
        @SubscribeEvent
        public static void addItems(RegistryEvent.Register<Item> event) {
            event.getRegistry().registerAll(
                    getItemBlock(CustomBlocks.lamp_on),
                    getItemBlock(CustomBlocks.lamp_off),
                    getItemBlock(CustomBlocks.mini_lamp_on),
                    getItemBlock(CustomBlocks.mini_lamp_off),

                    getItemBlock(CustomBlocks.red_lamp_on),
                    getItemBlock(CustomBlocks.red_lamp_off),
                    getItemBlock(CustomBlocks.red_mini_lamp_on),
                    getItemBlock(CustomBlocks.red_mini_lamp_off),

                    getItemBlock(CustomBlocks.blue_lamp_on),
                    getItemBlock(CustomBlocks.blue_lamp_off),
                    getItemBlock(CustomBlocks.blue_mini_lamp_on),
                    getItemBlock(CustomBlocks.blue_mini_lamp_off),

                    getItemBlock(CustomBlocks.green_lamp_on),
                    getItemBlock(CustomBlocks.green_lamp_off),
                    getItemBlock(CustomBlocks.green_mini_lamp_on),
                    getItemBlock(CustomBlocks.green_mini_lamp_off),

                    getItemBlock(CustomBlocks.purple_lamp_on),
                    getItemBlock(CustomBlocks.purple_lamp_off),
                    getItemBlock(CustomBlocks.purple_mini_lamp_on),
                    getItemBlock(CustomBlocks.purple_mini_lamp_off),

                    getItemBlock(CustomBlocks.yellow_lamp_on),
                    getItemBlock(CustomBlocks.yellow_lamp_off),
                    getItemBlock(CustomBlocks.yellow_mini_lamp_on),
                    getItemBlock(CustomBlocks.yellow_mini_lamp_off)
            );
        }
        @SubscribeEvent
        public static void registerModels(ModelRegistryEvent event) {
            ModelLoader.setCustomModelResourceLocation(CusomItems.lamp_off, 0, new ModelResourceLocation(CusomItems.lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.lamp_on, 0, new ModelResourceLocation(CusomItems.lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.mini_lamp_on, 0, new ModelResourceLocation(CusomItems.mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.mini_lamp_off, 0, new ModelResourceLocation(CusomItems.mini_lamp_off.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(CusomItems.red_lamp_off, 0, new ModelResourceLocation(CusomItems.red_lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.red_lamp_on, 0, new ModelResourceLocation(CusomItems.red_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.red_mini_lamp_on, 0, new ModelResourceLocation(CusomItems.red_mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.red_mini_lamp_off, 0, new ModelResourceLocation(CusomItems.red_mini_lamp_off.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(CusomItems.blue_lamp_off, 0, new ModelResourceLocation(CusomItems.blue_lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.blue_lamp_on, 0, new ModelResourceLocation(CusomItems.blue_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.blue_mini_lamp_on, 0, new ModelResourceLocation(CusomItems.blue_mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.blue_mini_lamp_off, 0, new ModelResourceLocation(CusomItems.blue_mini_lamp_off.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(CusomItems.green_lamp_off, 0, new ModelResourceLocation(CusomItems.green_lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.green_lamp_on, 0, new ModelResourceLocation(CusomItems.green_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.green_mini_lamp_on, 0, new ModelResourceLocation(CusomItems.green_mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.green_mini_lamp_off, 0, new ModelResourceLocation(CusomItems.green_mini_lamp_off.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(CusomItems.purple_lamp_off, 0, new ModelResourceLocation(CusomItems.purple_lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.purple_lamp_on, 0, new ModelResourceLocation(CusomItems.purple_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.purple_mini_lamp_on, 0, new ModelResourceLocation(CusomItems.purple_mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.purple_mini_lamp_off, 0, new ModelResourceLocation(CusomItems.purple_mini_lamp_off.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(CusomItems.yellow_lamp_off, 0, new ModelResourceLocation(CusomItems.yellow_lamp_off.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.yellow_lamp_on, 0, new ModelResourceLocation(CusomItems.yellow_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.yellow_mini_lamp_on, 0, new ModelResourceLocation(CusomItems.yellow_mini_lamp_on.getRegistryName(), "inventory"));
            ModelLoader.setCustomModelResourceLocation(CusomItems.yellow_mini_lamp_off, 0, new ModelResourceLocation(CusomItems.yellow_mini_lamp_off.getRegistryName(), "inventory"));
        }
    }
    public static ItemBlock getItemBlock(Block block){
        ItemBlock result = new ItemBlock(block);
        result.setRegistryName(block.getRegistryName()).setTranslationKey(block.getTranslationKey());
        return result;
    }
}
