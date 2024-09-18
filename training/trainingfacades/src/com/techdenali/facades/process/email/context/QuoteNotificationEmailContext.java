/*
 * Copyright (c) 2021 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.techdenali.facades.process.email.context;

import de.hybris.platform.acceleratorservices.email.EmailService;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.acceleratorservices.process.email.context.AbstractEmailContext;
import de.hybris.platform.basecommerce.model.site.BaseSiteModel;
import de.hybris.platform.commercefacades.product.data.ProductData;
import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.commercefacades.user.UserFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.model.process.QuoteProcessModel;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.core.model.user.UserModel;
import de.hybris.platform.order.QuoteService;
import de.hybris.platform.servicelayer.dto.converter.Converter;
import de.hybris.platform.servicelayer.user.UserService;

import java.util.Optional;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

/*import com.techdenali.storefront.forms.CustomGuestForm;
*/


/**
 * Velocity context for a quote notification email.
 */
public class QuoteNotificationEmailContext extends AbstractEmailContext<QuoteProcessModel>
{
	private static final Logger LOG = Logger.getLogger(QuoteNotificationEmailContext.class);
	public static final String TITLE = "title";
	public static final String DISPLAY_NAME = "displayName";
	public static final String EMAIL = "email";
	private transient QuoteService quoteService;

	private transient Converter<QuoteModel, QuoteData> quoteConverter;

	private QuoteData quoteData;
	private transient Converter<UserModel, CustomerData> customerConverter;
	private CustomerData customerData;
	private transient Converter<ProductModel, ProductData> productConverter;
	private ProductData productData;

	@Resource
	private UserService userService;

	@Resource(name = "userFacade")
	private UserFacade userFacade;
	@Resource
	private EmailService emailService;



	@Override
	protected UserService getUserService()
	{
		return userService;
	}



	@Override
	public void init(final QuoteProcessModel quoteProcessModel, final EmailPageModel emailPageModel)
	{
		super.init(quoteProcessModel, emailPageModel);
		final QuoteModel quoteModel = getQuote(quoteProcessModel);

		quoteData = getQuoteConverter().convert(getQuote(quoteProcessModel));

	}

	public QuoteData getQuote()
	{
		return quoteData;
	}

	@Override
	protected BaseSiteModel getSite(final QuoteProcessModel quoteProcessModel)
	{
		return getQuote(quoteProcessModel).getSite();
	}

	/*
	 * @Override protected CustomerModel getCustomer(final QuoteProcessModel quoteProcessModel) { return (CustomerModel)
	 * getQuote(quoteProcessModel).getUser(); }
	 */
	/*
	 * @Override protected CustomerModel getCustomer(final QuoteProcessModel quoteProcessModel) { final boolean isGuest =
	 * userFacade.isAnonymousUser(); // Check if the user is a guest or registered if (isGuest) {
	 * LOG.info(" Current Guest user name is: " + userService.getCurrentUser().getName());
	 *
	 * // if user is guest, final CustomerModel guestCustomer = new CustomerModel(); //final CustomGuestForm customGuestForm
	 * = new CustomGuestForm(); // GuestForm form = new GuestForm();
	 * guestCustomer.setName(userService.getCurrentUser().getName()); //guestCustomer.setContactEmail();
	 *
	 * guestCustomer.setName(customGuestForm.getName()); form.setEmail(customGuestForm.getEmail());
	 *
	 * return guestCustomer; } else { // if user is registered, return CustomerModel return (CustomerModel)
	 * getQuote(quoteProcessModel).getUser(); } }
	 */
	@Override
	protected CustomerModel getCustomer(final QuoteProcessModel quoteProcessModel)
	{
		return (CustomerModel) getQuote(quoteProcessModel).getUser();
	}

	@Override
	protected LanguageModel getEmailLanguage(final QuoteProcessModel quoteProcessModel)
	{

		final boolean isGuest = userFacade.isAnonymousUser();
		//  if the user is a guest
		if (isGuest)
		{
			LOG.info("Current Guest user name is: " + userService.getCurrentUser().getName());

			//  user isa guest, return  default lang
			return getQuote(quoteProcessModel).getSite().getDefaultLanguage();
		}
		else
		{
			//user is registered, return  session lang
			return getCustomer(quoteProcessModel).getSessionLanguage();
		}
	}

	protected QuoteModel getQuote(final QuoteProcessModel quoteProcessModel)
	{
		return Optional.of(quoteProcessModel).map(QuoteProcessModel::getQuoteCode).map(getQuoteService()::getCurrentQuoteForCode)
				.orElseThrow();
	}

	@Required
	public void setQuoteService(final QuoteService quoteService)
	{
		this.quoteService = quoteService;
	}

	protected QuoteService getQuoteService()
	{
		return quoteService;
	}

	@Required
	public void setQuoteConverter(final Converter<QuoteModel, QuoteData> quoteConverter)
	{
		this.quoteConverter = quoteConverter;
	}

	protected Converter<QuoteModel, QuoteData> getQuoteConverter()
	{
		return quoteConverter;
	}
}
