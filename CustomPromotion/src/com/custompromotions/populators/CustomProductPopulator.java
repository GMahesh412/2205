/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.custompromotions.populators;


import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.order.AbstractOrderEntryModel;
import de.hybris.platform.ruleengineservices.rao.OrderEntryRAO;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;


public class CustomProductPopulator implements Populator<AbstractOrderEntryModel, OrderEntryRAO>
{
	@Override
	public void populate(final AbstractOrderEntryModel source, final OrderEntryRAO target) throws ConversionException
	{
		if (source != null && source.getProduct() != null && source.getProduct().getCustomProduct() != null)
		{
			target.setCustomproduct(source.getProduct().getCustomProduct().getId());
		}
	}
}





































/*
 * @Override public void populate(final AbstractOrderEntryModel source, final OrderEntryRAO target) throws
 * ConversionException { target.setCustomproduct( source.getProduct().getCustomProduct().getId() != null ?
 * source.getProduct().getCustomProduct().getId() : "");
 *
 *
 * }
 */





/*
 * 1st priority code public class CustomProductPopulator extends CartRaoPopulator { private static final Logger LOG =
 * Logger.getLogger(CustomProductPopulator.class);
 *
 * public void populate(final ProductModel source, final CartRAO target) throws ConversionException {
 *
 * if (LOG.isDebugEnabled()) { LOG.debug("Populating ProductRAO from CustomProductModel with id: " +
 * source.getCustomProduct().getId()); } LOG.info("Populating ProductRAO from CustomProductModel with id: " +
 * source.getCustomProduct().getId());
 *
 * target.setActions(new LinkedHashSet()); target.setOriginalTotal(target.getOriginalTotal());
 * target.setTotal(target.getTotal()); target.setSubTotal(target.getSubTotal()); //
 * target.setDiscountValues(target.getDiscountValues()); target.setUser(target.getUser());
 * target.setTotalIncludingCharges(target.getTotalIncludingCharges()); target.setPaymentCost(target.getPaymentCost());
 * target.setDeliveryCost(target.getDeliveryCost()); // Copy the custom product code if available
 * target.setCustomProductCode(source.getCustomProduct().getId());
 *
 * if (LOG.isDebugEnabled()) { LOG.debug("Populated ProductRAO with custom product code: " +
 * target.getCustomProductCode()); } LOG.info("Populated ProductRAO with custom product code: " +
 * target.getCustomProductCode());
 *
 * } }
 */




























/*
 * 2nd priority public class CustomProductPopulator implements Populator<CustomProductModel, ProductRAO> {
 *
 * @Override public void populate(final CustomProductModel source, final ProductRAO target) throws ConversionException {
 * Assert.notNull(source, "Parameter source cannot be null."); Assert.notNull(target,
 * "Parameter target cannot be null.");
 *
 * // Copy the custom product code if available if (source instanceof CustomProductModel) { final CustomProductModel
 * customProductModel = source; target.setCustomProduct(customProductModel.getId()); } // List to store CPRAO instances
 * final List<CustomProduct> customProducts = new ArrayList<>(); // Iterate through entries in cartModel if (cartModel
 * != null && cartModel.getEntries() != null) { for (final AbstractOrderEntryModel entry : cartModel.getEntries()) { //
 * Check if the product has cp associated with it if (entry.getProduct() != null &&
 * entry.getProduct().getCustomProduct() != null) { // Create and populate CustomProducts id
 * target.setCustomProductCode(entry.getProduct().getCustomProduct().getId());
 *
 * } } } //list of CustomProducts in CartRAO target.setCustomProduct(customProducts); } } } }
 */




































/*
 * public class CustomProductPopulator extends CartRaoPopulator {
 *
 * @Override public void populate(final AbstractOrderModel cartModel, final CartRAO cartRao) {
 *
 * cartRao.setActions(new LinkedHashSet()); cartRao.setOriginalTotal(cartRao.getOriginalTotal());
 * cartRao.setTotal(cartRao.getTotal()); cartRao.setSubTotal(cartRao.getSubTotal());
 * cartRao.setDiscountValues(cartRao.getDiscountValues()); cartRao.setUser(cartRao.getUser());
 * cartRao.setTotalIncludingCharges(cartRao.getTotalIncludingCharges());
 * cartRao.setPaymentCost(cartRao.getPaymentCost()); cartRao.setDeliveryCost(cartRao.getDeliveryCost());
 * cartRao.setCustomProduct(cartRao.getCustomProduct()); cartRao.setCustomProductCode(cartRao.getCustomProductCode());
 * // List to store CPRAO instances final List<CustomProductRAO> customProducts = new ArrayList<>();
 *
 * // Iterate through entries in cartModel if (cartModel != null && cartModel.getEntries() != null) { for (final
 * AbstractOrderEntryModel entry : cartModel.getEntries()) { // Check if the product has cp associated with it if
 * (entry.getProduct() != null && entry.getProduct().getCustomProduct() != null) { // Create and populate CPRAO
 * cartRao.setCustomProductCode(entry.getProduct().getCustomProduct().getId());
 *
 * } } } //list of CPRAO in CartRAO cartRao.setCustomProduct(customProducts); } }
 */
