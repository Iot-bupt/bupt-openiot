package com.bupt.openiot.common.data.page;

import java.io.Serializable;
import java.util.UUID;

public abstract class BasePageLink implements Serializable {

    private static final long serialVersionUID = -4189954843653250481L;

    protected int limit;

    protected UUID idOffset;

    public BasePageLink() {
    }

    public BasePageLink(int limit, UUID idOffset) {
        this.limit = limit;
        this.idOffset = idOffset;
    }

    public int getLimit() {
        return limit;
    }

    public UUID getIdOffset() {
        return idOffset;
    }

    public void setIdOffset(UUID idOffset) {
        this.idOffset = idOffset;
    }
}
