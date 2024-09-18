/**
 *
 */
package com.techdenali.storefront.controllers.pages;

import de.hybris.platform.acceleratorfacades.cart.action.CartEntryActionFacade;
import de.hybris.platform.acceleratorfacades.csv.CsvFacade;
import de.hybris.platform.acceleratorstorefrontcommons.breadcrumb.ResourceBreadcrumbBuilder;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.pages.AbstractPageController;
import de.hybris.platform.acceleratorstorefrontcommons.controllers.util.GlobalMessages;
import de.hybris.platform.acceleratorstorefrontcommons.forms.validation.SaveCartFormValidator;
import de.hybris.platform.commercefacades.order.CartFacade;
import de.hybris.platform.commercefacades.order.QuoteFacade;
import de.hybris.platform.commercefacades.order.SaveCartFacade;
import de.hybris.platform.commercefacades.product.ProductFacade;
import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.commercefacades.voucher.VoucherFacade;
import de.hybris.platform.commercefacades.voucher.data.VoucherData;
import de.hybris.platform.commercefacades.voucher.exceptions.VoucherOperationException;
import de.hybris.platform.commerceservices.security.BruteForceAttackHandler;
import de.hybris.platform.enumeration.EnumerationService;
import de.hybris.platform.order.CartService;
import de.hybris.platform.servicelayer.user.UserService;
import de.hybris.platform.site.BaseSiteService;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


/**
 *
 */
@Controller
@RequestMapping("/guestForm")
public class GuestFormController extends AbstractPageController
{

	private static final String REDIRECT_QUOTE_LIST_URL = REDIRECT_PREFIX + "/my-account/my-quotes/";
	private static final String REDIRECT_QUOTE_DETAILS_URL = REDIRECT_PREFIX + "/my-account/my-quotes/%s/";
	private static final String QUOTE_EDIT_CMS_PAGE = "quoteEditPage";
	private static final String ALLOWED_ACTIONS = "allowedActions";
	private static final String DATE_FORMAT_KEY = "text.quote.dateformat";

	// localization properties
	private static final String PAGINATION_NUMBER_OF_COMMENTS = "quote.pagination.numberofcomments";
	private static final String QUOTE_EMPTY_CART_ERROR = "quote.cart.empty.error";
	private static final String QUOTE_REQUOTE_ERROR = "quote.requote.error";
	private static final String QUOTE_NOT_EDITABLE_ERROR = "quote.not.editable";
	private static final String QUOTE_EDIT_LOCKED_ERROR = "quote.edit.locked";
	private static final String QUOTE_TEXT_CANCEL_SUCCESS = "text.quote.cancel.success";
	private static final String QUOTE_TEXT_NOT_CANCELABLE = "text.quote.not.cancelable";
	private static final String QUOTE_NOT_SUBMITABLE_ERROR = "text.quote.not.submitable";
	private static final String QUOTE_NEWCART_ERROR = "quote.newcart.error";
	private static final String QUOTE_NEWCART_SUCCESS = "quote.newcart.success";
	private static final String QUOTE_SAVE_CART_ERROR = "quote.save.cart.error";
	private static final String QUOTE_SUBMIT_ERROR = "quote.submit.error";
	private static final String QUOTE_SUBMIT_SUCCESS = "quote.submit.success";
	private static final String QUOTE_EXPIRED = "quote.state.expired";
	private static final String QUOTE_REJECT_INITIATION_REQUEST = "quote.reject.initiate.request";
	private static final String QUOTE_CART_INSUFFICIENT_ACCESS_RIGHTS = "quote.cart.insufficient.access.rights.error";
	public static final String SHOW_CHECKOUT_STRATEGY_OPTIONS = "storefront.show.checkout.flows";
	public static final String ERROR_MSG_TYPE = "errorMsg";
	public static final String SUCCESSFUL_MODIFICATION_CODE = "success";
	public static final String VOUCHER_FORM = "voucherForm";
	public static final String SITE_QUOTES_ENABLED = "site.quotes.enabled.";
	private static final String CART_CHECKOUT_ERROR = "cart.checkout.error";

	private static final String ACTION_CODE_PATH_VARIABLE_PATTERN = "{actionCode:.*}";
	private static final String QUOTE_CREATE_ERROR = "quote.create.error";

