package com.outjected.jsf.component;

import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.DecorateOutput", family = "com.outjected.layout", renderer = @JsfRenderer(type = "com.outjected.jsf.decorateOutput"), tag = @Tag(name = "decorateOutput"), attributes = {
        "base-props.xml", "core-props.xml" })
abstract public class AbstractDecorateOutput extends AbstractObjectField {
}
