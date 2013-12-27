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
package com.rogue.mbaxter;

import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

/**
 * Lets be SUPER DUPER sure all the entities are named
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class MbaxterRunnable implements Runnable {

    /** Main {@link Mbaxter} instance */
    private final Mbaxter plugin;

    /**
     * MbaxterRunnable constructor
     *
     * @since 1.0.0
     * @version 1.0.0
     *
     * @param plugin Main {@link Mbaxter} instance
     */
    MbaxterRunnable(Mbaxter plugin) {
        this.plugin = plugin;
    }

    /**
     * Tags all living entities in the server
     *
     * @since 1.0.0
     * @version 1.0.0
     */
    public void run() {
        for (World w : this.plugin.getServer().getWorlds()) {
            for (LivingEntity e : w.getLivingEntities()) {
                if (!(e instanceof Player)) {
                    if (e.getType() == EntityType.BAT) {
                        e.setCustomName("hawkfalcon");
                    } else if (e.getType() == EntityType.CREEPER) {
                        e.setCustomName("Hoolean");
                    } else {
                        e.setCustomName("mbaxter");
                    }
                    e.setCustomNameVisible(true);
                }
            }
        }
    }

}
