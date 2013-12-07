/*
 * Copyright (C) 2013 Spencer Alderman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rogue.mbaxter.listener;

import com.rogue.mbaxter.Mbaxter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Hehe... Entitties
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class MbaxterListener implements Listener {
    
    private final Mbaxter plugin;
    private final String prefix = "[" + ChatColor.RED + "baxfax" + ChatColor.RESET + "] ";
    
    /**
     * MbaxterListener constructor
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param plugin Main {@link Mbaxter} instance
     */
    public MbaxterListener(Mbaxter plugin) {
        this.plugin = plugin;
    }
    
    /**
     * Tags new entities
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param event 
     */
    @EventHandler
    public void onCritterSpawn(CreatureSpawnEvent event) {
        LivingEntity e = event.getEntity();
        if (e instanceof Player) {
            return;
        }
        e.setCustomName("mbaxter");
        e.setCustomNameVisible(true);
    }
    
    /**
     * Hostile mobs shout baxfax at you
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param event 
     */
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity butthurt = event.getEntity();
        if (damager instanceof Player || !(butthurt instanceof Player)) {
            return;
        }
        Player p = (Player) butthurt;
        p.sendMessage(this.prefix.toUpperCase() + this.plugin.getBaxFax().newBaxFax() + "!!");
    }
    
    /**
     * Interacting with mbaxter will give you awesome baxfax
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param event 
     */
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            return;
        }
        event.getPlayer().sendMessage(this.prefix + this.plugin.getBaxFax().newBaxFax());
    }
    
    /**
     * This would SUPPOSEDLY make endermen part of a mighty religious cult.
     * Unfortunately that is not the case.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param event 
     */
    @EventHandler
    public void onTarget(EntityTargetLivingEntityEvent event) {
        System.out.println("checking target instance...");
        if (event.getTarget() instanceof Player) {
            System.out.println("checking enderman instance...");
            if (event.getEntityType() == EntityType.ENDERMAN) {
                System.out.println("sending message");
                ((Player) event.getTarget()).sendMessage("["
                        + ChatColor.RED
                        + "Enderman"
                        + ChatColor.RESET
                        + "] Sir do you have a moment to talk about our lord and savior?");
            }
        }
    }

}
