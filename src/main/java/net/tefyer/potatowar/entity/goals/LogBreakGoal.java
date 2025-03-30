package net.tefyer.potatowar.entity.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.util.GoalUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.pathfinder.Node;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.level.pathfinder.PathFinder;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ForgeBlockTagsProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class LogBreakGoal extends Goal {
    private static final int DEFAULT_LOG_BREAK_TIME = 240;
    protected BlockPos doorPos;
    private final PathfinderMob mob;
    protected int breakTime;
    protected boolean hasDoor;
    protected int lastBreakProgress;
    protected int logBreakTime;

    public LogBreakGoal(PathfinderMob mob) {
        super();
        this.mob = mob;
        this.doorPos = BlockPos.ZERO;
        this.lastBreakProgress = -1;
        this.logBreakTime = -1;
    }

    public LogBreakGoal(PathfinderMob mob,int pLogBreakTime) {
        this(mob);
        this.logBreakTime = pLogBreakTime;
    }

    public void start() {
        super.start();
        this.breakTime = 0;
    }
    public void stop() {
        super.stop();
        this.mob.level().destroyBlockProgress(this.mob.getId(), this.doorPos, -1);
    }


    public boolean canContinueToUse() {
        return this.breakTime <= this.getBreakTime() &&
                this.doorPos.closerToCenterThan(this.mob.position(), (double)2.0F);
    }

    protected int getBreakTime() {
        return Math.max(240, this.logBreakTime);
    }


    public void tick() {

        if (this.mob.getRandom().nextInt(20) == 0) {
            this.mob.level().levelEvent(1019, this.doorPos, 0);
            if (!this.mob.swinging) {
                this.mob.swing(this.mob.getUsedItemHand());
            }
        }

        ++this.breakTime;
        int i = (int)((float)this.breakTime / (float)this.getBreakTime() * 10.0F);
        if (i != this.lastBreakProgress) {
            this.mob.level().destroyBlockProgress(this.mob.getId(), this.doorPos, i);
            this.lastBreakProgress = i;
        }

        if (this.breakTime == this.getBreakTime() ) {
            this.mob.level().removeBlock(this.doorPos, false);
            this.mob.level().levelEvent(1021, this.doorPos, 0);
            this.mob.level().levelEvent(2001, this.doorPos, Block.getId(this.mob.level().getBlockState(this.doorPos)));
        }

    }


    public boolean canUse() {
        if (!checkCanUse()) {
            return false;
        } else return ForgeHooks.canEntityDestroy(this.mob.level(), this.doorPos, this.mob);
    }

    public boolean requiresUpdateEveryTick() {
        return true;
    }
    public boolean checkCanUse() {
        if (!GoalUtils.hasGroundPathNavigation(this.mob)) {
            return false;
        } else if (this.mob.horizontalCollision) {
            return false;
        }

        GroundPathNavigation navigation = (GroundPathNavigation)this.mob.getNavigation();
        Path path = navigation.getPath();
        if (path == null || path.isDone() )
            return false;


        for(int nodeIndex = 0; nodeIndex < Math.min(path.getNextNodeIndex() + 2, path.getNodeCount()); ++nodeIndex) {
            if(evalNodePoint(path, nodeIndex))
                return true;
        }

        this.doorPos = this.mob.blockPosition().above();
        return this.hasDoor;
    }

    private boolean evalNodePoint(Path path,int nodeIndex) {
        Node navnode = path.getNode(nodeIndex);
        this.doorPos = new BlockPos(navnode.x, navnode.y + 1, navnode.z);
        if (this.mob.distanceToSqr(this.doorPos.getX(), this.mob.getY(), this.doorPos.getZ()) < (double)2.25F &&
                Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(BlockTags.LOGS).contains(this.mob.level().getBlockState(this.doorPos).getBlock()))
            return true;
        return false;
    }

}
