package com.github.yuuki2028.mod.gtsteam.gts;

import gregtech.api.gui.GuiTextures;
import gregtech.api.gui.widgets.ProgressWidget;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.recipes.builders.SimpleRecipeBuilder;

public class GTSReciepMaps {
    public static final RecipeMap<SimpleRecipeBuilder> HUMIDIFICATION_RECIPES = (new RecipeMap("Humidification", 1, 1, 1, 1, 0, 0, 0, 0, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY).setProgressBar(GuiTextures.FURNACE_OVERLAY, ProgressWidget.MoveType.VERTICAL);
    public static final RecipeMap<SimpleRecipeBuilder> BOWLING_RECIPES = (new RecipeMap("bowling", 0, 0, 1, 8, 0, 1, 0, 0, new SimpleRecipeBuilder())).setSlotOverlay(false, false, GuiTextures.FURNACE_OVERLAY).setProgressBar(GuiTextures.FURNACE_OVERLAY, ProgressWidget.MoveType.VERTICAL);
}
