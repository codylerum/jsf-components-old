package com.outjected.jsf.renderkit;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.UIComponent;

import org.richfaces.renderkit.RendererBase;

import com.outjected.jsf.core.Notices;

/**
 * 
 * @author Cody Lerum
 * 
 */
@ResourceDependencies({ @ResourceDependency(name = "jquery.js") })
public class NoticeRendererBase extends RendererBase {

    public Notices getNotices(UIComponent component) {
        return (Notices) component.getAttributes().get("notices");
    }
}
