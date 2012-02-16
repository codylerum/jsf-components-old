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
@ResourceDependencies({ @ResourceDependency(library = "javax.faces", name = "jsf.js"), @ResourceDependency(name = "jquery.js") })
public class DecorateRendererBase extends RendererBase {

    public String getLabel(FacesContext facesContext, UIComponent component) {
        return (String) component.getAttributes().get("label");
    }

    public void encodeMessages(FacesContext facesContext, UIComponent component) throws IOException {

        EditableValueHolder editableValueHolder = getInputComponent(facesContext, component);
        UIComponent inputComponent = (UIComponent) editableValueHolder;

        if (!editableValueHolder.isValid()) {
            UIRichMessage m = new UIRichMessage();
            m.setFor(inputComponent.getClientId(facesContext));
            m.encodeAll(facesContext);
        }
    }

    public String getInputComponentId(FacesContext facesContext, EditableValueHolder editableValueHolder) {
        return ((UIComponent) editableValueHolder).getClientId(facesContext);
    }

    public EditableValueHolder getInputComponent(FacesContext facesContext, UIComponent component) {
        if (component.getChildCount() == 1) {

            UIComponent child = component.getChildren().get(0);

            if (child instanceof EditableValueHolder) {
                return (EditableValueHolder) child;
            }
            else {
                throw new RuntimeException("Child must be instance of EditableValueHolder");
            }
        }
        else {
            throw new RuntimeException("Must contain 1 child component");
        }
    }
}
