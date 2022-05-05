package me.mathrandom7910.AutoClip.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;
import net.minecraft.util.math.BlockPos;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class AVClipCommand extends Command {
    private MinecraftClient mc = MinecraftClient.getInstance();
    public AVClipCommand() {
        super("avcilp", "a terrible idea", "avc");
    }

    private Block getBlock(BlockPos pos) {
        return mc.player.world.getBlockState(pos).getBlock();
    }

    private boolean doAutoClip(int incr) {
        BlockPos pos = mc.player.getBlockPos();
        //      -1            -10          -1
        if(incr == 0) incr = 1;
        for(int i = incr; incr > 0 ? i <= 10 : i >= -10; i += incr) {
            if(getBlock(pos.add(0, i, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 1, 0)) == Blocks.AIR) {
                ChatUtils.info("Found clip block " + i + " blocks " + (incr > 0 ? "up" : "down") + ".");
                mc.player.setPosition(pos.getX(), pos.getY() + i, pos.getZ());
                return true;
            }
        }
        ChatUtils.error("Unable to clip.");
        return false;
    }

    @Override
    public void build(LiteralArgumentBuilder<CommandSource> builder) {
        builder.then(literal("up").executes(c -> {
            doAutoClip(1);
            return SINGLE_SUCCESS;
        }));
        builder.then(literal("down").executes(c -> {
            doAutoClip(-1);
            return SINGLE_SUCCESS;
        }));
    }
}
