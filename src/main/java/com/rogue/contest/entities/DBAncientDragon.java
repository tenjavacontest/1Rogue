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
package com.rogue.contest.entities;

import net.minecraft.server.v1_6_R3.EntityEnderDragon;
import org.bukkit.craftbukkit.v1_6_R3.CraftServer;
import org.bukkit.craftbukkit.v1_6_R3.entity.CraftEnderDragon;


/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class DBAncientDragon extends CraftEnderDragon {

    /**
     * Ancient dragon constructor
     * 
     * @param server
     * @param entity 
     */
    public DBAncientDragon(CraftServer server, EntityEnderDragon entity) {
        super(server, entity);
    }
    
    @Override
    public String toString() {
        return "DBAncientDragon";
    }
}
