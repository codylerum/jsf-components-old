package co.cfly.jsf.component;

import javax.faces.component.UIComponentBase;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

import co.cfly.jsf.core.Notices;
 
@JsfComponent(
        type = "co.cfly.jsf.Notice", 
        family = "co.cfly.layout", 
        renderer = @JsfRenderer(type = "co.cfly.jsf.notice"), 
        tag = @Tag(name="notice"))
abstract public class AbstractNotice extends UIComponentBase  {
    
    @Attribute(required=true)
    public abstract Notices getNotices();
    
    @Attribute
    public abstract boolean isExpanded();
    
    @Attribute(defaultValue="Has Errors -- Click for Details")
    public abstract String getErrorTitle();
    
    @Attribute(defaultValue="Has Warnings -- Click for Details")
    public abstract String getWarningTitle();   
    
    @Attribute(defaultValue="Has Infos - Click for Details")
    public abstract String getInfoTitle();     
}
