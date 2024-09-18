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
import de.hybris.platform.jalo.c2l.Currency;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem HybrisCurrencyConversion}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedHybrisCurrencyConversion extends GenericItem
{
	/** Qualifier of the <code>HybrisCurrencyConversion.conversionDate</code> attribute **/
	public static final String CONVERSIONDATE = "conversionDate";
	/** Qualifier of the <code>HybrisCurrencyConversion.conversionRate</code> attribute **/
	public static final String CONVERSIONRATE = "conversionRate";
	/** Qualifier of the <code>HybrisCurrencyConversion.fromCurrency</code> attribute **/
	public static final String FROMCURRENCY = "fromCurrency";
	/** Qualifier of the <code>HybrisCurrencyConversion.toCurrency</code> attribute **/
	public static final String TOCURRENCY = "toCurrency";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(CONVERSIONDATE, AttributeMode.INITIAL);
		tmp.put(CONVERSIONRATE, AttributeMode.INITIAL);
		tmp.put(FROMCURRENCY, AttributeMode.INITIAL);
		tmp.put(TOCURRENCY, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionDate</code> attribute.
	 * @return the conversionDate - Conversion Date
	 */
	public Date getConversionDate(final SessionContext ctx)
	{
		return (Date)getProperty( ctx, CONVERSIONDATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionDate</code> attribute.
	 * @return the conversionDate - Conversion Date
	 */
	public Date getConversionDate()
	{
		return getConversionDate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionDate</code> attribute. 
	 * @param value the conversionDate - Conversion Date
	 */
	public void setConversionDate(final SessionContext ctx, final Date value)
	{
		setProperty(ctx, CONVERSIONDATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionDate</code> attribute. 
	 * @param value the conversionDate - Conversion Date
	 */
	public void setConversionDate(final Date value)
	{
		setConversionDate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute.
	 * @return the conversionRate - Conversion Rate
	 */
	public Double getConversionRate(final SessionContext ctx)
	{
		return (Double)getProperty( ctx, CONVERSIONRATE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute.
	 * @return the conversionRate - Conversion Rate
	 */
	public Double getConversionRate()
	{
		return getConversionRate( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @return the conversionRate - Conversion Rate
	 */
	public double getConversionRateAsPrimitive(final SessionContext ctx)
	{
		Double value = getConversionRate( ctx );
		return value != null ? value.doubleValue() : 0.0d;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @return the conversionRate - Conversion Rate
	 */
	public double getConversionRateAsPrimitive()
	{
		return getConversionRateAsPrimitive( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @param value the conversionRate - Conversion Rate
	 */
	public void setConversionRate(final SessionContext ctx, final Double value)
	{
		setProperty(ctx, CONVERSIONRATE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @param value the conversionRate - Conversion Rate
	 */
	public void setConversionRate(final Double value)
	{
		setConversionRate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @param value the conversionRate - Conversion Rate
	 */
	public void setConversionRate(final SessionContext ctx, final double value)
	{
		setConversionRate( ctx,Double.valueOf( value ) );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.conversionRate</code> attribute. 
	 * @param value the conversionRate - Conversion Rate
	 */
	public void setConversionRate(final double value)
	{
		setConversionRate( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.fromCurrency</code> attribute.
	 * @return the fromCurrency - From Currency
	 */
	public Currency getFromCurrency(final SessionContext ctx)
	{
		return (Currency)getProperty( ctx, FROMCURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.fromCurrency</code> attribute.
	 * @return the fromCurrency - From Currency
	 */
	public Currency getFromCurrency()
	{
		return getFromCurrency( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.fromCurrency</code> attribute. 
	 * @param value the fromCurrency - From Currency
	 */
	public void setFromCurrency(final SessionContext ctx, final Currency value)
	{
		setProperty(ctx, FROMCURRENCY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.fromCurrency</code> attribute. 
	 * @param value the fromCurrency - From Currency
	 */
	public void setFromCurrency(final Currency value)
	{
		setFromCurrency( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.toCurrency</code> attribute.
	 * @return the toCurrency - To Currency
	 */
	public Currency getToCurrency(final SessionContext ctx)
	{
		return (Currency)getProperty( ctx, TOCURRENCY);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>HybrisCurrencyConversion.toCurrency</code> attribute.
	 * @return the toCurrency - To Currency
	 */
	public Currency getToCurrency()
	{
		return getToCurrency( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.toCurrency</code> attribute. 
	 * @param value the toCurrency - To Currency
	 */
	public void setToCurrency(final SessionContext ctx, final Currency value)
	{
		setProperty(ctx, TOCURRENCY,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>HybrisCurrencyConversion.toCurrency</code> attribute. 
	 * @param value the toCurrency - To Currency
	 */
	public void setToCurrency(final Currency value)
	{
		setToCurrency( getSession().getSessionContext(), value );
	}
	
}
