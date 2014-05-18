package com.outjected.jsf.component;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIInput;

import org.richfaces.cdk.annotations.Attribute;
import org.richfaces.cdk.annotations.JsfComponent;
import org.richfaces.cdk.annotations.JsfRenderer;
import org.richfaces.cdk.annotations.Tag;

@JsfComponent(type = "com.outjected.jsf.Select2AutoComplete", family = "com.outjected.input", renderer = @JsfRenderer(type = "com.outjected.jsf.select2AutoComplete"), tag = @Tag(name = "select2AutoComplete"), attributes = {
    "core-props.xml", "events-key-props.xml", "input-props.xml"})
abstract public class AbstractSelect2AutoComplete extends UIInput implements EditableValueHolder {

  @Attribute(required = false, defaultValue = "Choose")
  public abstract String getPlaceholder();

  @Attribute(required = true)
  public abstract String getSearchPath();

  @Attribute(required = true)
  public abstract String getInitPath();
}
