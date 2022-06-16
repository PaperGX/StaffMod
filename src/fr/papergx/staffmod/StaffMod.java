package fr.papergx.staffmod;

import fr.papergx.staffmod.command.CommandStaff;
import fr.papergx.staffmod.listners.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffMod extends JavaPlugin {
    public StaffMod instance;
    public static List<UUID> listModerator = new ArrayList<>();
    @Override
    public void onEnable() {
        this.instance = this;
        getCommand("staff").setExecutor(new CommandStaff());
        getServer().getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {

    }

    public StaffMod getInstance() {
        return instance;
    }
}
