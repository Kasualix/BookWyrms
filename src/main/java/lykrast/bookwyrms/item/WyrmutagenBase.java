package lykrast.bookwyrms.item;

import lykrast.bookwyrms.entity.BookWyrmEntity;
import net.minecraft.world.item.ItemStack;

public class WyrmutagenBase extends WyrmutagenItem {

	public WyrmutagenBase(Properties prop) {
		super(prop);
	}

	@Override
	public void applyMutagen(ItemStack stack, BookWyrmEntity wyrm) {
		wyrm.clearMutagenColor();
		wyrm.clearMutagenStat();
	}

	@Override
	public boolean canApply(ItemStack stack, BookWyrmEntity wyrm) {
		return wyrm.hasMutagenColor() || wyrm.hasMutagenStat();
	}

}
