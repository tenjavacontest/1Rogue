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
package com.rogue.contest.listener;

import com.rogue.contest.Contest;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Entitties
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class MbaxterListener implements Listener {
    
    private final Contest plugin;
    
    public MbaxterListener(Contest plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onCritterSpawn(CreatureSpawnEvent event) {
        LivingEntity e = event.getEntity();
        if (e instanceof Player) {
            return;
        }
        e.setCustomName("mbaxter");
        e.setCustomNameVisible(true);
    }
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity butthurt = event.getEntity();
        if (damager instanceof Player || !(butthurt instanceof Player)) {
            return;
        }
        Player p = (Player) butthurt;
        p.sendMessage(this.plugin.getBaxFax().newBaxFax() + "!!");
    }
    
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Player) {
            return;
        }
        event.getPlayer().sendMessage(this.plugin.getBaxFax().newBaxFax());
    }

}
