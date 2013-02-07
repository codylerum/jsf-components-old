package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.DecorateOutput", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.decorateOutput"), tag = @Tag(name = "decorateOutput"), attributes = {
        "base-props.xml", "core-props.xml" })
abstract public class AbstractDecorateOutput extends UIComponentBase {

    @Attribute(required = true)
    public abstract String getLabel();

    @Attribute(required = false, defaultValue = "decorate-outer")
    public abstract String getStyleClass();

    @Attribute(required = false, defaultValue = "decorate-label")
    public abstract String getLabelStyleClass();

    @Attribute(required = false, defaultValue = "decorate-value")
    public abstract String getValueStyleClass();

    @Attribute(required = false, defaultValue = "decorate-message")
    public abstract String getMessageStyleClass();
}