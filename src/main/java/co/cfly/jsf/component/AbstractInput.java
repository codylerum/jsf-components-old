package co.cfly.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;
 
@JsfComponent(
        type = "co.cfly.jsf.Input", 
        family = "co.cfly.layout", 
        renderer = @JsfRenderer(type = "co.cfly.jsf.input"), 
        tag = @Tag(name="input"))
abstract public class AbstractInput extends UIComponentBase  {
    
    @Attribute(required=true)
    public abstract String getLabel();
    
    @Attribute(required=true)
    public abstract String getInputStyle();
}
