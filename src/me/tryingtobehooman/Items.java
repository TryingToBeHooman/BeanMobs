package me.tryingtobehooman;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
	public final int TIER_AMOUNT = 3;
	public ItemStack[] beanSword, beanBow, beanCrossBow, colorPlate = new ItemStack[TIER_AMOUNT];

	public Items() {
		for (int i = TIER_AMOUNT - 1; i >= 0; i++) {
			colorPlate[i] = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta colorMeta = (LeatherArmorMeta) colorPlate[i].getItemMeta();
			switch (i) {
			case 2:
				colorMeta.setColor(Color.RED);
				break;
			case 1:
				colorMeta.setColor(Color.YELLOW);
				break;
			case 0:
				colorMeta.setColor(Color.GREEN);
				break;
			}
			colorPlate[i].setItemMeta(colorMeta);
			colorPlate[i].addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, i * 2 + 1);

			beanSword[i] = new ItemStack(Material.DIAMOND_SWORD);
			beanSword[i].addUnsafeEnchantment(Enchantment.DAMAGE_ALL, i * 2);
			beanSword[i].addUnsafeEnchantment(Enchantment.KNOCKBACK, i);

			beanBow[i] = new ItemStack(Material.BOW);
			beanBow[i].addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, i * 2 + 1);
			beanBow[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, i * 2);
			beanBow[i].addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, i);

			beanCrossBow[i] = new ItemStack(Material.CROSSBOW);
			beanCrossBow[i].addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, i * 2 + 1);
			beanCrossBow[i].addUnsafeEnchantment(Enchantment.ARROW_FIRE, i * 2);
			beanCrossBow[i].addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, i);
		}
	}
	
	public void getGear(LivingEntity entity, int tier) {
		boolean fullArmor = false;
		switch (entity.getType()) {
		case CREEPER:
			((Creeper) entity).setPowered(true);
			break;

		case ZOMBIE:
			Zombie zombie = (Zombie) entity;
			fullArmor = true;
			zombie.getEquipment().setItemInMainHand(new ItemStack(beanSword[tier]));
			break;

		case SKELETON:
			Skeleton skeleton = (Skeleton) entity;
			skeleton.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			skeleton.getEquipment().setItemInMainHand(new ItemStack(beanBow[tier]));
			skeleton.getEquipment().setHelmetDropChance(0.0F);
			skeleton.getEquipment().setItemInMainHandDropChance(0.0F);
			break;

		case STRAY:
			entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			entity.getEquipment().setItemInMainHand(new ItemStack(beanBow[tier]));
			entity.getEquipment().setHelmetDropChance(0.0F);
			entity.getEquipment().setItemInMainHandDropChance(0.0F);
			break;

		case PILLAGER:
			entity.getEquipment().setItemInMainHand(new ItemStack(beanCrossBow[tier]));
			fullArmor = true;
			break;

		case SPIDER:
			fullArmor = true;
			break;

		case CAVE_SPIDER:
			fullArmor = true;
			break;

		default:
			return;
		}

		entity.addScoreboardTag("beanmobsgear");

		if (fullArmor) {
			entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
			entity.getEquipment().setChestplate(new ItemStack(colorPlate[tier]));

			entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
			entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
			entity.getEquipment().setHelmetDropChance(0.0F);
			entity.getEquipment().setChestplateDropChance(0.0F);
			entity.getEquipment().setLeggingsDropChance(0.0F);
			entity.getEquipment().setBootsDropChance(0.0F);
		}
	}
}
