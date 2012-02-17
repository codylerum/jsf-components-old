package co.cfly.jsf.component;

import javax.faces.component.UIComponent;
import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.Facet;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;
import org.richfaces.component.UIRichMessage;

@JsfComponent(type = "co.cfly.jsf.Decorate", family = "co.cfly.layout", renderer = @JsfRenderer(type = "co.cfly.jsf.decorate"), tag = @Tag(name = "decorate"))
abstract public class AbstractDecorate extends UIComponentBase {

    public AbstractDecorate() {
        super();
        UIRichMessage m = new UIRichMessage();
        m.setRendererType("org.richfaces.MessageRenderer");
        this.setMessage(m);
    }

    @Attribute(required = true)
    public abstract String getLabel();

    @Attribute(required = false, defaultValue = "decorate-outer")
    public abstract String getStyleClass();

    @Attribute(required = false, defaultValue = "decorate-label")
    public abstract String getLabelStyleClass();

    @Attribute(required = false, defaultValue = "decorate-value")
    public abstract String getValueStyleClass();

    @Attribute(required = false, defaultValue = "true")
    public abstract boolean isRenderMessage();

    @Attribute(required = false, defaultValue = "decorate-message")
    public abstract String getMessageStyleClass();

    @Facet(name = "message")
    public abstract UIComponent getMessage();

    public abstract void setMessage(UIComponent message);
}
