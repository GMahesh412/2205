/**
 *
 */
package com.techdenali.core.value.provider;

import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.provider.FieldNameProvider;
import de.hybris.platform.solrfacetsearch.provider.FieldValue;
import de.hybris.platform.solrfacetsearch.provider.FieldValueProvider;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractPropertyFieldValueProvider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.techdenali.core.model.ManufactureZoneModel;


/**
 *
 */

public class ManufactureZoneValueProvider extends AbstractPropertyFieldValueProvider implements FieldValueProvider
{
	// retrieves correct solr fieldNames for the IndexedProperty
	private FieldNameProvider fieldNameProvider;
	private static final Logger LOG = Logger.getLogger(ManufactureZoneValueProvider.class);


	@Override
	public Collection<FieldValue> getFieldValues(final IndexConfig indexConfig, final IndexedProperty indexedProperty,
			final Object model) throws FieldValueProviderException
	{
		// checking if model is of type ProdModel.
		if (model instanceof final ProductModel productModel)
		{
			// if ProdModel- create  fieldValues for product.
			return createFieldValue(productModel, indexedProperty);
		}
		else
		{
			// if  model is not product throw exception
			throw new FieldValueProviderException(
					"Error occured in Custom ManufactureZoneValueProvider !! item is not a Product type");
		}

	}

	//create FieldValues for given prodModel & indexed property.
	protected List<FieldValue> createFieldValue(final ProductModel productModel, final IndexedProperty indexedProperty)
	{
		final List<FieldValue> fieldValues = new ArrayList<>();

		final List<ManufactureZoneModel> zoneModelList = productModel.getManufactureZones();

		if (CollectionUtils.isNotEmpty(zoneModelList))
		{
			for (final ManufactureZoneModel zoneModel : zoneModelList)
			{
				if (StringUtils.isNotBlank(zoneModel.getZoneName()))
				{
					addFieldValues(fieldValues, indexedProperty, null, zoneModel.getZoneName());
				}
			}
		}
		else
		{
			LOG.info("ManufactureZones is Empty for Product :: " + productModel.getCode());
		}
		return fieldValues;
	}

	//retrieves the manufacture zones associated with the product and prepares them for indexing.
	protected void addFieldValues(final List<FieldValue> fieldValues, final IndexedProperty indexedProperty,
			final LanguageModel language, final Object value)
	{
		final Collection<String> fieldNames = getFieldNameProvider().getFieldNames(indexedProperty,
				(language == null) ? null : language.getIsocode());
		for (final String fieldName : fieldNames)
		{
			fieldValues.add(new FieldValue(fieldName, value));
		}
	}

	public FieldNameProvider getFieldNameProvider()
	{
		return fieldNameProvider;
	}

	public void setFieldNameProvider(final FieldNameProvider fieldNameProvider)
	{
		this.fieldNameProvider = fieldNameProvider;
	}


}
