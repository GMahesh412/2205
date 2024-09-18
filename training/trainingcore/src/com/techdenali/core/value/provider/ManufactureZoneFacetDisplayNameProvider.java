/**
 *
 */
package com.techdenali.core.value.provider;

import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.provider.impl.AbstractFacetValueDisplayNameProvider;
import de.hybris.platform.solrfacetsearch.search.SearchQuery;

import org.apache.commons.lang3.StringUtils;


//deals with displaying facet value rendering facets in search results
public class ManufactureZoneFacetDisplayNameProvider extends AbstractFacetValueDisplayNameProvider
{
	@Override
	public String getDisplayName(final SearchQuery query, final IndexedProperty property, final String facetValue)
	{
		//checking if facetValue(manufactureZone name not blank)
		if (StringUtils.isNotBlank(facetValue))
		{
			// facetValue like HYD,BLR,DELHi
			return facetValue;
		}
		return StringUtils.EMPTY;
	}
}
