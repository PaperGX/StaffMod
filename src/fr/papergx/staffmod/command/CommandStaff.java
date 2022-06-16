package fr.papergx.staffmod.command;

import fr.papergx.staffmod.StaffMod;
import fr.papergx.staffmod.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.UUID;

public class CommandStaff implements CommandExecutor {

    public List<UUID> listModerator = StaffMod.listModerator;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(!(commandSender instanceof Player)) {return false;}

        Player player = (Player) commandSender;

        if(!(player.hasPermission("staffmod.mod"))) {player.sendMessage("§c| Tu n'as pas la permission de faire cela"); return false;}

        if(strings.length >= 1) {player.sendMessage("| correct usgae : /staff");return false;}

        if (listModerator.contains(player.getUniqueId())) {
            player.getInventory().clear();
            listModerator.remove(player.getUniqueId());
            player.sendMessage("| Mode moderation : §cOFF");
        } else {
            listModerator.add(player.getUniqueId());
            player.getInventory().clear();
            this.getItem(player);
            player.sendMessage("| Mode moderation : §2ON");
        }
        return false;
    }

    private void getItem(Player player) {
        ItemStack knockbackTester = new ItemBuilder(Material.WOOD_SWORD, 1).addName("§6KnockBack Tester").addLore("§7Permet de tester le knockback d'un joeur").build();
        ItemStack inventoryChecker = new ItemBuilder(Material.CHEST,1).addName("§6Inventory Checker").addLore("§7Permet de voir l'inventaire d'un joueur").build();
        ItemStack vanish = new ItemBuilder(Material.INK_SACK, 1, 1).addName("§6Vanish").addLore("§7Permet de te mettre en invisible").build();

        player.getInventory().setItem(0, knockbackTester);
        player.getInventory().setItem(4, inventoryChecker);
        player.getInventory().setItem(8, vanish);
    }
}
