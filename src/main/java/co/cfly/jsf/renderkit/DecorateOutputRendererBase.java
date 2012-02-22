package co.cfly.jsf.renderkit;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.richfaces.renderkit.RendererBase;

import co.cfly.jsf.component.AbstractDecorateContainer;
import co.cfly.jsf.component.AbstractDecorateOutput;

/**
 * 
 * @author Cody Lerum
 * 
 */
public class DecorateOutputRendererBase extends RendererBase {

    public void encodeValue(FacesContext facesContext, UIComponent component) throws IOException {
        for (UIComponent c : component.getChildren()) {
            c.encodeAll(facesContext);
        }
    }

    public AbstractDecorateOutput getDecorateOutput(UIComponent component) {
        return (AbstractDecorateOutput) component;
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
