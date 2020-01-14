package com.github.yuuki2028.mod.gtsteam.gts;

import gregtech.api.capability.impl.FilteredFluidHandler;
import gregtech.api.capability.impl.FluidTankList;
import gregtech.api.gui.ModularUI;
import gregtech.api.gui.widgets.FluidContainerSlotWidget;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.gui.widgets.SlotWidget;
import gregtech.api.gui.widgets.TankWidget;
import gregtech.api.metatileentity.MetaTileEntity;
import gregtech.api.metatileentity.MetaTileEntityHolder;
import gregtech.api.metatileentity.SteamMetaTileEntity;
import gregtech.api.recipes.ModHandler;
import gregtech.api.render.Textures;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class SteamBowling extends SteamMetaTileEntity {
    private FluidTank fluidTank;
    private ItemStackHandler containerInventory;
    public SteamBowling(ResourceLocation metaTileEntityId, boolean isHighPressure) {
        super(metaTileEntityId, GTSReciepMaps.BOWLING_RECIPES, Textures.ELECTROLYZER_OVERLAY, isHighPressure);
        this.containerInventory = new ItemStackHandler(2);
    }

    @Override
    public MetaTileEntity createMetaTileEntity(MetaTileEntityHolder holder) {
        return new SteamBowling(metaTileEntityId, isHighPressure);
    }
    @Override
    public void update(){
        super.update();
        this.fillInternalTankFromFluidContainer(this.containerInventory, this.containerInventory, 0, 1);
        this.workableHandler.setWorkingEnabled(this.getPos().getY() == 1);
    }
    @Override
    public FluidTankList createImportFluidHandler() {
        FluidTankList superHandler = super.createImportFluidHandler();
        this.fluidTank = new FilteredFluidHandler(16000).setFillPredicate(ModHandler::isWater);
        return new FluidTankList(false, superHandler, fluidTank);

    }
    @Override
    public IItemHandlerModifiable createImportItemHandler() {
        return new ItemStackHandler(1);
    }

    @Override
    public IItemHandlerModifiable createExportItemHandler() {
        return new ItemStackHandler(1);
    }
    @Override
    public ModularUI createUI(EntityPlayer player) {
        return createUITemplate(player)
                .widget(new TankWidget(fluidTank, 108, 17, 11, 55)
                        .setBackgroundTexture(getFullGuiTexture("bar_%s_empty")))
                .widget(new FluidContainerSlotWidget(containerInventory, 0, 43, 18, true)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE, getFullGuiTexture("overlay_%s_in")))
                .widget(new SlotWidget(containerInventory, 1, 43, 54, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE, getFullGuiTexture("overlay_%s_out")))
                .widget(new ProgressWidget(workableHandler::getProgressPercent, 30, 35, 20, 18)
                        .setProgressBar(getFullGuiTexture("progress_bar_%s_furnace"),
                                getFullGuiTexture("progress_bar_%s_furnace_filled"),
                                ProgressWidget.MoveType.HORIZONTAL))
                .widget(new SlotWidget(this.exportItems, 0, 50, 30, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 65, 30, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 80, 30, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 95, 30, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 110, 30, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 50, 50, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 65, 50, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 80, 50, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 95, 50, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .widget(new SlotWidget(this.exportItems, 0, 110, 50, true, false)
                        .setBackgroundTexture(BRONZE_SLOT_BACKGROUND_TEXTURE))
                .build(getHolder(), player);
    }
}
