package mezz.jei.startup;

import java.util.ArrayList;
import java.util.List;

import mezz.jei.api.ingredients.IIngredientHelper;
import mezz.jei.config.Config;

public abstract class AbstractModIdHelper implements IModIdHelper {
	@Override
	public <T> String getModNameForIngredient(T ingredient, IIngredientHelper<T> ingredientHelper) {
		String modId = ingredientHelper.getModId(ingredient);
		return getModNameForModId(modId);
	}

	@Override
	public <T> List<String> addModNameToIngredientTooltip(List<String> tooltip, T ingredient, IIngredientHelper<T> ingredientHelper) {
		if (Config.isModNameFormatOverrideActive()) { // we detected that another mod is adding the mod name already
			return tooltip;
		}
		String modNameFormat = Config.getModNameFormat();
		if (modNameFormat.isEmpty()) {
			return tooltip;
		}

		String modName = getModNameForIngredient(ingredient, ingredientHelper);
		List<String> tooltipCopy = new ArrayList<>(tooltip);
		tooltipCopy.add(modNameFormat + modName);
		return tooltipCopy;
	}
}
