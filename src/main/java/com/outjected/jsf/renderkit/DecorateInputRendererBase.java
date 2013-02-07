package com.outjected.jsf.renderkit;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIMessage;
import javax.faces.context.FacesContext;

import org.richfaces.renderkit.RendererBase;

import com.outjected.jsf.component.AbstractDecorateContainer;
import com.outjected.jsf.component.AbstractDecorateInput;

/**
 * 
 * @author Cody Lerum
 * 
 */
public class DecorateInputRendererBase extends RendererBase {

    public UIMessage getMessage(UIComponent component) {
        return (UIMessage) component.getFacet("message");
    }

    public void encodeValue(FacesContext facesContext, UIComponent component) throws IOException {
        for (UIComponent c : component.getChildren()) {
            c.encodeAll(facesContext);
        }
    }

    public boolean isRequired(UIComponent valueComponent) {
        return ((EditableValueHolder) valueComponent).isRequired();
    }

    public boolean hasErrors(FacesContext facesContext, UIComponent valueComponent) {
        if (!((EditableValueHolder) valueComponent).isValid()) {
            return true;
        }
        else {
            Iterator<FacesMessage> it = facesContext.getMessages(((UIComponent) valueComponent).getClientId(facesContext));
            while (it.hasNext()) {
                if (it.next().getSeverity().compareTo(FacesMessage.SEVERITY_WARN) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public AbstractDecorateInput getDecorateInput(UIComponent component) {
        return (AbstractDecorateInput) component;
    }

    public UIComponent getValueComponent(FacesContext facesContext, UIComponent component, AbstractDecorateInput decorateInput) {

        int editableValueCount = 0;
        UIComponent lastEditableValueHolder = null;
        for (UIComponent c : component.getChildren()) {
            if (c instanceof EditableValueHolder) {
                editableValueCount++;
                lastEditableValueHolder = c;
            }
        }

        if (editableValueCount == 1) {
            return lastEditableValueHolder;
        }
        else if (component.getChildCount() == 0) {
            throw new RuntimeException("Must contain at least 1 child component. Has: " + component.getChildCount() + " Label: " + decorateInput.getLabel());
        }
        else {
            throw new RuntimeException("Must have One and only One EditableValueHolder child. Has: " + editableValueCount + " Label: " + decorateInput.getLabel());
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
