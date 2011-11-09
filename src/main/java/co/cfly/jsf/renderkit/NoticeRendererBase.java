package co.cfly.jsf.renderkit;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;

import org.richfaces.renderkit.RendererBase;

import co.cfly.jsf.core.Notices;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(library = "javax.faces", name = "jsf.js"), @ResourceDependency(name = "jquery.js") })
public class NoticeRendererBase extends RendererBase {
    
    public Notices getNotices(UIComponent component)
    {
        return (Notices) component.getAttributes().get("notices");
    }
}
