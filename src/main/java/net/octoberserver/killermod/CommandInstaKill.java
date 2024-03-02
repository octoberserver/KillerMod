package net.octoberserver.killermod;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public class CommandInstaKill extends CommandBase {
    public CommandInstaKill() {
    }

    public String getName() {
        return "instakill";
    }

    public int getRequiredPermissionLevel() {
        return 2;
    }

    public String getUsage(ICommandSender p_71518_1_) {
        return "commands.kill.usage";
    }

    public void execute(MinecraftServer server, ICommandSender sender, String[] params) throws CommandException {
        if (params.length == 0) {
            EntityPlayer senderPlayer = getCommandSenderAsPlayer(sender);
            senderPlayer.setHealth(0);
        } else {
            EntityPlayer targetPlayer = getPlayer(server, sender, params[0]);
            targetPlayer.setHealth(0);
        }
    }

    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return p_82358_2_ == 0;
    }

    public List<String> getTabCompletions(MinecraftServer p_184883_1_, ICommandSender p_184883_2_, String[] p_184883_3_, @Nullable BlockPos p_184883_4_) {
        return p_184883_3_.length == 1 ? getListOfStringsMatchingLastWord(p_184883_3_, p_184883_1_.getOnlinePlayerNames()) : Collections.emptyList();
    }
}
