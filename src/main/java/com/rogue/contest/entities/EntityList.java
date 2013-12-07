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

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.v1_6_R3.BiomeBase;
import net.minecraft.server.v1_6_R3.BiomeMeta;
import net.minecraft.server.v1_6_R3.EntityTypes;

/**
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public enum EntityList {
    
    ANCIENTDRAGON(DBAncientDragon.class, "Ancient Dragon", 63);
    
    private final Class<?> clazz;
    private final String name;
    private final int id;
    
    /**
     * EntityList enum constructor
     * @param clazz
     * @param name
     * @param id 
     */
    private EntityList(Class<?> clazz, String name, int id) {
        this.clazz = clazz;
        this.name = name;
        this.id = id;
    }
    
    /**
     * Gets the entities' management class
     * @return 
     */
    public Class<?> getCClass() {
        return null;
    }
    
    /**
     * Gets the name of the entity
     * @return 
     */
    public String getName() {
        return null;
    }
    
    /**
     * Gets the id of the entity
     * @return 
     */
    public int getId() {
        return 0;
    }

    /**
     * Registers entities for the game, namely replacing the enderdragon
     */
    public static void registerEntities() {
        try {
            Method m = EntityTypes.class.getDeclaredMethod("a", new Class<?>[]{Class.class, String.class, int.class});
            m.setAccessible(true);
            for (EntityList e : values()) {
                m.invoke(null, e.getCClass(), e.getName(), e.getId());
            }
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
        }
        biomeLoop:
        for (BiomeBase biome : BiomeBase.biomes) {
            if (biome == null) {
                break;
            }
            
            String[] fields = new String[]{"K", "J", "L", "M"};
            for (String field : fields) {
                try {
                    Field itr = BiomeBase.class.getDeclaredField(field);
                    itr.setAccessible(true);
                    List<BiomeMeta> mobs = (List<BiomeMeta>) itr.get(biome);
                    for (BiomeMeta meta : mobs) {
                        for (EntityList ent : values()) {
                            if (ent.getCClass().equals(meta.b)) {
                                meta.b = ent.getCClass();
                            }
                        }
                    }
                } catch (NoSuchFieldException ex) {
                    Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(EntityList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        }
    }

}
