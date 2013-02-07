package com.outjected.jsf.renderkit;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.richfaces.component.UIRichMessage;
import org.richfaces.renderkit.RendererBase;

import com.outjected.jsf.component.AbstractDecorateContainer;
import com.outjected.jsf.component.AbstractDecorateInput;


/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "message.reslib", library = "org.richfaces", target = ""), @ResourceDependency(name = "msg.ecss", library = "org.richfaces", target = "") })
public class DecorateInputRendererBase extends RendererBase {

    public UIRichMessage getMessage(UIComponent component) {
        return (UIRichMessage) component.getFacet("message");
    }

    public void encodeValue(FacesContext facesContext, UIComponent component) throws IOException {
        for (UIComponent c : component.getChildren()) {
            c.encodeAll(facesContext);
        }
    }

    public boolean isRequired(UIComponent valueComponent) {
        return ((EditableValueHolder) valueComponent).isRequired();
    }

    public AbstractDecorateInput getDecorateInput(UIComponent component) {
        return (AbstractDecorateInput) component;
    }

    public UIComponent getValueComponent(FacesContext facesContext, UIComponent component, AbstractDecorateInput decorateInput) {

        int editableValueCount = 0;
        UIComponent editableValueComponent = null;

        for (UIComponent c : component.getChildren()) {
            if (c instanceof EditableValueHolder) {
                editableValueComponent = c;
                editableValueCount++;
            }
        }

        if (editableValueCount == 1) {
            return editableValueComponent;
        }
        else if (component.getChildCount() == 0) {
            throw new RuntimeException("Must contain at least 1 child component. Has: " + component.getChildCount()  + " Label: " + decorateInput.getLabel());
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
