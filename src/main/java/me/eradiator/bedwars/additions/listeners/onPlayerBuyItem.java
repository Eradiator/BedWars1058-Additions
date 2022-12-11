package me.eradiator.bedwars.additions.listeners;

import com.andrei1058.bedwars.api.events.shop.ShopBuyEvent;
import com.cryptomorin.xseries.XMaterial;
import me.eradiator.bedwars.additions.Main;
import me.eradiator.bedwars.additions.utils.enums.path.MainPath;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class onPlayerBuyItem implements Listener {
    @EventHandler
    public void PlayerShopPurchase(ShopBuyEvent e){
        if (MainPath.UNBREAKABLE_MATERIAL_ENABLED.getBoolean()) {
            for (int i = 0; i< MainPath.UNBREAKABLE_MATERIAL.getStringList().size();i++) {
                Material material = XMaterial.valueOf(MainPath.UNBREAKABLE_MATERIAL.getStringList().get(i)).parseMaterial();
                if (e.getCategoryContent().getItemStack(e.getBuyer()).getType() == material) {
                    new BukkitRunnable(){
                        @Override
                        public void run() {
                            ItemMeta im = e.getCategoryContent().getItemStack(e.getBuyer()).getItemMeta();
                            assert im != null;
                            im.setUnbreakable(true);
                            e.getCategoryContent().getItemStack(e.getBuyer()).setItemMeta(im);
                        }
                    }.runTaskLater(Main.getInstance() , 10L);
                }
            }
        }
    }

}
