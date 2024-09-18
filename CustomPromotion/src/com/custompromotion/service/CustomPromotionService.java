/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.custompromotion.service;

public interface CustomPromotionService
{
	String getHybrisLogoUrl(String logoCode);

	void createLogo(String logoCode);
}
