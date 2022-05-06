package me.mathrandom7910.AutoClip.commands;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import meteordevelopment.meteorclient.systems.commands.Command;
import meteordevelopment.meteorclient.utils.player.ChatUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.command.CommandSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.client.network.ClientPlayerEntity;

import static com.mojang.brigadier.Command.SINGLE_SUCCESS;

public class AVClipCommandFix extends Command {
    private MinecraftClient mc = MinecraftClient.getInstance();
    public AVClipCommandFix() {
        super("avcilpfixed", "the best idea", "avcf");
    }

    private Block getBlock(BlockPos pos) {
        return mc.player.world.getBlockState(pos).getBlock();
    }

    private boolean doAutoClip(float incr) {
        BlockPos pos = mc.player.getBlockPos();
        //      -1            -10          -1
        ClientPlayerEntity player = mc.player;
        assert player != null;
        if(incr == 0) incr = 1;
        for(float i = incr; incr > 0 ? i <= 10 : i >= -10; i += incr) {
            if(getBlock(pos.add(0, i, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 1, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 2, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 3, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 4, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 5, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 6, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 7, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 8, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 9, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 10, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 11, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 12, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 13, 0)) == Blocks.AIR && getBlock(pos.add(0, i + 14, 0)) == Blocks.AIR) {
                ChatUtils.info("Found clip block " + i + " blocks " + (incr > 0 ? "up" : "down") + ".");
                player.setPosition(player.getX(), player.getY() + , player.getZ());
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
    }
}
