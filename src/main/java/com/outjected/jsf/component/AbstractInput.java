package com.outjected.jsf.component;

import javax.faces.component.UIInput;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Input", family = "com.outjected.input", renderer = @JsfRenderer(type = "com.outjected.jsf.input"), tag = @Tag(name = "input"), attributes = { "core-props.xml",
        "events-key-props.xml", "input-props.xml" })
abstract public class AbstractInput extends UIInput {

    @Attribute(defaultValue = "text")
    public abstract String getType();

    @Attribute
    public abstract String getAutocomplete();

    @Attribute
    public abstract String getPlaceholder();

    // For type=number
    @Attribute
    public abstract String getMin();

    @Attribute
    public abstract String getMax();

    @Attribute
    public abstract String getStep();

    @Attribute(required = false)
    public abstract String getHelp();

    @Attribute(required = false)
    public abstract String getHelpTitle();

    @Attribute(defaultValue = "right", required = false)
    public abstract String getHelpPlacement();

    @Attribute(defaultValue = "focus", required = false)
    public abstract String getHelpTrigger();

    @Attribute(defaultValue = "true", required = false)
    public abstract String getHelpHtml();

    @Attribute(defaultValue = "0", required = false)
    public abstract String getHelpDelay();
}
