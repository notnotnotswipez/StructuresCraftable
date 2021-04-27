package me.swipez.structurescraftable.listener;

import me.swipez.structurescraftable.StructuresCraftable;
import me.swipez.structurescraftable.items.CraftableBlocks;
import me.swipez.structurescraftable.structure.StructureUtil;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.loot.LootTables;

import java.util.Random;

public class BlockPlaceListener implements Listener {

    Random random = new Random();

    @EventHandler
    public void onPlayerPlaceBlock(BlockPlaceEvent event){
        String structure = null;
        Block block = event.getBlock();
        if (event.getItemInHand().isSimilar(CraftableBlocks.BASTION)){
            structure = "bastion";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.END_CITY)){
            structure = "end_city";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.FORTRESS)){
            structure = "fortress";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.JUNGLE_PYRAMID)){
            structure = "jungle_pyramid";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.PILLAGER_OUTPOST)){
            structure = "pillager_outpost";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.PYRAMID)){
            structure = "pyramid";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.RUINED_PORTAL)){
            structure = "ruined_portal";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.STRONGHOLD)){
            structure = "stronghold";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.SUNKEN_SHIP)){
            structure = "sunken_ship";
            block.setType(Material.AIR);
        }
        if (event.getItemInHand().isSimilar(CraftableBlocks.VILLAGE)){
            structure = "villagesmall";
            block.setType(Material.AIR);
        }
        if (structure != null){
            int randomX = random.nextInt(20);
            int randomZ = random.nextInt(20);
            switch (structure){
                case "bastion":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(0,3,0), 60, null, LootTables.BASTION_OTHER.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "end_city":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(40+randomX,3,40+randomZ), 100, null, LootTables.END_CITY_TREASURE.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "fortress":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,3, randomZ), 30, EntityType.BLAZE, LootTables.NETHER_BRIDGE.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "jungle_pyramid":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,3,randomZ), 60, null, LootTables.JUNGLE_TEMPLE.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "pillager_outpost":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,0,randomZ), 30, null, LootTables.PILLAGER_OUTPOST.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "pyramid":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,15,randomZ), 30, null, LootTables.DESERT_PYRAMID.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "sunken_ship":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,3,randomZ), 30, null, LootTables.SHIPWRECK_SUPPLY.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "ruined_portal":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,10,randomZ), 30, null, LootTables.RUINED_PORTAL.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "villagesmall":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(randomX,1,randomZ), 30, null, LootTables.VILLAGE_WEAPONSMITH.getLootTable(), StructuresCraftable.plugin);
                    break;
                case "stronghold":
                    StructureUtil.loadAndSlowlyPlaceCaio(structure, event.getPlayer().getLocation().subtract(40,4,40), 50, EntityType.SILVERFISH, LootTables.STRONGHOLD_CORRIDOR.getLootTable(), StructuresCraftable.plugin);
            }
        }
    }
}
