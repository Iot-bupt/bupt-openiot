package com.bupt.openiot.common.data.id;

import com.bupt.openiot.common.data.EntityType;

import java.util.UUID;

public interface EntityId {

    UUID NULL_UUID = UUID.fromString("13814000-1dd2-11b2-8080-808080808080");

    UUID getId();

    EntityType getEntityType();

    /*@JsonIgnore
    default boolean isNullUid() {
        return NULL_UUID.equals(getId());
    }*/
}
