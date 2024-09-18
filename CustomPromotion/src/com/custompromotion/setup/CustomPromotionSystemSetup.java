/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.custompromotion.setup;

import static com.custompromotion.constants.CustomPromotionConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.custompromotion.constants.CustomPromotionConstants;
import com.custompromotion.service.CustomPromotionService;


@SystemSetup(extension = CustomPromotionConstants.EXTENSIONNAME)
public class CustomPromotionSystemSetup
{
	private final CustomPromotionService CustomPromotionService;

	public CustomPromotionSystemSetup(final CustomPromotionService CustomPromotionService)
	{
		this.CustomPromotionService = CustomPromotionService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		CustomPromotionService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return CustomPromotionSystemSetup.class.getResourceAsStream("/CustomPromotion/sap-hybris-platform.png");
	}
}
