/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Sep 9, 2024, 5:09:39 AM                     ---
 * ----------------------------------------------------------------
 */
package com.techdenali.core.jalo;

import com.techdenali.core.constants.TrainingCoreConstants;
import de.hybris.platform.jalo.GenericItem;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem CustomProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedCustomProduct extends GenericItem
{
	/** Qualifier of the <code>CustomProduct.id</code> attribute **/
	public static final String ID = "id";
	/** Qualifier of the <code>CustomProduct.name</code> attribute **/
	public static final String NAME = "name";
	/** Qualifier of the <code>CustomProduct.cpProduct</code> attribute **/
	public static final String CPPRODUCT = "cpProduct";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ID, AttributeMode.INITIAL);
		tmp.put(NAME, AttributeMode.INITIAL);
		tmp.put(CPPRODUCT, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.cpProduct</code> attribute.
	 * @return the cpProduct - cp  attribute
	 */
	public String getCpProduct(final SessionContext ctx)
	{
		return (String)getProperty( ctx, CPPRODUCT);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.cpProduct</code> attribute.
	 * @return the cpProduct - cp  attribute
	 */
	public String getCpProduct()
	{
		return getCpProduct( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.cpProduct</code> attribute. 
	 * @param value the cpProduct - cp  attribute
	 */
	public void setCpProduct(final SessionContext ctx, final String value)
	{
		setProperty(ctx, CPPRODUCT,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.cpProduct</code> attribute. 
	 * @param value the cpProduct - cp  attribute
	 */
	public void setCpProduct(final String value)
	{
		setCpProduct( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.id</code> attribute.
	 * @return the id - id
	 */
	public String getId(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.id</code> attribute.
	 * @return the id - id
	 */
	public String getId()
	{
		return getId( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.id</code> attribute. 
	 * @param value the id - id
	 */
	public void setId(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.id</code> attribute. 
	 * @param value the id - id
	 */
	public void setId(final String value)
	{
		setId( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.name</code> attribute.
	 * @return the name - name
	 */
	public String getName(final SessionContext ctx)
	{
		return (String)getProperty( ctx, NAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>CustomProduct.name</code> attribute.
	 * @return the name - name
	 */
	public String getName()
	{
		return getName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setName(final SessionContext ctx, final String value)
	{
		setProperty(ctx, NAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>CustomProduct.name</code> attribute. 
	 * @param value the name - name
	 */
	public void setName(final String value)
	{
		setName( getSession().getSessionContext(), value );
	}
	
}