	private static final String REDIRECT_CART_URL = REDIRECT_PREFIX + "/cart";
	private static final String REDIRECT_QUOTE_EDIT_URL = REDIRECT_PREFIX + "/quote/%s/edit/";
	private static final String REDIRECT_QUOTE_VIEW_URL = REDIRECT_PREFIX + "/my-account/my-quotes/%s/";

	private static final String GuestQuoteFormPopup = "fragments/guest/GuestForm";

	private static final Logger LOG = Logger.getLogger(GuestFormController.class);
	private HttpSessionRequestCache httpSessionRequestCache;
	private CartFacade cartFacade;

	@Resource(name = "quoteFacade")
	private QuoteFacade quoteFacade;

	@Resource
	private UserService userService;

	@Resource
	private CartService cartService;

	@Resource(name = "simpleBreadcrumbBuilder")
	private ResourceBreadcrumbBuilder resourceBreadcrumbBuilder;

	@Resource(name = "enumerationService")
	private EnumerationService enumerationService;

	@Resource(name = "productVariantFacade")
	private ProductFacade productFacade;

	@Resource(name = "saveCartFacade")
	private SaveCartFacade saveCartFacade;

	@Resource(name = "saveCartFormValidator")
	private SaveCartFormValidator saveCartFormValidator;

	@Resource(name = "csvFacade")
	private CsvFacade csvFacade;

	@Resource(name = "voucherFacade")
	private VoucherFacade voucherFacade;

	@Resource(name = "baseSiteService")
	private BaseSiteService baseSiteService;

	@Resource(name = "cartEntryActionFacade")
	private CartEntryActionFacade cartEntryActionFacade;

	@Resource(name = "bruteForceAttackHandler")
	private BruteForceAttackHandler bruteForceAttackHandler;

	@ModelAttribute("showCheckoutStrategies")
	public boolean isCheckoutStrategyVisible()
	{
		return getSiteConfigService().getBoolean(SHOW_CHECKOUT_STRATEGY_OPTIONS, false);
	}


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

	@RequestMapping(value = "/guestCreate", method = RequestMethod.POST)
	public String guestQuote(final RedirectAttributes redirectModel, @RequestParam("name") final String name,

			@RequestParam("contactNum") final String contactNum, @RequestParam("comments") final String comments,

			@RequestParam("company") final String company, @RequestParam("email") final String email)
	{
		final QuoteData quoteData = getQuoteFacade().initiateQuote();

		return String.format(REDIRECT_QUOTE_EDIT_URL, urlEncode(quoteData.getCode()));

	}

	/*
	 * @RequestMapping(value = "/guestCreate", method = RequestMethod.POST) public String
	 * guestQuote(@ModelAttribute("CustomGuestForm") @Valid final CustomGuestForm guestQuoteForm, final BindingResult
	 * bindingResult, final RedirectAttributes redirectModel)
	 *
	 * {
	 *
	 * if (bindingResult.hasErrors()) { for (final ObjectError error : bindingResult.getAllErrors()) {
	 * redirectModel.addFlashAttribute("error", error.getDefaultMessage()); } return REDIRECT_CART_URL; }
	 *
	 * try { removeCoupons(redirectModel);
	 *
	 * final QuoteData quoteData = getQuoteFacade().initiateQuote(); // Redirect to the quote edit page return
	 * String.format(REDIRECT_QUOTE_EDIT_URL, urlEncode(quoteData.getCode())); } catch (final IllegalStateException |
	 * UnknownIdentifierException | ModelSavingException | IllegalArgumentException e) {
	 * redirectModel.addFlashAttribute("error", "An error occurred while processing your quote request.");
	 * LOG.error("Error submitting guest quote request", e); return REDIRECT_CART_URL; } }
	 */

	protected CartFacade getCartFacade()
	{
		return cartFacade;
	}

	@Required
	public void setCartFacade(final CartFacade cartFacade)
	{
		this.cartFacade = cartFacade;
	}

	protected void removeCoupons(final RedirectAttributes redirectModel)
	{
		final List<VoucherData> vouchers = voucherFacade.getVouchersForCart();

		for (final VoucherData voucher : vouchers)
		{
			try
			{
				voucherFacade.releaseVoucher(voucher.getCode());
			}
			catch (final VoucherOperationException e)
			{
				GlobalMessages.addFlashMessage(redirectModel, GlobalMessages.ERROR_MESSAGES_HOLDER, "text.voucher.release.error",
						new Object[]
						{ voucher.getCode() });
				if (LOG.isDebugEnabled())
				{
					LOG.debug(e.getMessage(), e);
				}
			}
		}
	}
}
