package co.cfly.jsf.component;

import javax.faces.component.UIInput;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "co.cfly.jsf.Input", family = "co.cfly.input", renderer = @JsfRenderer(type = "co.cfly.jsf.input"), tag = @Tag(name = "input"), attributes = { "core-props.xml",
        "events-key-props.xml", "input-props.xml" })
abstract public class AbstractInput extends UIInput {

    @Attribute(defaultValue = "text")
    public abstract String getType();

    @Attribute(defaultValue = "on")
    public abstract String getAutocomplete();

    @Attribute
    public abstract String getPlaceholder();
}
