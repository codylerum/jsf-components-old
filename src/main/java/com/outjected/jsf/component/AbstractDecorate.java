package com.outjected.jsf.component;

import org.richfaces.cdk.annotations.Attribute;


abstract public class AbstractDecorate extends AbstractObjectField {  
	
	@Attribute(defaultValue = "col-md-3", required = false)
    public abstract String getLabelClass();

    @Attribute(defaultValue = "col-md-9", required = false)
    public abstract String getValueClass();
	
}
