package me.swipez.structurescraftable.items;

import me.swipez.structurescraftable.StructuresCraftable;
import me.swipez.structurescraftable.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class CraftableBlocks {

    public static ItemStack VILLAGE = ItemBuilder.of(Material.OAK_PLANKS)
            .name(ChatColor.GOLD+"Village Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack RUINED_PORTAL = ItemBuilder.of(Material.OBSIDIAN)
            .name(ChatColor.GOLD+"Ruined Portal Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack STRONGHOLD = ItemBuilder.of(Material.END_PORTAL_FRAME)
            .name(ChatColor.GOLD+"Stronghold Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack PYRAMID = ItemBuilder.of(Material.SAND)
            .name(ChatColor.GOLD+"Pyramid Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack SUNKEN_SHIP = ItemBuilder.of(Material.OAK_LOG)
            .name(ChatColor.GOLD+"Sunken Ship Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack BASTION = ItemBuilder.of(Material.BASALT)
            .name(ChatColor.GOLD+"Bastion Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack END_CITY = ItemBuilder.of(Material.PURPUR_BLOCK)
            .name(ChatColor.GOLD+"End City Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack FORTRESS = ItemBuilder.of(Material.NETHER_BRICKS)
            .name(ChatColor.GOLD+"Nether Fortress Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack JUNGLE_PYRAMID = ItemBuilder.of(Material.MOSSY_COBBLESTONE)
            .name(ChatColor.GOLD+"Jungle Pyramid Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();

    public static ItemStack PILLAGER_OUTPOST = ItemBuilder.of(Material.DARK_OAK_LOG)
            .name(ChatColor.GOLD+"Pillager Outpost Structure")
            .enchantment(Enchantment.CHANNELING, 1)
            .flags(ItemFlag.HIDE_ENCHANTS)
            .build();


    public static void initRecipes(StructuresCraftable plugin){
        registerWoodRecipe(plugin);
        registerObsidianRecipe(plugin);
        registerEndFrame(plugin);
        registerSandRecipe(plugin);
        registerLogRecipe(plugin);
        registerSoulSandRecipe(plugin);
        registerEndCityRecipe(plugin);
        registerFortressRecipe(plugin);
        registerJunglePyramid(plugin);
        registerPillagerOutpostRecipe(plugin);
    }

    public static void registerWoodRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "wood_block_recipe"), CraftableBlocks.VILLAGE)
                .shape("SSS","SCS","LLL")
                .setIngredient('S', Material.COBBLESTONE_STAIRS)
                .setIngredient('C', Material.CHEST)
                .setIngredient('L', Material.OAK_LOG);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerObsidianRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "obsidian_block_recipe"), CraftableBlocks.RUINED_PORTAL)
                .shape(" S "," C "," L ")
                .setIngredient('S', Material.LAVA_BUCKET)
                .setIngredient('C', Material.CHEST)
                .setIngredient('L', Material.WATER_BUCKET);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerEndFrame(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "endframe_block_recipe"), CraftableBlocks.STRONGHOLD)
                .shape("DBD","EEE","SSS")
                .setIngredient('S', Material.STONE)
                .setIngredient('D', Material.DIAMOND)
                .setIngredient('B', Material.DIAMOND_BLOCK)
                .setIngredient('E', Material.ENDER_PEARL);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerSandRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "sand_block_recipe"), CraftableBlocks.PYRAMID)
                .shape("SSS","SCS","SSS")
                .setIngredient('S', Material.SAND)
                .setIngredient('C', Material.GOLD_INGOT);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerLogRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "log_block_recipe"), CraftableBlocks.SUNKEN_SHIP)
                .shape(" S ","SSS"," S ")
                .setIngredient('S', Material.OAK_BOAT);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerSoulSandRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "soul_sand_block_recipe"), CraftableBlocks.BASTION)
                .shape("SSS","GGG","SSS")
                .setIngredient('S', Material.BLACKSTONE)
                .setIngredient('G', Material.GOLD_INGOT);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerEndCityRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "end_city_block_recipe"), CraftableBlocks.END_CITY)
                .shape("SSS","ECE","SSS")
                .setIngredient('S', Material.END_STONE)
                .setIngredient('E', Material.ENDER_PEARL)
                .setIngredient('C', Material.CHEST);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerFortressRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "fortress_block_recipe"), CraftableBlocks.FORTRESS)
                .shape("BBB","GDG","BBB")
                .setIngredient('B', Material.NETHER_BRICKS)
                .setIngredient('G', Material.LAVA_BUCKET)
                .setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerJunglePyramid(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "jungle_pyramid_block_recipe"), CraftableBlocks.JUNGLE_PYRAMID)
                .shape("CCC","CRC","CCC")
                .setIngredient('C', Material.COBBLESTONE)
                .setIngredient('R', Material.REDSTONE);
        Bukkit.addRecipe(shapedRecipe);
    }

    public static void registerPillagerOutpostRecipe(StructuresCraftable plugin){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(plugin, "pillager_outpost_block_recipe"), CraftableBlocks.PILLAGER_OUTPOST)
                .shape("LLL","CBC","LLL")
                .setIngredient('L', Material.OAK_LOG)
                .setIngredient('C', Material.COBBLESTONE)
                .setIngredient('B', Material.BOW);
        Bukkit.addRecipe(shapedRecipe);
    }
}
