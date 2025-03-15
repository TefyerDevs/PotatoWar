package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.world.inventory.MilitaryTrainerKitsMenu;
import net.tefyer.potatowar.init.PotatowarModItems;

import javax.annotation.Nullable;

import java.util.function.Supplier;
import java.util.Map;

@Mod.EventBusSubscriber
public class MilitaryTrainerRightClickedOnEntityProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _plr0 && _plr0.containerMenu instanceof MilitaryTrainerKitsMenu) {
			if (entity.getPersistentData().getDouble("potatowar:KitID") == 5) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PotatowarModItems.BLANK_KIT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.RUBY.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if (entity.getPersistentData().getDouble("potatowar:KitID") == 4) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PotatowarModItems.MILITA_KIT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.RUBY.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if (entity.getPersistentData().getDouble("potatowar:KitID") == 3) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PotatowarModItems.ARMY_KIT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.RUBY.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if (entity.getPersistentData().getDouble("potatowar:KitID") == 2) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PotatowarModItems.SCOUT_KIT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.RUBY.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			} else if (entity.getPersistentData().getDouble("potatowar:KitID") == 1) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = new ItemStack(PotatowarModItems.KNIGHT_KIT.get()).copy();
					_setstack.setCount(1);
					((Slot) _slots.get(1)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 1) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.RUBY.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				} else if (entity.getPersistentData().getDouble("potatoWar:FactionID") == 2) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack _setstack = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
						_setstack.setCount((int) entity.getPersistentData().getDouble("potatowar:KitPrice"));
						((Slot) _slots.get(0)).set(_setstack);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}
}
