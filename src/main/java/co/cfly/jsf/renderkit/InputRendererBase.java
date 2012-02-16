package co.cfly.jsf.renderkit;

import java.io.IOException;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;

import org.richfaces.component.UIRichMessage;
import org.richfaces.renderkit.RendererBase;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(library = "javax.faces", name = "jsf.js"), @ResourceDependency(name = "jquery.js") })
public class InputRendererBase extends RendererBase {

    private String inputComponentId;
    private EditableValueHolder input;

    public void encodeLabel(FacesContext facesContext, UIComponent component) throws IOException {

        if (inputComponentId == null) {
            inputComponentId = findInputComponentId(facesContext, component);
        }

        String labelValue = (String) component.getAttributes().get("label");

        HtmlOutputLabel label = new HtmlOutputLabel();
        label.setId("label");
        label.setFor(inputComponentId);
        label.setValue(labelValue);
        label.encodeAll(facesContext);
    }

    public void encodeMessages(FacesContext facesContext, UIComponent component) throws IOException {

        if (inputComponentId == null) {
            inputComponentId = findInputComponentId(facesContext, component);
        }

        if (!input.isValid()) {
            UIRichMessage m = new UIRichMessage();
            m.setFor(inputComponentId);
            m.encodeAll(facesContext);
        }
    }

    private String findInputComponentId(FacesContext facesContext, UIComponent component) {
        if (component.getChildCount() == 1) {

            UIComponent child = component.getChildren().get(0);

            if (child instanceof EditableValueHolder) {
                input = (EditableValueHolder) child;
                return child.getClientId(facesContext);
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
