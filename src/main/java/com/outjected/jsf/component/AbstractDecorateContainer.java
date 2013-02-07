package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.DecorateContainer", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.decorateContainer"), tag = @Tag(name = "decorateContainer"))
abstract public class AbstractDecorateContainer extends UIComponentBase {

    @Attribute(required = false, defaultValue = "150px")
    public abstract String getLabelWidth();

    @Attribute(required = false, defaultValue = "300px")
    public abstract String getValueWidth();

    @Attribute(required = false, defaultValue = "200px")
    public abstract String getMessageWidth();
}