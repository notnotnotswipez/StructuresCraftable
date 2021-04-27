package me.swipez.structurescraftable;

import me.swipez.structurescraftable.items.CraftableBlocks;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class GiveAllStructuresCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) return false;

        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (Map.Entry<Integer, ItemStack> entry : player.getInventory().addItem(
                    CraftableBlocks.BASTION,
                    CraftableBlocks.END_CITY,
                    CraftableBlocks.FORTRESS,
                    CraftableBlocks.JUNGLE_PYRAMID,
                    CraftableBlocks.PILLAGER_OUTPOST,
                    CraftableBlocks.PYRAMID,
                    CraftableBlocks.RUINED_PORTAL,
                    CraftableBlocks.STRONGHOLD,
                    CraftableBlocks.SUNKEN_SHIP,
                    CraftableBlocks.VILLAGE
            ).entrySet()) {
                player.getWorld().dropItemNaturally(player.getLocation(), entry.getValue());
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You must be a player to execute this command!");
        }
        return true;
    }
}
