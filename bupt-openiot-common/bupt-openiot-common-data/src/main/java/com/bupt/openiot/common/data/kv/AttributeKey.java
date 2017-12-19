package com.bupt.openiot.common.data.kv;

import java.io.Serializable;

/**
 * Created by dy on 2017/5/1.
 */
public class AttributeKey implements Serializable {

    private final String scope = "";
    private final String attributeKey = "";

    public String getScope() {
        return scope;
    }

    public String getAttributeKey() {
        return attributeKey;
    }
}
