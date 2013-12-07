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

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for ten.java programming contest.
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class Mbaxter extends JavaPlugin {
    
    /** Manages baxfax messages */
    private BaxFaxManager baxfax;
    /** Handles in-game notices and naming */
    private MbaxterListener listener;
    
    /**
     * Loads the {@link BaxFaxManager}
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    @Override
    public void onLoad() {
        this.baxfax = new BaxFaxManager(this);
    }
    
    /**
     * Enables the listener and re-tags entities on the server
     * 
     * @since 1.0.0
     * @version 1.0.0
     */
    @Override
    public void onEnable() {
        this.listener = new MbaxterListener(this);
        this.getServer().getPluginManager().registerEvents(this.listener, this);
        this.getServer().getScheduler().runTaskLater(this, new MbaxterRunnable(this), 20L);
    }
    
    /**
     * Returns the BaxFax manager
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return Main {@link BaxFaxManager} instance
     */
    public BaxFaxManager getBaxFax() {
        return this.baxfax;
    }
        

}
