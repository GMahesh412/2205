/**
 *
 */
package com.techdenali.storefront.forms;

import de.hybris.platform.acceleratorstorefrontcommons.forms.GuestForm;

/**
 *
 */
public class CustomGuestForm extends GuestForm
{
	private String name;
	private String contactNum;
	private String comments;
	private String company;
	//private String email;

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *                the name to set
	 */
	public void setName(final String name)
	{
		this.name = name;
	}

	/**
	 * @return the contactNum
	 */
	public String getContactNum()
	{
		return contactNum;
	}

	/**
	 * @param contactNum
	 *                      the contactNum to set
	 */
	public void setContactNum(final String contactNum)
	{
		this.contactNum = contactNum;
	}

	/**
	 * @return the comments
	 */
	public String getComments()
	{
		return comments;
	}

	/**
	 * @param comments
	 *                    the comments to set
	 */
	public void setComments(final String comments)
	{
		this.comments = comments;
	}

	/**
	 * @return the company
	 */
	public String getCompany()
	{
		return company;
	}

	/**
	 * @param company
	 *                   the company to set
	 */
	public void setCompany(final String company)
	{
		this.company = company;
	}

}
