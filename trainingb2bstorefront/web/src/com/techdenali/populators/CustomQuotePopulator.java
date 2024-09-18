/**
 *
 */
package com.techdenali.populators;

import de.hybris.platform.commercefacades.quote.data.QuoteData;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import com.techdenali.storefront.forms.CustomGuestForm;


/**
 *
 */
public class CustomQuotePopulator implements Populator<CustomGuestForm, QuoteData> {
   @Override
   public void populate(final CustomGuestForm source, final QuoteData target) throws ConversionException {
		/*
		 * target.setName(source.getName()); target.setContactNum(source.getContactNum());
		 * target.setComments(source.getComments()); target.setCompany(source.getCompany()); target.setEmail(source.getEmail());
		 */
   }
}