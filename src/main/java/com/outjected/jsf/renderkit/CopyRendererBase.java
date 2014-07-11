package com.outjected.jsf.renderkit;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;

import org.richfaces.renderkit.RendererBase;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({
		@ResourceDependency(name = "ZeroClipboard.min.js", library = "com.outjected.jsf"),
		@ResourceDependency(name = "ZeroClipboardClient.js", library = "com.outjected.jsf") })
public class CopyRendererBase extends RendererBase {
}
