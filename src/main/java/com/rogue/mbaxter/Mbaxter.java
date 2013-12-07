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

import com.rogue.mbaxter.baxfax.BaxFaxManager;
import com.rogue.mbaxter.listener.MbaxterListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for ten.java programming contest.
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class Mbaxter extends JavaPlugin {
    
    private BaxFaxManager baxfax;
    private MbaxterListener listener;
    
    @Override
    public void onLoad() {
        this.baxfax = new BaxFaxManager(this);
    }
    
    @Override
    public void onEnable() {
        this.listener = new MbaxterListener(this);
        this.getServer().getPluginManager().registerEvents(this.listener, this);
    }
    
    public BaxFaxManager getBaxFax() {
        return this.baxfax;
    }
        

}
