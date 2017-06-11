package com.github.lazylazuli.lib.common.item;

import com.github.lazylazuli.lib.common.block.BlockDyed;
import mcp.MethodsReturnNonnullByDefault;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ItemBlockDyed extends ItemBlockBase
{
	public ItemBlockDyed(BlockDyed blockdyed)
	{
		super(blockdyed);
		setMaxDamage(0);
		setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
	
	@Override
	public String getHighlightTip(ItemStack stack, String displayName)
	{
		return I18n.translateToLocal(getUnlocalizedColor(stack)) + " " + displayName;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
	{
		tooltip.add("Color: " + I18n.translateToLocal(getUnlocalizedColor(stack)));
		
		super.addInformation(stack, playerIn, tooltip, advanced);
	}
	
	public String getUnlocalizedColor(ItemStack stack)
	{
		return "color." + EnumDyeColor.byMetadata(stack.getMetadata())
									  .getName() + ".name";
	}
}