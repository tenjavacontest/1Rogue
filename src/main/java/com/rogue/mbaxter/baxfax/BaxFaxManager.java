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
package com.rogue.mbaxter.baxfax;

import com.rogue.mbaxter.Mbaxter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 * Handles baxfax....s
 *
 * @since 1.0.0
 * @author 1Rogue
 * @version 1.0.0
 */
public class BaxFaxManager {
    
    private final Mbaxter plugin;
    private final String baxfaxLocation = "https://raw.github.com/RoyalDev/RoyalBot/master/src/main/resources/config.yml";
    private final List<String> fax;
    
    /**
     * BaxFaxManager constructor. Loads the newest revision of baxfax from the
     * github repository with baxfax.
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @param plugin Main {@link Mbaxter} instance
     */
    public BaxFaxManager(Mbaxter plugin) {
        this.plugin = plugin;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        File f = new File(this.plugin.getDataFolder(), "config.yml");
        try {
            if (!this.plugin.getDataFolder().exists()) {
                this.plugin.getDataFolder().mkdir();
            }
            if (f.exists()) {
                f.delete();
            }
            f.createNewFile();
            URL call = new URL(this.baxfaxLocation);
            rbc = Channels.newChannel(call.openStream());
            fos = new FileOutputStream(f);
            fos.getChannel().transferFrom(rbc, 0, Integer.MAX_VALUE);
        } catch (MalformedURLException ex) {
            Logger.getLogger(BaxFaxManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BaxFaxManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rbc != null) {
                    rbc.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(BaxFaxManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //fuck it all I'll use yaml
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        this.fax = yaml.getStringList("baxfax");
        
    }
    
    /**
     * Gets a new BAXFAX!!
     * 
     * @since 1.0.0
     * @version 1.0.0
     * 
     * @return A random baxfax
     */
    public synchronized String newBaxFax() {
        Collections.shuffle(this.fax);
        return this.fax.iterator().next();
    }

}
