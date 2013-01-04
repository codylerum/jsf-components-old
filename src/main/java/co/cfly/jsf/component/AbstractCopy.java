package co.cfly.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "co.cfly.jsf.Copy", family = "co.cfly.layout", renderer = @JsfRenderer(type = "co.cfly.jsf.copy"), tag = @Tag(name = "copy"), attributes = { "base-props.xml", "core-props.xml" })
abstract public class AbstractCopy extends UIComponentBase {

    @Attribute(required = true)
    public abstract String getValue();

    @Attribute(required = false, defaultValue = "Copy")
    public abstract String getCopyText();

    @Attribute(required = false, defaultValue = "Copied")
    public abstract String getCopiedText();
}
