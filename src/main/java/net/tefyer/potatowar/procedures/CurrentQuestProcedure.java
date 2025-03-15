package net.tefyer.potatowar.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.tefyer.potatowar.world.inventory.ItemquestMenu;
import net.tefyer.potatowar.init.PotatowarModItems;

import javax.annotation.Nullable;

import java.util.function.Supplier;
import java.util.Map;

@Mod.EventBusSubscriber
public class CurrentQuestProcedure {
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
		double RandomNum = 0;
		ItemStack item1 = ItemStack.EMPTY;
		ItemStack Item2 = ItemStack.EMPTY;
		ItemStack Item3 = ItemStack.EMPTY;
		ItemStack Reward1 = ItemStack.EMPTY;
		ItemStack Reward2 = ItemStack.EMPTY;
		if (entity.getPersistentData().getDouble("potatoWar:CurrentFactionID") == 1) {
			Reward1 = new ItemStack(PotatowarModItems.RUBY.get()).copy();
		} else if (entity.getPersistentData().getDouble("potatoWar:CurrentFactionID") == 2) {
			Reward1 = new ItemStack(PotatowarModItems.TOPAZ.get()).copy();
		}
		if (entity.getPersistentData().getBoolean("potatoWar:HasQuest") == true && entity.getPersistentData().getDouble("potatoWar:CurrentQuest") == 1 && entity instanceof Player _plr4 && _plr4.containerMenu instanceof ItemquestMenu) {
			item1 = Quest1Item1Procedure.execute(entity).copy();
			Item2 = Q12Procedure.execute(entity).copy();
			Item3 = Q13Procedure.execute(entity).copy();
			Reward2 = Q1RProcedure.execute(entity).copy();
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = item1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1"));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2"));
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item3.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3"));
				((Slot) _slots.get(2)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount1"));
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount2"));
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == item1.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Item2.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Item3.getItem()
					&& new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(3) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(4) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(5) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3")) {
				entity.getPersistentData().putBoolean("potatoWar:SlotsLocked", false);
			}
		} else if (entity.getPersistentData().getBoolean("potatoWar:HasQuest") == true && entity.getPersistentData().getDouble("potatoWar:CurrentQuest") == 2 && entity instanceof Player _plr30 && _plr30.containerMenu instanceof ItemquestMenu) {
			item1 = Q2I1Procedure.execute(entity).copy();
			Item2 = Q2I2Procedure.execute(entity).copy();
			Item3 = Q2I3Procedure.execute(entity).copy();
			Reward2 = Q2RProcedure.execute(entity).copy();
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = item1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1"));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2"));
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item3.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3"));
				((Slot) _slots.get(2)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount1"));
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount2"));
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == item1.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Item2.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Item3.getItem()
					&& new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(3) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(4) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(5) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3")) {
				entity.getPersistentData().putBoolean("potatoWar:SlotsLocked", false);
			}
		} else if (entity.getPersistentData().getBoolean("potatoWar:HasQuest") == true && entity.getPersistentData().getDouble("potatoWar:CurrentQuest") == 3 && entity instanceof Player _plr56 && _plr56.containerMenu instanceof ItemquestMenu) {
			item1 = Q3I3Procedure.execute(entity).copy();
			Item2 = Q3I2Procedure.execute(entity).copy();
			Item3 = Q3I1Procedure.execute(entity).copy();
			Reward2 = Q3RProcedure.execute(entity).copy();
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = item1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1"));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2"));
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item3.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3"));
				((Slot) _slots.get(2)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount1"));
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount2"));
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == item1.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Item2.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Item3.getItem()
					&& new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(3) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(4) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(5) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3")) {
				entity.getPersistentData().putBoolean("potatoWar:SlotsLocked", false);
			}
		} else if (entity.getPersistentData().getBoolean("potatoWar:HasQuest") == true && entity.getPersistentData().getDouble("potatoWar:CurrentQuest") == 4 && entity instanceof Player _plr82 && _plr82.containerMenu instanceof ItemquestMenu) {
			item1 = Q4I1Procedure.execute(entity).copy();
			Item2 = Q4I2Procedure.execute(entity).copy();
			Item3 = Q4I3Procedure.execute(entity).copy();
			Reward2 = Q4RProcedure.execute(entity).copy();
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = item1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1"));
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2"));
				((Slot) _slots.get(1)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Item3.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3"));
				((Slot) _slots.get(2)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward1.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount1"));
				((Slot) _slots.get(6)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = Reward2.copy();
				_setstack.setCount((int) entity.getPersistentData().getDouble("potatoWar:PlayerRewardCount2"));
				((Slot) _slots.get(7)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == item1.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Item2.getItem()
					&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY).getItem() == Item3.getItem()
					&& new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(3) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount1") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(4) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount2") && new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(5) >= entity.getPersistentData().getDouble("potatoWar:PlayerItemCount3")) {
				entity.getPersistentData().putBoolean("potatoWar:SlotsLocked", false);
			}
		}
	}
}
