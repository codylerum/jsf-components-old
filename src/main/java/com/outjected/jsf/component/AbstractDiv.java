package com.outjected.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Div", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.div"), tag = @Tag(name = "div"), attributes = { "base-props.xml", "core-props.xml" })
abstract public class AbstractDiv extends UIComponentBase {
}
