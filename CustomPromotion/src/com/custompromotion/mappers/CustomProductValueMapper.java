/*
 * Copyright (c) 2024 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.custompromotion.mappers;


import de.hybris.platform.ruleengineservices.rule.strategies.RuleParameterValueMapper;
import de.hybris.platform.ruleengineservices.rule.strategies.RuleParameterValueMapperException;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Required;

import com.techdenali.core.model.CustomProductModel;


public class CustomProductValueMapper implements RuleParameterValueMapper<CustomProductModel>
{

	private FlexibleSearchService flexibleSearchService;
	private String delimiter;

	@Override
	public String toString(final CustomProductModel cpModel)
	{

		if (cpModel == null)
		{
			throw new IllegalArgumentException("Object cannot be null");
		}
		return cpModel.getId();
	}

	@Override
	public CustomProductModel fromString(final String value)
	{
		/*
		 * ServicesUtil.validateParameterNotNull(value, "String value cannot be null");
		 */
		if (StringUtils.isBlank(value))
		{
			return null;
		}

		String customProductId = value;
		if (value.contains(this.getDelimiter()))
		{
			customProductId = StringUtils.substringBefore(value, this.getDelimiter());
		}

		return findCustomProductById(customProductId);
	}

	private CustomProductModel findCustomProductById(final String id)
	{
		final String queryString = "SELECT {pk} FROM {CustomProduct} WHERE {id}=?id";
		final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
		query.addQueryParameter("id", id);

		final SearchResult<CustomProductModel> searchResult = flexibleSearchService.search(query);
		final List<CustomProductModel> products = searchResult.getResult();

		if (CollectionUtils.isEmpty(products))
		{
			throw new RuleParameterValueMapperException("Cannot find custom product with the id: " + id);
		}

		return products.iterator().next();
	}

	@Required
	public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService)
	{
		this.flexibleSearchService = flexibleSearchService;
	}

	protected String getDelimiter()
	{
		return this.delimiter;
	}

	@Required
	public void setDelimiter(final String delimiter)
	{
		this.delimiter = delimiter;
	}
}




































/*
 * public class CustomProductValueMapper implements RuleParameterValueMapper<CustomProductModel> {
 *
 * private FlexibleSearchService flexibleSearchService; private String delimiter;
 *
 * @Override public String toString(final CustomProductModel cpModel) { ServicesUtil.validateParameterNotNull(cpModel,
 * "Object cannot be null"); return cpModel.getId(); }
 *
 * @Override public CustomProductModel fromString(final String value) { ServicesUtil.validateParameterNotNull(value,
 * "String value cannot be null");
 *
 * CustomProductModel customProduct = null; if (value.contains(this.getDelimiter())) { final String productCode =
 * StringUtils.substringBefore(value, this.getDelimiter()); customProduct = findCustomProductByCode(productCode); } else
 * { customProduct = findCustomProductByCode(value); }
 *
 * if (customProduct == null) { throw new RuleParameterValueMapperException("Cannot find product with the id: " +
 * value); }
 *
 * return customProduct; }
 *
 * private CustomProductModel findCustomProductByCode(final String code) { final String queryString =
 * "SELECT {pk} FROM {CustomProduct} WHERE {id}=?id"; final FlexibleSearchQuery query = new
 * FlexibleSearchQuery(queryString); query.addQueryParameter("id", code);
 *
 * final SearchResult<CustomProductModel> searchResult = flexibleSearchService.search(query); final
 * List<CustomProductModel> products = searchResult.getResult();
 *
 * if (CollectionUtils.isEmpty(products)) { return null; }
 *
 * return products.iterator().next(); }
 *
 * @Required public void setFlexibleSearchService(final FlexibleSearchService flexibleSearchService) {
 * this.flexibleSearchService = flexibleSearchService; }
 *
 * protected String getDelimiter() { return this.delimiter; }
 *
 * @Required public void setDelimiter(final String delimiter) { this.delimiter = delimiter; } }
 */
