package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.ObjectField", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.objectField"), tag = @Tag(name = "objectField"), attributes = {
        "base-props.xml", "core-props.xml" })
abstract public class AbstractObjectField extends UIComponentBase {

    @Attribute(required = true)
    public abstract String getLabel();

}
