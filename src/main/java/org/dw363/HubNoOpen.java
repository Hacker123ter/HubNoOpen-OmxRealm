package org.dw363;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HubNoOpen extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onInventoryOpen(InventoryOpenEvent event) {
        Material inventoryType = event.getInventory().getLocation().getBlock().getType();

        if (inventoryType == Material.CHEST ||
                inventoryType == Material.ENDER_CHEST ||
                inventoryType.name().endsWith("_SHULKER_BOX") ||
                inventoryType == Material.BARREL) {
            event.setCancelled(true);
        }
    }
}