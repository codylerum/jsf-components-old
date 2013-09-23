package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.ObjectField", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.objectField"), tag = @Tag(name = "objectField"), attributes = {
		"base-props.xml", "core-props.xml" })
abstract public class AbstractObjectField extends UIComponentBase {

	@Attribute(defaultValue = "col-md-4", required = false)
	public abstract String getLabelClass();

	@Attribute(defaultValue = "col-md-8", required = false)
	public abstract String getValueClass();

	@Attribute(required = true)
	public abstract String getLabel();

	@Attribute(required = false)
	public abstract String getHelp();

	@Attribute(required = false)
	public abstract String getHelpTitle();

	@Attribute(defaultValue = "right", required = false)
	public abstract String getHelpPlacement();

	@Attribute(defaultValue = "click", required = false)
	public abstract String getHelpTrigger();

	@Attribute(defaultValue = "true", required = false)
	public abstract String getHelpHtml();

	@Attribute(defaultValue = "0", required = false)
	public abstract String getHelpDelay();

	@Attribute(defaultValue = "false", required = false)
	public abstract String getHelpContainer();
}
