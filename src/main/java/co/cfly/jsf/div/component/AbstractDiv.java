package co.cfly.jsf.div.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;
 
@JsfComponent(
        type = "co.cfly.oss.jsf.components.div.div.Div", 
        family = "co.cfly.layout", 
        renderer = @JsfRenderer(type = "co.cfly.oss.jsf.components.div"), 
        tag = @Tag(name="div"))
abstract public class AbstractDiv extends UIComponentBase  { 
     
}
