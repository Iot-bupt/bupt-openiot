package com.bupt.openiot.common.data.kv;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by dy on 2017/5/1.
 */
public abstract class BasicKvEntry implements KvEntry {

    private final String key;

    protected BasicKvEntry(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public Optional<String> getStrValue() {
        // 为指定的值创建一个Optional，如果指定的值为null，则返回一个空的Optional。
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Long> getLongValue() {
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Boolean> getBooleanValue() {
        return Optional.ofNullable(null);
    }

    @Override
    public Optional<Double> getDoubleValue() {
        return Optional.ofNullable(null);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasicKvEntry)) return false;
        BasicKvEntry that = (BasicKvEntry) obj;
        return Objects.equals(key, that.key);
    }

    @Override
    public String toString() {
        return "BasicKvEntry{" +
                "key='" + key + '\'' +
                '}';
    }
}
