package net.tefyer.potatowar.items;

import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.tefyer.api.CompoundTagIds;
import net.tefyer.potatowar.blocks.custom.blockentities.TownCenterBlockEntity;
import net.tefyer.api.item.utils.ItemUtils;

public class ChestMalitiaMarker extends Item {
    public ChestMalitiaMarker() {
        super(new Item.Properties());
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        if(pContext.getLevel().getBlockEntity(pContext.getClickedPos()) instanceof ChestBlockEntity &&
                !ItemUtils.ifExist(pContext.getItemInHand(), CompoundTagIds.ChestBind)){
            ItemUtils.setPos(pContext.getItemInHand(),CompoundTagIds.ChestBind,pContext.getClickedPos());
        }

        return super.useOn(pContext);
    }

}
