package com.techdenali.backoffice.widgets;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Label;

import com.hybris.cockpitng.util.DefaultWidgetController;
import com.techdenali.backoffice.services.CustomPerspectiveService;



public class CustomPerspectiveController extends DefaultWidgetController
{
	private static final long serialVersionUID = 1L;
	private Label label;

	@WireVariable
	private transient CustomPerspectiveService service;

	@Override
	public void initialize(final Component comp)
	{
		super.initialize(comp);
		label.setValue(service.getCustomMsg() + " CustomPerspectiveController");
	}

}
