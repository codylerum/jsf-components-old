package co.cfly.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "co.cfly.jsf.ObjectField", family = "co.cfly.layout", renderer = @JsfRenderer(type = "co.cfly.jsf.objectField"), tag = @Tag(name = "objectField"))
abstract public class AbstractObjectField extends UIComponentBase {

    @Attribute(required = true)
    public abstract String getLabel();

}
