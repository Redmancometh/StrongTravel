package StrongTravel;

import org.bukkit.Bukkit;
import org.bukkit.entity.Boat;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class SpeedListener implements Listener
{
    JavaPlugin jp;
    WorldGuardPlugin wp;
    Boolean inRegion = false;
    PotionEffect Travel = new PotionEffect(PotionEffectType.SPEED, 10, 60);

    public SpeedListener(JavaPlugin jp)
    {
	this.jp = jp;
	wp = (WorldGuardPlugin) jp.getServer().getPluginManager().getPlugin("WorldGuard");
    }

    @EventHandler
    public void startSpeed(PlayerMoveEvent e)
    {
	Player p = e.getPlayer();
	RegionManager rm = wp.getRegionManager(p.getWorld());
	ApplicableRegionSet rs = rm.getApplicableRegions(p.getLocation());
	inRegion = false;
	for (ProtectedRegion r : rs)
	{
	    if (r.getId().contains("travel"))
	    { 
		p.setWalkSpeed(1f);
		inRegion = true;
	    }
	}
	if (!inRegion)
	{
	    p.setWalkSpeed(.2f);
	}
    }

    /*
     * @EventHandler public void superSpeed(PlayerMoveEvent e) { Player p =
     * e.getPlayer(); if (p.isInsideVehicle()) { RegionManager rm =
     * wp.getRegionManager(p.getWorld()); ApplicableRegionSet rs =
     * rm.getApplicableRegions(p.getLocation()); inRegion = false; for
     * (ProtectedRegion r : rs) { if (r.getId().contains("travel")) { Minecart m
     * = (Minecart)p.getVehicle(); m.setMaxSpeed(50);
     * m.setVelocity(p.getLocation().getDirection().normalize().multiply(10));
     * inRegion = true; } } } }
     */
}
