package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Modal", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.modal"), tag = @Tag(name = "modal"), attributes = {
        "base-props.xml", "core-props.xml" })
abstract public class AbstractModal extends UIComponentBase {

    @Attribute(required = false)
    public abstract String getHeader();

    @Attribute(defaultValue = "600", required = false)
    public abstract String getMaxWidth();

    @Attribute(defaultValue = "static", required = false)
    public abstract String getBackdrop();

    @Attribute(defaultValue = "false", required = false)
    public abstract String getKeyboard();
}
