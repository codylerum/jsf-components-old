package co.cfly.jsf.renderkit;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.richfaces.renderkit.RendererBase;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "jquery.js", library = "org.richfaces"), @ResourceDependency(name = "ZeroClipboard.swf", library = "co.cfly.jsf"),
        @ResourceDependency(name = "ZeroClipboard.min.js", library = "co.cfly.jsf") })
public class CopyRendererBase extends RendererBase {
}
