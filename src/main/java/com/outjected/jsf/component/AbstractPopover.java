package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Popover", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.popover"), tag = @Tag(name = "popover"), attributes = {
		"base-props.xml", "core-props.xml" })
abstract public class AbstractPopover extends UIComponentBase {

	@Attribute(required = true)
	public abstract String getContent();

	@Attribute(required = false)
	public abstract String getPopoverTitle();

	@Attribute(defaultValue = "right", required = false)
	public abstract String getPlacement();

	@Attribute(defaultValue = "click", required = false)
	public abstract String getTrigger();

	@Attribute(defaultValue = "true", required = false)
	public abstract String getHtml();

	@Attribute(defaultValue = "0", required = false)
	public abstract String getDelay();

	@Attribute(defaultValue = "false", required = false)
	public abstract String getContainer();
}
