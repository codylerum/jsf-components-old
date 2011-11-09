package co.cfly.jsf.renderkit;


import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.richfaces.renderkit.RendererBase;
/**
 * 
 * @author Cody Lerum
 *
 */
@ResourceDependencies({
        @ResourceDependency(library = "javax.faces", name = "jsf.js"),
        @ResourceDependency(name = "jquery.js")
})
public class NoticeRendererBase extends RendererBase {
}
