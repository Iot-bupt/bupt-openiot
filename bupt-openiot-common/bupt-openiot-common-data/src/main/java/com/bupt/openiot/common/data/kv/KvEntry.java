package com.bupt.openiot.common.data.kv;

import java.io.Serializable;
import java.util.Optional;

/**
 * Created by dy on 2017/5/1.
 */
public interface KvEntry extends Serializable {

    String getKey();

    DataType getDataType();

    Optional<String> getStrValue();

    Optional<Long> getLongValue();

    Optional<Boolean> getBooleanValue();

    Optional<Double> getDoubleValue();

    String getValueAsString();

    Object getValue();
}
