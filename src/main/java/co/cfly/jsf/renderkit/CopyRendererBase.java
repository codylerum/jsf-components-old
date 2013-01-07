package co.cfly.jsf.renderkit;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.richfaces.renderkit.RendererBase;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "jquery.js"), @ResourceDependency(name = "ZeroClipboard.min.js", library = "co.cfly.jsf"),
        @ResourceDependency(name = "ZeroClipboardClient.js", library = "co.cfly.jsf") })
public class CopyRendererBase extends RendererBase {
}
