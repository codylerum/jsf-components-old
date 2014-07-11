package com.outjected.jsf.renderkit;

import javax.faces.component.UIComponent;

import org.richfaces.renderkit.RendererBase;

import com.outjected.jsf.core.Notices;

/**
 * 
 * @author Cody Lerum
 * 
 */
public class NoticeRendererBase extends RendererBase {

	public Notices getNotices(UIComponent component) {
		return (Notices) component.getAttributes().get("notices");
	}
}
