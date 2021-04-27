package me.swipez.structurescraftable;

import me.swipez.structurescraftable.items.CraftableBlocks;
import me.swipez.structurescraftable.listener.BlockPlaceListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.stream.Stream;

public final class StructuresCraftable extends JavaPlugin {

    public static StructuresCraftable plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new BlockPlaceListener(), this);
        CraftableBlocks.initRecipes(this);
        File mainPath = new File(plugin.getDataFolder().getPath());
        if (!mainPath.exists()){
            mainPath.mkdir();
        }
        File directory = new File(plugin.getDataFolder() + "/structures");
        if(!directory.exists()){
            directory.mkdir();
        }
        exportAllResourceLocales();
        getCommand("giveallstructures").setExecutor(new GiveAllStructuresCommand());
    }

    private void exportAllResourceLocales() {
        Iterator<Path> pathIterator = getAllPathsWithinLocales();
        if (pathIterator == null) {
            return;
        }
        while (pathIterator.hasNext()) {
            Path localePath = pathIterator.next();
            InputStream resourceStream = plugin.getResource(localePath.toString().replace("/structures", "structures"));
            if (resourceStream == null) {
                plugin.getLogger().log(Level.SEVERE, "Could not load resource " + localePath.toString());
                continue;
            }
            try {
                File outFile = new File(plugin.getDataFolder() + "/structures/" + localePath.getFileName());
                if (outFile.exists()) continue;
                Path outPath = outFile.toPath();
                Files.copy(resourceStream, outPath, StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException ex) {
                plugin.getLogger().log(Level.SEVERE, "Could not copy to " + localePath.toString());
                ex.printStackTrace();
            }
        }
    }

    private Iterator<Path> getAllPathsWithinLocales() {
        URI uri;
        try {
            uri = this.plugin.getClass().getResource("/structures").toURI();
        } catch (URISyntaxException ex) {
            plugin.getLogger().log(Level.SEVERE, "Got invalid URI Syntax from /structures folder");
            return null;
        }
        Path localesPath;
        if (uri.getScheme().equals("jar")) {
            FileSystem fileSystem;
            try {
                fileSystem = FileSystems.getFileSystem(uri);
            } catch (FileSystemNotFoundException ignored) {
                try {
                    fileSystem = FileSystems.newFileSystem(uri, new HashMap<String, Object>());
                } catch (IOException ex) {
                    plugin.getLogger().log(Level.SEVERE, "Error enumerating resources");
                    ex.printStackTrace();
                    return null;
                }
            }
            localesPath = fileSystem.getPath("/structures");
        } else {
            localesPath = Paths.get(uri);
        }
        Stream<Path> walker;
        try {
            walker = Files.walk(localesPath, 1);
        } catch (IOException ex) {
            plugin.getLogger().log(Level.SEVERE, "Error enumerating resources");
            ex.printStackTrace();
            return null;
        }
        return walker.iterator();
    }
}
