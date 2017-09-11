package mezz.jei.test.lib;

import mezz.jei.startup.AbstractModIdHelper;

import javax.annotation.Nullable;

public class TestModIdHelper extends AbstractModIdHelper {
	@Override
	public String getModNameForModId(String modId) {
		return "ModName(" + modId + ")";
	}

	@Nullable
	@Override
	public String getModNameTooltipFormatting() {
		return null;
	}
}
