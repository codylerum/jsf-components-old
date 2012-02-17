package co.cfly.jsf.renderkit;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.richfaces.component.UIRichMessage;
import org.richfaces.renderkit.RendererBase;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "message.reslib", library = "org.richfaces", target = ""), @ResourceDependency(name = "msg.ecss", library = "org.richfaces", target = "") })
public class DecorateRendererBase extends RendererBase {

    public void encodeMessages(FacesContext facesContext, UIComponent component) throws IOException {
        UIComponent valueComponent = getValueComponent(facesContext, component);
        UIRichMessage m = (UIRichMessage) component.getFacet("message");
        m.setFor(valueComponent.getClientId(facesContext));
        m.encodeAll(facesContext);
    }

    public void encodeValue(FacesContext facesContext, UIComponent component) throws IOException {
        for (UIComponent c : component.getChildren()) {
            if (!(c instanceof UIRichMessage)) {
                c.encodeAll(facesContext);
            }
        }
    }

    public String getInputComponentId(FacesContext facesContext, UIComponent valueComponent) {
        return valueComponent.getClientId(facesContext);
    }

    public boolean getRequired(UIComponent valueComponent) {
        return isInput(valueComponent) && ((EditableValueHolder) valueComponent).isRequired();
    }

    public boolean isInput(UIComponent valueComponent) {
        return valueComponent instanceof EditableValueHolder;
    }

    public UIComponent getValueComponent(FacesContext facesContext, UIComponent component) {

        int editableValueCount = 0;
        UIComponent editableValueComponent = null;

        for (UIComponent c : component.getChildren()) {
            if (c instanceof EditableValueHolder) {
                editableValueComponent = c;
                editableValueCount++;
            }
        }

        if (component.getChildCount() == 0) {
            throw new RuntimeException("Must contain at least 1 child component.");
        }
        else if (editableValueCount == 1) {
            return editableValueComponent;
        }
        else if (editableValueCount > 1) {
            throw new RuntimeException("Can't have more than 1 EditableValueHolder child");
        }
        else {
            return component.getChildren().get(0);
        }
    }

    public String getLabelWidth(UIComponent component) {
        String result = (String) getAttributeFromContainer(component, "labelWidth");

        if (result != null) {
            return result;
        }
        else {
            return "150px";
        }
    }

    public String getValueWidth(UIComponent component) {
        String result = (String) getAttributeFromContainer(component, "valueWidth");

        if (result != null) {
            return result;
        }
        else {
            return "300px";
        }
    }

    public String getMessageWidth(UIComponent component) {
        String result = (String) getAttributeFromContainer(component, "messageWidth");

        if (result != null) {
            return result;
        }
        else {
            return "200px";
        }
    }

    private Object getAttributeFromContainer(UIComponent component, String attributeName) {
        UIComponent decorateContainer = getDecorateContainer(component);
        if (decorateContainer != null) {
            return decorateContainer.getAttributes().get(attributeName);
        }
        else {
            return null;
        }
    }

    private static UIComponent getDecorateContainer(UIComponent component) {
        UIComponent parent = component.getParent();

        while (parent != null && parent.getRendererType() != null) {
            if (parent.getRendererType().equals("co.cfly.jsf.decorateContainer")) {
                return parent;
            }
            else {
                parent = parent.getParent();
            }
        }
        return null;
    }
}
