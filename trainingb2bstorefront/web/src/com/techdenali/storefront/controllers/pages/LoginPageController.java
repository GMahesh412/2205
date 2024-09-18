/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.techdenali.storefront.controllers.pages;

import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractLoginPageController;
import de.hybris.platform.acceleratorstorefrontcommons.forms.RegisterForm;
import de.hybris.platform.cms2.exceptions.CMSItemNotFoundException;
import de.hybris.platform.cms2.model.pages.AbstractPageModel;
import de.hybris.platform.cms2.model.pages.ContentPageModel;
import de.hybris.platform.commercefacades.order.QuoteFacade;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.user.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techdenali.storefront.controllers.ControllerConstants;


/**
 * Login Controller. Handles login and register for the account flow.
 */
@Controller
@RequestMapping(value = "/login")
public class LoginPageController extends AbstractLoginPageController
{

	private static final Logger LOG = Logger.getLogger(LoginPageController.class);

	private HttpSessionRequestCache httpSessionRequestCache;

	@Resource(name = "quoteFacade")
	private QuoteFacade quoteFacade;

	@Resource
	private UserService userService;

	@Resource
	private CartService cartService;

	protected UserService getUserService()
	{
		return userService;
	}

	protected CartService getCartService()
	{
		return cartService;
	}

	protected QuoteFacade getQuoteFacade()
	{
		return quoteFacade;
	}

	@Override
	protected String getView()
	{
		return ControllerConstants.Views.Pages.Account.AccountLoginPage;
	}

	@Override
	protected String getSuccessRedirect(final HttpServletRequest request, final HttpServletResponse response)
	{
		if (httpSessionRequestCache.getRequest(request, response) != null)
		{
			return httpSessionRequestCache.getRequest(request, response).getRedirectUrl();
		}
		return "/";
	}

	@Override
	protected AbstractPageModel getCmsPage() throws CMSItemNotFoundException
	{
		return getContentPageForLabelOrId("login");
	}


	@Resource(name = "httpSessionRequestCache")
	public void setHttpSessionRequestCache(final HttpSessionRequestCache accHttpSessionRequestCache)
	{
		this.httpSessionRequestCache = accHttpSessionRequestCache;
	}

	/*
	 * @RequestMapping(method = RequestMethod.GET) public String doLogin(@RequestHeader(value = "referer", required = false)
	 * final String referer,
	 *
	 * @RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model, final
	 * HttpServletRequest request, final HttpServletResponse response, final HttpSession session) throws
	 * CMSItemNotFoundException { // Store referer if no login error
	 *
	 * if (!loginError) { storeReferer(referer, request, response); }
	 *
	 *
	 * // Check if the user is anonymous or registered if (!isAnonymousUser()) {
	 * LOG.info(" Redirecting to the quote view or login page.Current Registered user Name is:" +
	 * userService.getCurrentUser().getName());
	 *
	 * // If the user is registered, proceed to the login page or the quote view URL return
	 * ControllerConstants.Views.Pages.Account.AccountLoginPage; } else {
	 *
	 * LOG.info("Redirecting to the Guest Form  & Current Guest user name is: " + userService.getCurrentUser().getName());
	 * model.addAttribute("CustomGuestForm", new CustomGuestForm()); // If the user is anonymous, redirect to the Guest
	 * Quote Form page return ControllerConstants.Views.Fragments.Guest.GuestQuoteFormPopup; } }
	 *
	 * private boolean isAnonymousUser() { return getUserService().isAnonymousUser(userService.getCurrentUser()); }
	 *
	 * protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse
	 * response) { if (StringUtils.isNotBlank(referer) && !StringUtils.endsWith(referer, "/login") &&
	 * StringUtils.contains(referer, request.getServerName())) { httpSessionRequestCache.saveRequest(request, response); } }
	 */


	@RequestMapping(method = RequestMethod.GET)
	public String doLogin(@RequestHeader(value = "referer", required = false) final String referer,

			@RequestParam(value = "error", defaultValue = "false") final boolean loginError, final Model model,
			final HttpServletRequest request, final HttpServletResponse response, final HttpSession session)
			throws CMSItemNotFoundException
	{
		if (!loginError)
		{
			storeReferer(referer, request, response);
		}
		return getDefaultLoginPage(loginError, session, model);
		//return ControllerConstants.Views.Fragments.Guest.GuestQuoteFormPopup;

	}

	protected void storeReferer(final String referer, final HttpServletRequest request, final HttpServletResponse response)
	{
		if (StringUtils.isNotBlank(referer) && !StringUtils.endsWith(referer, "/login")
				&& StringUtils.contains(referer, request.getServerName()))
		{
			httpSessionRequestCache.saveRequest(request, response);
		}
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegister(@RequestHeader(value = "referer", required = false) final String referer, final RegisterForm form,
			final BindingResult bindingResult, final Model model, final HttpServletRequest request,
			final HttpServletResponse response, final RedirectAttributes redirectModel) throws CMSItemNotFoundException
	{
		getRegistrationValidator().validate(form, bindingResult);
		return processRegisterUserRequest(referer, form, bindingResult, model, request, response, redirectModel);
	}

	@RequestMapping(value = "/register/termsandconditions", method = RequestMethod.GET)
	public String getTermsAndConditions(final Model model) throws CMSItemNotFoundException
	{
		final ContentPageModel pageForRequest = getCmsPageService().getPageForLabel("/termsAndConditions");
		storeCmsPageInModel(model, pageForRequest);
		setUpMetaDataForContentPage(model, pageForRequest);
		return ControllerConstants.Views.Fragments.Checkout.TermsAndConditionsPopup;
	}
}
