package com.bupt.openiot.common.data.kv;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by dy on 2017/5/1.
 */
public class StringDataEntry extends BasicKvEntry {

    private static final long serialVersionUID = 1L;
    private final String value;

    public StringDataEntry(String key, String value) {
        super(key);
        this.value = value;
    }

    @Override
    public DataType getDataType() {
        return DataType.STRING;
    }

    @Override
    public Optional<String> getStrValue() {
        return Optional.of(value);
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof StringDataEntry))
            return false;
        if (!super.equals(obj))
            return false;
        StringDataEntry that = (StringDataEntry) obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), value);
    }

    @Override
    public String toString() {
        return "StringDataEntry{" + "value='" + value + '\'' + "} " + super.toString();
    }

    @Override
    public String getValueAsString() {
        return value;
    }
}
