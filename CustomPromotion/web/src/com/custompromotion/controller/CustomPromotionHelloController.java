/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.custompromotion.controller;

import static com.custompromotion.constants.CustomPromotionConstants.PLATFORM_LOGO_CODE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.custompromotion.service.CustomPromotionService;


@Controller
public class CustomPromotionHelloController
{
	@Autowired
	private CustomPromotionService CustomPromotionService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(final ModelMap model)
	{
		model.addAttribute("logoUrl", CustomPromotionService.getHybrisLogoUrl(PLATFORM_LOGO_CODE));
		return "welcome";
	}
}
