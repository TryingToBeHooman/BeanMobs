package me.tryingtobehooman;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
	public final int TIER_AMOUNT = 3;
	public ItemStack[] beanSword, beanBow, beanCrossBow, beanHelmet, beanPlate, beanLeggings, beanBoots;

	public Items(Main plugin) {
		beanSword = new ItemStack[TIER_AMOUNT];
		beanBow = new ItemStack[TIER_AMOUNT];
		beanCrossBow = new ItemStack[TIER_AMOUNT];
		beanHelmet = new ItemStack[TIER_AMOUNT];
		beanPlate = new ItemStack[TIER_AMOUNT];
		beanLeggings = new ItemStack[TIER_AMOUNT];
		beanBoots = new ItemStack[TIER_AMOUNT];
		for (int i = 0; i < TIER_AMOUNT; i++) {
			plugin.getLogger().warning(Integer.toString(i));
			beanPlate[i] = new ItemStack(Material.LEATHER_CHESTPLATE);
			LeatherArmorMeta colorMeta = (LeatherArmorMeta) beanPlate[i].getItemMeta();
			Material swordMaterial;
			switch (i) {
			case 2:
				colorMeta.setColor(Color.RED);
				swordMaterial = Material.DIAMOND_SWORD;
				break;
			case 1:
				colorMeta.setColor(Color.YELLOW);
				swordMaterial = Material.IRON_SWORD;
				break;
			case 0:
				colorMeta.setColor(Color.GREEN);
				swordMaterial = Material.STONE_SWORD;
				break;
			default:
				swordMaterial = Material.WOODEN_SWORD;
				break;
			}
			beanPlate[i].setItemMeta(colorMeta);
			beanPlate[i].addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, i * 2 + 1);
			
			
			beanSword[i] = new ItemStack(swordMaterial);
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

			beanHelmet[i] = new ItemStack(Material.IRON_HELMET);
			beanHelmet[i].addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, i * 2 + 1);
			beanLeggings[i] = new ItemStack(Material.CHAINMAIL_LEGGINGS);
			beanLeggings[i].addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, i * 2 + 1);
			beanBoots[i] = new ItemStack(Material.GOLDEN_BOOTS);
			beanBoots[i].addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, i * 2 + 1);
		}
	}

	public void getGear(LivingEntity entity, int tier) {
		if(tier==-1) {
			entity.getEquipment().clear();
			return;
		}
		boolean fullArmor = false;
		switch (entity.getType()) {
		case CREEPER:
			((Creeper) entity).setPowered(true);
			break;

		case ZOMBIE:
			fullArmor = true;
			entity.getEquipment().setItemInMainHand(new ItemStack(beanSword[tier]));
			break;

		case SKELETON:
			entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
			entity.getEquipment().setItemInMainHand(new ItemStack(beanBow[tier]));
			entity.getEquipment().setHelmetDropChance(0.0F);
			entity.getEquipment().setItemInMainHandDropChance(0.0F);
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

		if (fullArmor) {
			entity.getEquipment().setHelmet(new ItemStack(beanHelmet[tier]));
			entity.getEquipment().setChestplate(new ItemStack(beanPlate[tier]));
			entity.getEquipment().setLeggings(new ItemStack(beanLeggings[tier]));
			entity.getEquipment().setBoots(new ItemStack(beanBoots[tier]));

			entity.getEquipment().setHelmetDropChance(0.0F);
			entity.getEquipment().setChestplateDropChance(0.0F);
			entity.getEquipment().setLeggingsDropChance(0.0F);
			entity.getEquipment().setBootsDropChance(0.0F);
		}
	}
}
