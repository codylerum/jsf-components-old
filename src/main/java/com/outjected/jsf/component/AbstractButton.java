package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Button", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.button"), tag = @Tag(name = "button"), attributes = {
		"base-props.xml", "core-props.xml", "events-mouse-props.xml" })
abstract public class AbstractButton extends UIComponentBase {

	@Attribute(required = false, defaultValue = "button")
	public abstract String getType();

	@Attribute(required = false)
	public abstract String getValue();
}
