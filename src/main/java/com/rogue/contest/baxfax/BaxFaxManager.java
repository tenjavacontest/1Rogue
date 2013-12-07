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
package com.rogue.contest.baxfax;

import com.rogue.contest.Contest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @since
 * @author 1Rogue
 * @version
 */
public class BaxFaxManager {
    
    private final Contest plugin;
    private final String baxfaxLocation = "https://raw.github.com/RoyalDev/RoyalBot/master/src/main/resources/config.yml";
    //private final LinkedQueue<String> baxfax = new LinkedQueue<String>();
    
    public BaxFaxManager(Contest plugin) {
        this.plugin = plugin;
        ReadableByteChannel rbc = null;
        FileOutputStream fos = null;
        File f = new File(this.plugin.getDataFolder(), "config.yml");
        try {
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
        YamlConfiguration yaml = YamlConfiguration.loadConfiguration(f);
        
    }
    
    public String newBaxFax() {
        return null;
    }

}
