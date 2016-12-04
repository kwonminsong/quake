/**
 * @file SlotActor.java
 * @brief SlotActor
 */

package com.quakesurvival.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.quakesurvival.game.attribute.Assets;
import com.quakesurvival.game.controls.Slot;
import com.quakesurvival.game.controls.SlotListener;
import com.quakesurvival.game.controls.TooltipHandler;
import com.quakesurvival.windows.SlotTooltip;

public class SlotActor extends ImageButton implements SlotListener 
{
	private Slot slot;
	private Skin skin;

	/** @brief
	 * 
	 * @param stage
	 * @param skin
	 * @param slot
	 */
	public SlotActor(Stage stage, Skin skin, Slot slot) 
	{
		super(createStyle(skin, slot));
		this.slot = slot;
		this.skin = skin;

		slot.addListener(this);

		SlotTooltip tooltip = new SlotTooltip(slot, skin);
		tooltip.setTouchable(Touchable.disabled); 
		stage.addActor(tooltip);
		addListener(new TooltipHandler(tooltip, true));
	}

	/** @brief
	 */
	private static ImageButtonStyle createStyle(Skin skin, Slot slot) 
	{
		TextureAtlas icons = Assets.textureAtlas;
		TextureRegion image;
		if (slot.getItem() != null) 
		{
			image = icons.findRegion(slot.getItem().getTextureRegion());
		} 
		else 
		{
			image = icons.findRegion("nothing");
		}
		ImageButtonStyle style = new ImageButtonStyle(skin.get(ButtonStyle.class));
		style.imageUp = new TextureRegionDrawable(image);
		style.imageDown = new TextureRegionDrawable(image);

		return style;
	}

	/** @brief
	 */
	public Slot getSlot() 
	{
		return slot;
	}

	/** @brief
	 */
	@Override
	public void hasChanged(Slot slot) 
	{
		setStyle(createStyle(skin, slot));
	}

}
