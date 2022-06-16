package fr.papergx.staffmod.listners;

import fr.papergx.staffmod.StaffMod;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;
import java.util.UUID;

public class Listener implements org.bukkit.event.Listener {

    public List<UUID> listModerator = StaffMod.listModerator;

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        if(!listModerator.contains(player.getUniqueId())) {return;}

        if(event.getItem().getItemMeta().getDisplayName() != "§6Vanish") {return;}

        if(!(event.getAction().equals(Action.RIGHT_CLICK_AIR)) || !(event.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {player.sendMessage("6");return;}

        player.sendMessage("7");
    }
}
