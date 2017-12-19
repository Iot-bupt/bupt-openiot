package com.bupt.openiot.dao.service;

import com.bupt.openiot.common.data.id.UUIDBased;
import com.bupt.openiot.common.data.page.TextPageLink;
import com.bupt.openiot.dao.exception.IncorrectParameterException;

import java.util.List;
import java.util.UUID;

public class Validator {

    /**
     * 校验字符串
     * @param val
     * @param errorMessage
     */
    public static void validateString(String val, String errorMessage) {
        if (val == null || val.isEmpty()) {
            throw new IncorrectParameterException(errorMessage);
        }
    }

    public static void validatePositiveNumber(long val, String errorMessage) {
        if (val <= 0) {
            throw new IncorrectParameterException(errorMessage);
        }
    }

    public static void validateId(UUID id, String errorMessage) {
        if (id == null) {
            throw new IncorrectParameterException(errorMessage);
        }
    }

    public static void validateId(UUIDBased id, String errorMessage) {
        if (id == null || id.getId() == null) {
            throw new IncorrectParameterException(errorMessage);
        }
    }

    public static void validateIds(List<? extends UUIDBased> ids, String errorMessage) {
        if (ids == null || ids.isEmpty()) {
            throw new IncorrectParameterException(errorMessage);
        } else {
            for (UUIDBased id : ids) {
                validateId(id, errorMessage);
            }
        }
    }

    public static void validatePageLink(TextPageLink pageLink, String errorMessage) {
        if (pageLink == null) {
            throw new IncorrectParameterException(errorMessage);
        } else if (pageLink.getLimit() < 1) {
            throw new IncorrectParameterException(errorMessage);
        } else if (pageLink.getIdOffset() != null && pageLink.getIdOffset().version() != 1) {
            throw new IncorrectParameterException(errorMessage);
        }
    }

}
