package co.cfly.jsf.renderkit;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIMessage;
import javax.faces.context.FacesContext;

import org.richfaces.renderkit.RendererBase;

import co.cfly.jsf.component.AbstractDecorate;
import co.cfly.jsf.component.AbstractDecorateContainer;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "message.reslib", library = "org.richfaces", target = ""), @ResourceDependency(name = "msg.ecss", library = "org.richfaces", target = "") })
public class DecorateRendererBase extends RendererBase {

    public UIMessage getMessage(UIComponent component) {
        return (UIMessage) component.getFacet("message");
    }

    public void encodeValue(FacesContext facesContext, UIComponent component) throws IOException {
        for (UIComponent c : component.getChildren()) {
            c.encodeAll(facesContext);
        }
    }

    public boolean isRequired(UIComponent valueComponent) {
        return isInput(valueComponent) && ((EditableValueHolder) valueComponent).isRequired();
    }

    public boolean isInput(UIComponent valueComponent) {
        return valueComponent instanceof EditableValueHolder;
    }

    public AbstractDecorate getDecorate(UIComponent component) {
        return (AbstractDecorate) component;
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

    public AbstractDecorateContainer getDecorateContainer(UIComponent component) {
        UIComponent parent = component.getParent();
        while (parent != null) {
            if (parent instanceof AbstractDecorateContainer) {
                return (AbstractDecorateContainer) parent;
            }
            else {
                parent = parent.getParent();
            }
        }
        return null;
    }
}
