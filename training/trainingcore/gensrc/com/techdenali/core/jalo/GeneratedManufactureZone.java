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
import de.hybris.platform.jalo.JaloInvalidParameterException;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.c2l.C2LManager;
import de.hybris.platform.jalo.c2l.Language;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link de.hybris.platform.jalo.GenericItem ManufactureZone}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedManufactureZone extends GenericItem
{
	/** Qualifier of the <code>ManufactureZone.zoneID</code> attribute **/
	public static final String ZONEID = "zoneID";
	/** Qualifier of the <code>ManufactureZone.zoneName</code> attribute **/
	public static final String ZONENAME = "zoneName";
	/** Qualifier of the <code>ManufactureZone.postalCode</code> attribute **/
	public static final String POSTALCODE = "postalCode";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>();
		tmp.put(ZONEID, AttributeMode.INITIAL);
		tmp.put(ZONENAME, AttributeMode.INITIAL);
		tmp.put(POSTALCODE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.postalCode</code> attribute.
	 * @return the postalCode - Postal Code Value.
	 */
	public String getPostalCode(final SessionContext ctx)
	{
		return (String)getProperty( ctx, POSTALCODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.postalCode</code> attribute.
	 * @return the postalCode - Postal Code Value.
	 */
	public String getPostalCode()
	{
		return getPostalCode( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.postalCode</code> attribute. 
	 * @param value the postalCode - Postal Code Value.
	 */
	public void setPostalCode(final SessionContext ctx, final String value)
	{
		setProperty(ctx, POSTALCODE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.postalCode</code> attribute. 
	 * @param value the postalCode - Postal Code Value.
	 */
	public void setPostalCode(final String value)
	{
		setPostalCode( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneID</code> attribute.
	 * @return the zoneID
	 */
	public String getZoneID(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ZONEID);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneID</code> attribute.
	 * @return the zoneID
	 */
	public String getZoneID()
	{
		return getZoneID( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneID</code> attribute. 
	 * @param value the zoneID
	 */
	public void setZoneID(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ZONEID,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneID</code> attribute. 
	 * @param value the zoneID
	 */
	public void setZoneID(final String value)
	{
		setZoneID( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneName</code> attribute.
	 * @return the zoneName - Zone Name value.
	 */
	public String getZoneName(final SessionContext ctx)
	{
		if( ctx == null || ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufactureZone.getZoneName requires a session language", 0 );
		}
		return (String)getLocalizedProperty( ctx, ZONENAME);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneName</code> attribute.
	 * @return the zoneName - Zone Name value.
	 */
	public String getZoneName()
	{
		return getZoneName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @return the localized zoneName - Zone Name value.
	 */
	public Map<Language,String> getAllZoneName(final SessionContext ctx)
	{
		return (Map<Language,String>)getAllLocalizedProperties(ctx,ZONENAME,C2LManager.getInstance().getAllLanguages());
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @return the localized zoneName - Zone Name value.
	 */
	public Map<Language,String> getAllZoneName()
	{
		return getAllZoneName( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @param value the zoneName - Zone Name value.
	 */
	public void setZoneName(final SessionContext ctx, final String value)
	{
		if ( ctx == null) 
		{
			throw new JaloInvalidParameterException( "ctx is null", 0 );
		}
		if( ctx.getLanguage() == null )
		{
			throw new JaloInvalidParameterException("GeneratedManufactureZone.setZoneName requires a session language", 0 );
		}
		setLocalizedProperty(ctx, ZONENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @param value the zoneName - Zone Name value.
	 */
	public void setZoneName(final String value)
	{
		setZoneName( getSession().getSessionContext(), value );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @param value the zoneName - Zone Name value.
	 */
	public void setAllZoneName(final SessionContext ctx, final Map<Language,String> value)
	{
		setAllLocalizedProperties(ctx,ZONENAME,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>ManufactureZone.zoneName</code> attribute. 
	 * @param value the zoneName - Zone Name value.
	 */
	public void setAllZoneName(final Map<Language,String> value)
	{
		setAllZoneName( getSession().getSessionContext(), value );
	}
	
}
