/**
 * @file Item.java
 * @brief Item
 */

package com.quakesurvival.game.attribute;
/**
 * @brief 아이템 목록
 * @n
 * @author 권민성 
 * @version 1.0.0
 */

public enum Item {

	NEWSPAPER("newspaper"), PLASTIC_BAG("plasticbag"), 
	PLASTIC_BOTTLE("plasticbottle"), SCISSORS("scissors"),
	BATTERY("battery"), NOTBATTERYFLASHLIGHT("notbatteryflashlight"), 
	BOWL("bowl"), LAGS("lags"), FLASHLIGHT("flashlight"), LAPPIN_GLIGHT("lappinglight"),
	CHECK_BREATH("checkbreath"), COMPRESSION("compression"), CONFIRM_CEREMONY("confirmceremony"),
	CPR("CPR"), HELP_REQUEST("HelpRequest");

	private String textureRegion;

	/** @brief
	 */
	private Item(String textureRegion) {
		this.textureRegion = textureRegion;
	}

	/** @brief
	 */
	public String getTextureRegion() {
		return textureRegion;
	}

}

