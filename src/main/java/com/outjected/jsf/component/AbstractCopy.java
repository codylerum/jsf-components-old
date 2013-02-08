package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Copy", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.copy"), tag = @Tag(name = "copy"), attributes = { "base-props.xml",
        "core-props.xml" })
abstract public class AbstractCopy extends UIComponentBase {

    @Attribute(required = true)
    public abstract String getValue();

    @Attribute(required = false, defaultValue = "icon-copy")
    public abstract String getCopyClass();

    @Attribute(required = false, defaultValue = "icon-paste")
    public abstract String getCopiedClass();
}
