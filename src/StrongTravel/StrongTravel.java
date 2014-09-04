package StrongTravel;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;



import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class StrongTravel extends JavaPlugin
{
    static WorldGuardPlugin wp;
    public void onEnable()
    {
	PluginManager pm = this.getServer().getPluginManager();
	pm.registerEvents(new SpeedListener(this), this);
    }

}
