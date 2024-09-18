/**
 *
 */
package com.techdenali.core.event;


import de.hybris.platform.commerceservices.enums.QuoteUserType;
import de.hybris.platform.commerceservices.event.QuoteBuyerSubmitEvent;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.core.model.user.UserModel;



/**
 * Event to indicate that Guest submitted a quote.
 */
public class GuestQuoteBuyerSubmitEvent extends QuoteBuyerSubmitEvent
{
	/**
	 * @param quote
	 * @param userModel
	 * @param quoteUserType
	 */
	public GuestQuoteBuyerSubmitEvent(final QuoteModel quote, final UserModel userModel, final QuoteUserType quoteUserType)
	{
		super(quote, userModel, quoteUserType);
	}

}




