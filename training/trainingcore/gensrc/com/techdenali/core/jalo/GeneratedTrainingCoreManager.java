/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Sep 9, 2024, 5:09:39 AM                     ---
 * ----------------------------------------------------------------
 */
package com.techdenali.core.jalo;

import com.techdenali.core.constants.TrainingCoreConstants;
import com.techdenali.core.jalo.ApparelProduct;
import com.techdenali.core.jalo.ApparelSizeVariantProduct;
import com.techdenali.core.jalo.ApparelStyleVariantProduct;
import com.techdenali.core.jalo.CustomNode;
import com.techdenali.core.jalo.CustomProduct;
import com.techdenali.core.jalo.ElectronicsColorVariantProduct;
import com.techdenali.core.jalo.HybrisCurrencyConversion;
import com.techdenali.core.jalo.ManufactureZone;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.JaloBusinessException;
import de.hybris.platform.jalo.JaloSystemException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.extension.Extension;
import de.hybris.platform.jalo.order.AbstractOrder;
import de.hybris.platform.jalo.order.Quote;
import de.hybris.platform.jalo.product.Product;
import de.hybris.platform.jalo.type.ComposedType;
import de.hybris.platform.jalo.type.JaloGenericCreationException;
import de.hybris.platform.jalo.user.Customer;
import de.hybris.platform.jalo.user.User;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generated class for type <code>TrainingCoreManager</code>.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedTrainingCoreManager extends Extension
{
	protected static final Map<String, Map<String, AttributeMode>> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, Map<String, AttributeMode>> ttmp = new HashMap();
		Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put("sellingRank", AttributeMode.INITIAL);
		tmp.put("productZone", AttributeMode.INITIAL);
		tmp.put("manufactureZones", AttributeMode.INITIAL);
		tmp.put("CustomProduct", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.product.Product", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("guestEmail", AttributeMode.INITIAL);
		tmp.put("guestName", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.order.Quote", Collections.unmodifiableMap(tmp));
		tmp = new HashMap<String, AttributeMode>();
		tmp.put("surname", AttributeMode.INITIAL);
		tmp.put("age", AttributeMode.INITIAL);
		ttmp.put("de.hybris.platform.jalo.user.Customer", Collections.unmodifiableMap(tmp));
		DEFAULT_INITIAL_ATTRIBUTES = ttmp;
	}
	@Override
	public Map<String, AttributeMode> getDefaultAttributeModes(final Class<? extends Item> itemClass)
	{
		Map<String, AttributeMode> ret = new HashMap<>();
		final Map<String, AttributeMode> attr = DEFAULT_INITIAL_ATTRIBUTES.get(itemClass.getName());
		if (attr != null)
		{
			ret.putAll(attr);
		}
		return ret;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.age</code> attribute.
	 * @return the age - age of the customer
	 */
	public String getAge(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, TrainingCoreConstants.Attributes.Customer.AGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.age</code> attribute.
	 * @return the age - age of the customer
	 */
	public String getAge(final Customer item)
	{
		return getAge( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.age</code> attribute. 
	 * @param value the age - age of the customer
	 */
	public void setAge(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Customer.AGE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.age</code> attribute. 
	 * @param value the age - age of the customer
	 */
	public void setAge(final Customer item, final String value)
	{
		setAge( getSession().getSessionContext(), item, value );
	}
	
	public ApparelProduct createApparelProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.APPARELPRODUCT );
			return (ApparelProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelProduct createApparelProduct(final Map attributeValues)
	{
		return createApparelProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.APPARELSIZEVARIANTPRODUCT );
			return (ApparelSizeVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelSizeVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelSizeVariantProduct createApparelSizeVariantProduct(final Map attributeValues)
	{
		return createApparelSizeVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.APPARELSTYLEVARIANTPRODUCT );
			return (ApparelStyleVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ApparelStyleVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ApparelStyleVariantProduct createApparelStyleVariantProduct(final Map attributeValues)
	{
		return createApparelStyleVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public CustomNode createCustomNode(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.CUSTOMNODE );
			return (CustomNode)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CustomNode : "+e.getMessage(), 0 );
		}
	}
	
	public CustomNode createCustomNode(final Map attributeValues)
	{
		return createCustomNode( getSession().getSessionContext(), attributeValues );
	}
	
	public CustomProduct createCustomProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.CUSTOMPRODUCT );
			return (CustomProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating CustomProduct : "+e.getMessage(), 0 );
		}
	}
	
	public CustomProduct createCustomProduct(final Map attributeValues)
	{
		return createCustomProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.ELECTRONICSCOLORVARIANTPRODUCT );
			return (ElectronicsColorVariantProduct)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ElectronicsColorVariantProduct : "+e.getMessage(), 0 );
		}
	}
	
	public ElectronicsColorVariantProduct createElectronicsColorVariantProduct(final Map attributeValues)
	{
		return createElectronicsColorVariantProduct( getSession().getSessionContext(), attributeValues );
	}
	
	public HybrisCurrencyConversion createHybrisCurrencyConversion(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.HYBRISCURRENCYCONVERSION );
			return (HybrisCurrencyConversion)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating HybrisCurrencyConversion : "+e.getMessage(), 0 );
		}
	}
	
	public HybrisCurrencyConversion createHybrisCurrencyConversion(final Map attributeValues)
	{
		return createHybrisCurrencyConversion( getSession().getSessionContext(), attributeValues );
	}
	
	public ManufactureZone createManufactureZone(final SessionContext ctx, final Map attributeValues)
	{
		try
		{
			ComposedType type = getTenant().getJaloConnection().getTypeManager().getComposedType( TrainingCoreConstants.TC.MANUFACTUREZONE );
			return (ManufactureZone)type.newInstance( ctx, attributeValues );
		}
		catch( JaloGenericCreationException e)
		{
			final Throwable cause = e.getCause();
			throw (cause instanceof RuntimeException ?
			(RuntimeException)cause
			:
			new JaloSystemException( cause, cause.getMessage(), e.getErrorCode() ) );
		}
		catch( JaloBusinessException e )
		{
			throw new JaloSystemException( e ,"error creating ManufactureZone : "+e.getMessage(), 0 );
		}
	}
	
	public ManufactureZone createManufactureZone(final Map attributeValues)
	{
		return createManufactureZone( getSession().getSessionContext(), attributeValues );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.CustomProduct</code> attribute.
	 * @return the CustomProduct
	 */
	public CustomProduct getCustomProduct(final SessionContext ctx, final Product item)
	{
		return (CustomProduct)item.getProperty( ctx, TrainingCoreConstants.Attributes.Product.CUSTOMPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.CustomProduct</code> attribute.
	 * @return the CustomProduct
	 */
	public CustomProduct getCustomProduct(final Product item)
	{
		return getCustomProduct( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.CustomProduct</code> attribute. 
	 * @param value the CustomProduct
	 */
	public void setCustomProduct(final SessionContext ctx, final Product item, final CustomProduct value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Product.CUSTOMPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.CustomProduct</code> attribute. 
	 * @param value the CustomProduct
	 */
	public void setCustomProduct(final Product item, final CustomProduct value)
	{
		setCustomProduct( getSession().getSessionContext(), item, value );
	}
	
	@Override
	public String getName()
	{
		return TrainingCoreConstants.EXTENSIONNAME;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Quote.guestEmail</code> attribute.
	 * @return the guestEmail - Quote model submitted by the buyer/sales rep.
	 */
	public String getGuestEmail(final SessionContext ctx, final Quote item)
	{
		return (String)item.getProperty( ctx, TrainingCoreConstants.Attributes.Quote.GUESTEMAIL);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Quote.guestEmail</code> attribute.
	 * @return the guestEmail - Quote model submitted by the buyer/sales rep.
	 */
	public String getGuestEmail(final Quote item)
	{
		return getGuestEmail( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Quote.guestEmail</code> attribute. 
	 * @param value the guestEmail - Quote model submitted by the buyer/sales rep.
	 */
	public void setGuestEmail(final SessionContext ctx, final Quote item, final String value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Quote.GUESTEMAIL,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Quote.guestEmail</code> attribute. 
	 * @param value the guestEmail - Quote model submitted by the buyer/sales rep.
	 */
	public void setGuestEmail(final Quote item, final String value)
	{
		setGuestEmail( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Quote.guestName</code> attribute.
	 * @return the guestName - Quote model submitted by the buyer/sales rep.
	 */
	public String getGuestName(final SessionContext ctx, final Quote item)
	{
		return (String)item.getProperty( ctx, TrainingCoreConstants.Attributes.Quote.GUESTNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Quote.guestName</code> attribute.
	 * @return the guestName - Quote model submitted by the buyer/sales rep.
	 */
	public String getGuestName(final Quote item)
	{
		return getGuestName( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Quote.guestName</code> attribute. 
	 * @param value the guestName - Quote model submitted by the buyer/sales rep.
	 */
	public void setGuestName(final SessionContext ctx, final Quote item, final String value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Quote.GUESTNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Quote.guestName</code> attribute. 
	 * @param value the guestName - Quote model submitted by the buyer/sales rep.
	 */
	public void setGuestName(final Quote item, final String value)
	{
		setGuestName( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufactureZones</code> attribute.
	 * @return the manufactureZones - List of ManufactureZones
	 */
	public List<ManufactureZone> getManufactureZones(final SessionContext ctx, final Product item)
	{
		List<ManufactureZone> coll = (List<ManufactureZone>)item.getProperty( ctx, TrainingCoreConstants.Attributes.Product.MANUFACTUREZONES);
		return coll != null ? coll : Collections.EMPTY_LIST;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.manufactureZones</code> attribute.
	 * @return the manufactureZones - List of ManufactureZones
	 */
	public List<ManufactureZone> getManufactureZones(final Product item)
	{
		return getManufactureZones( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufactureZones</code> attribute. 
	 * @param value the manufactureZones - List of ManufactureZones
	 */
	public void setManufactureZones(final SessionContext ctx, final Product item, final List<ManufactureZone> value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Product.MANUFACTUREZONES,value == null || !value.isEmpty() ? value : null );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.manufactureZones</code> attribute. 
	 * @param value the manufactureZones - List of ManufactureZones
	 */
	public void setManufactureZones(final Product item, final List<ManufactureZone> value)
	{
		setManufactureZones( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productZone</code> attribute.
	 * @return the productZone - Product Zone.
	 */
	public String getProductZone(final SessionContext ctx, final Product item)
	{
		return (String)item.getProperty( ctx, TrainingCoreConstants.Attributes.Product.PRODUCTZONE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.productZone</code> attribute.
	 * @return the productZone - Product Zone.
	 */
	public String getProductZone(final Product item)
	{
		return getProductZone( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productZone</code> attribute. 
	 * @param value the productZone - Product Zone.
	 */
	public void setProductZone(final SessionContext ctx, final Product item, final String value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Product.PRODUCTZONE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.productZone</code> attribute. 
	 * @param value the productZone - Product Zone.
	 */
	public void setProductZone(final Product item, final String value)
	{
		setProductZone( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.sellingRank</code> attribute.
	 * @return the sellingRank - Product Selling Rank.
	 */
	public Integer getSellingRank(final SessionContext ctx, final Product item)
	{
		return (Integer)item.getProperty( ctx, TrainingCoreConstants.Attributes.Product.SELLINGRANK);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.sellingRank</code> attribute.
	 * @return the sellingRank - Product Selling Rank.
	 */
	public Integer getSellingRank(final Product item)
	{
		return getSellingRank( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.sellingRank</code> attribute. 
	 * @return the sellingRank - Product Selling Rank.
	 */
	public int getSellingRankAsPrimitive(final SessionContext ctx, final Product item)
	{
		Integer value = getSellingRank( ctx,item );
		return value != null ? value.intValue() : 0;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Product.sellingRank</code> attribute. 
	 * @return the sellingRank - Product Selling Rank.
	 */
	public int getSellingRankAsPrimitive(final Product item)
	{
		return getSellingRankAsPrimitive( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.sellingRank</code> attribute. 
	 * @param value the sellingRank - Product Selling Rank.
	 */
	public void setSellingRank(final SessionContext ctx, final Product item, final Integer value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Product.SELLINGRANK,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.sellingRank</code> attribute. 
	 * @param value the sellingRank - Product Selling Rank.
	 */
	public void setSellingRank(final Product item, final Integer value)
	{
		setSellingRank( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.sellingRank</code> attribute. 
	 * @param value the sellingRank - Product Selling Rank.
	 */
	public void setSellingRank(final SessionContext ctx, final Product item, final int value)
	{
		setSellingRank( ctx, item, Integer.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Product.sellingRank</code> attribute. 
	 * @param value the sellingRank - Product Selling Rank.
	 */
	public void setSellingRank(final Product item, final int value)
	{
		setSellingRank( getSession().getSessionContext(), item, value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.surname</code> attribute.
	 * @return the surname - surname
	 */
	public String getSurname(final SessionContext ctx, final Customer item)
	{
		return (String)item.getProperty( ctx, TrainingCoreConstants.Attributes.Customer.SURNAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Customer.surname</code> attribute.
	 * @return the surname - surname
	 */
	public String getSurname(final Customer item)
	{
		return getSurname( getSession().getSessionContext(), item );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.surname</code> attribute. 
	 * @param value the surname - surname
	 */
	public void setSurname(final SessionContext ctx, final Customer item, final String value)
	{
		item.setProperty(ctx, TrainingCoreConstants.Attributes.Customer.SURNAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>Customer.surname</code> attribute. 
	 * @param value the surname - surname
	 */
	public void setSurname(final Customer item, final String value)
	{
		setSurname( getSession().getSessionContext(), item, value );
	}
	
}
