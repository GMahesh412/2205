/**
 *
 */
package com.techdenali.core.event;

import de.hybris.platform.commerceservices.event.QuoteBuyerSubmitEvent;
import de.hybris.platform.commerceservices.model.process.QuoteProcessModel;
import de.hybris.platform.core.model.order.QuoteModel;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import com.techdenali.core.constants.TrainingCoreConstants;


/**
 * Event Listener for {@link QuoteBuyerSubmitEvent}. This Event Listener starts the quote buyer business process.
 */
public class GuestQuoteBuyerSubmitEventListener extends AbstractEventListener<GuestQuoteBuyerSubmitEvent>
{
	private ModelService modelService;
	private BusinessProcessService businessProcessService;
	private static final Logger LOG = Logger.getLogger(GuestQuoteBuyerSubmitEventListener.class);

	@Override
	protected void onEvent(final GuestQuoteBuyerSubmitEvent event)
	{
		if (LOG.isDebugEnabled())
		{
			LOG.debug("Received GuestQuoteBuyerSubmitEvent..");
		}

		final Map<String, Object> contextParams = new HashMap<String, Object>();
		contextParams.put(TrainingCoreConstants.QUOTE_USER_TYPE, event.getQuoteUserType());

		final QuoteProcessModel quoteBuyerProcessModel = (QuoteProcessModel) getBusinessProcessService()
				.createProcess(
						"guestQuoteBuyerProcess" + "-" + event.getQuote().getCode() + "-" + event.getQuote().getStore().getUid()
						+ "-" + System.currentTimeMillis(), TrainingCoreConstants.QUOTE_BUYER_PROCESS, contextParams);

		if (LOG.isDebugEnabled())
		{
			LOG.debug(String.format("Created business process for GuestQuoteBuyerSubmitEvent. Process code : [%s] ...",
					quoteBuyerProcessModel.getCode()));
		}

		final QuoteModel quoteModel = event.getQuote();
		quoteBuyerProcessModel.setQuoteCode(quoteModel.getCode());
		getModelService().save(quoteBuyerProcessModel);
		//start the business process
		getBusinessProcessService().startProcess(quoteBuyerProcessModel);

	}

	protected BusinessProcessService getBusinessProcessService()
	{
		return businessProcessService;
	}

	@Required
	public void setBusinessProcessService(final BusinessProcessService businessProcessService)
	{
		this.businessProcessService = businessProcessService;
	}

	protected ModelService getModelService()
	{
		return modelService;
	}

	@Required
	public void setModelService(final ModelService modelService)
	{
		this.modelService = modelService;
	}
}
