/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.techdenali.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.techdenali.core.constants.TrainingCoreConstants;
import com.techdenali.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class TrainingCoreManager extends GeneratedTrainingCoreManager
{
	public static final TrainingCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (TrainingCoreManager) em.getExtension(TrainingCoreConstants.EXTENSIONNAME);
	}
}
