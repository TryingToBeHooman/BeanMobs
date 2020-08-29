package me.tryingtobehooman.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pillager;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Stray;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public class Listeners implements Listener {
	
	@EventHandler
    public void creatureSpawn(final CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.CREEPER) {
            final Creeper creeper = (Creeper)event.getEntity();
            creeper.setPowered(true);
		}
		
		if(event.getEntityType() == EntityType.ZOMBIE) {
			
			final Zombie zombie = (Zombie) event.getEntity();
			
			zombie.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			zombie.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
			zombie.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
			zombie.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
			
			zombie.getEquipment().setBootsDropChance((float) 0.0D);
			zombie.getEquipment().setHelmetDropChance((float) 0.0D);
			zombie.getEquipment().setChestplateDropChance((float) 0.0D);
			zombie.getEquipment().setLeggingsDropChance((float) 0.0D);
			
			final ItemStack beanSword = new ItemStack(Material.NETHERITE_SWORD);
			beanSword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 15);
			beanSword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 10);
			zombie.getEquipment().setItemInMainHand(beanSword);
			zombie.getEquipment().setItemInMainHandDropChance((float) 0.0D);
			
		}
		
		if(event.getEntityType() == EntityType.SKELETON) {
			
			final Skeleton skeleton = (Skeleton) event.getEntity();
			
			skeleton.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			
			final ItemStack beanBow = new ItemStack(Material.BOW);
			
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 15);
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 32767);
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
			skeleton.getEquipment().setItemInMainHand(beanBow);
			
			skeleton.getEquipment().setHelmetDropChance((float) 0.0D);
			skeleton.getEquipment().setItemInMainHandDropChance((float) 0.0D);
			
		}
		
		if(event.getEntityType() == EntityType.STRAY) {
			
			final Stray stray = (Stray) event.getEntity();
			
			stray.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			
			final ItemStack beanBow = new ItemStack(Material.BOW);
			
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 15);
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 32767);
			beanBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
			stray.getEquipment().setItemInMainHand(beanBow);
			
			stray.getEquipment().setHelmetDropChance((float) 0.0D);
			stray.getEquipment().setItemInMainHandDropChance((float) 0.0D);
		}
		
		if(event.getEntityType() == EntityType.PILLAGER) {
			
			final Pillager pillager = (Pillager) event.getEntity();
			
			pillager.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			pillager.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
			pillager.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
			pillager.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
			
			final ItemStack beanCrossBow = new ItemStack(Material.CROSSBOW);
			
			beanCrossBow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 15);
			beanCrossBow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 32767);
			beanCrossBow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 10);
			pillager.getEquipment().setItemInMainHand(beanCrossBow);
			
			pillager.getEquipment().setHelmetDropChance((float) 0.0D);
			pillager.getEquipment().setChestplateDropChance((float) 0.0D);
			pillager.getEquipment().setLeggingsDropChance((float) 0.0D);
			pillager.getEquipment().setBootsDropChance((float) 0.0D);
			pillager.getEquipment().setItemInMainHandDropChance((float) 0.0D);
		}
		
		if(event.getEntityType() == EntityType.SPIDER) {
			
			final Spider spider = (Spider) event.getEntity();
			
			spider.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			spider.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
			spider.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
			spider.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
			
			spider.getEquipment().setHelmetDropChance((float) 0.0D);
			spider.getEquipment().setChestplateDropChance((float) 0.0D);
			spider.getEquipment().setLeggingsDropChance((float) 0.0D);
			spider.getEquipment().setBootsDropChance((float) 0.0D);
		}
		
		if(event.getEntityType() == EntityType.CAVE_SPIDER) {
			
			final CaveSpider cavespider = (CaveSpider) event.getEntity();
			
			cavespider.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			cavespider.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
			cavespider.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
			cavespider.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
			
			cavespider.getEquipment().setHelmetDropChance((float) 0.0D);
			cavespider.getEquipment().setChestplateDropChance((float) 0.0D);
			cavespider.getEquipment().setLeggingsDropChance((float) 0.0D);
			cavespider.getEquipment().setBootsDropChance((float) 0.0D);

		}
	}
}