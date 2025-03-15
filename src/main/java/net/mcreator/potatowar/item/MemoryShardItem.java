
package net.mcreator.potatowar.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class MemoryShardItem extends Item {
	public MemoryShardItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}
}
