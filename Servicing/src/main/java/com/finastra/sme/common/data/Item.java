
package com.finastra.sme.common.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
public class Item {

    @JsonProperty("@attribute")
    private String attribute;
    @JsonProperty("@valueType")
    private String valueType;
    @JsonProperty("@value")
    private Object value;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String label;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String mandatory;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String readonly;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String linkClass;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String linkId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String linkTarget;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String valueCCY;
    
    public String getAttribute() {
        return attribute;
    }

    @JsonProperty("@attribute")
    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    @JsonProperty("@valueType")
    public String getValueType() {
        return valueType;
    }

    @JsonProperty("@valueType")
    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @JsonProperty("@value")
    public Object getValue() {
        return value;
    }

    @JsonProperty("@value")
    public void setValue(Object value) {
        this.value = value;
    }

    @JsonProperty("@label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("@label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("@mandatory")
    public String getMandatory() {
        return mandatory;
    }

    @JsonProperty("@mandatory")
    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    @JsonProperty("@readonly")
    public String getReadonly() {
        return readonly;
    }

    @JsonProperty("@readonly")
    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    @JsonProperty("@linkClass")
    public String getLinkClass() {
        return linkClass;
    }

    @JsonProperty("@linkClass")
    public void setLinkClass(String linkClass) {
        this.linkClass = linkClass;
    }

    @JsonProperty("@linkId")
    public String getLinkId() {
        return linkId;
    }

    @JsonProperty("@linkId")
    public void setLinkId(String linkId) {
        this.linkId = linkId;
    }

    @JsonProperty("@linkTarget")
    public String getLinkTarget() {
        return linkTarget;
    }

    @JsonProperty("@linkTarget")
    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    @JsonProperty("@valueCCY")
    public String getValueCCY() {
        return valueCCY;
    }

    @JsonProperty("@valueCCY")
    public void setValueCCY(String valueCCY) {
        this.valueCCY = valueCCY;
    }

}
