package com.outjected.jsf.component;

import javax.faces.component.UIComponent;
import javax.faces.component.UIMessages;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.Facet;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.DecorateInput", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.decorateInput"), tag = @Tag(name = "decorateInput"), attributes = {
        "base-props.xml", "core-props.xml" })
abstract public class AbstractDecorateInput extends AbstractDecorate {

    public AbstractDecorateInput() {
        super();
        this.setMessages(new UIMessages());
    }

    @Attribute(required = false, defaultValue = "true")
    public abstract boolean isRenderMessages();

    @Facet(name = "messages")
    public abstract UIComponent getMessages();

    public abstract void setMessages(UIComponent messages);

    @Attribute(defaultValue = "false", required = false)
    public abstract boolean isSkipControlClass();
}
