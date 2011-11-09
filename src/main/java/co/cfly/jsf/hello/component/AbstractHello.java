package co.cfly.jsf.hello.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(
        type = "co.cfly.jsf.hello.Hello",
        family = "co.cfly.text",
        renderer = @JsfRenderer(type = "co.cfly.hello"),
        tag = @Tag(name="hello"))
abstract public class AbstractHello extends UIComponentBase {

}
