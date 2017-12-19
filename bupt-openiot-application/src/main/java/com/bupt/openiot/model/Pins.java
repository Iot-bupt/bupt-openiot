package com.bupt.openiot.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dy on 2017/6/5.
 */
public class Pins implements Serializable {

    @SerializedName("3")
    private boolean value3;

    @SerializedName("5")
    private boolean value5;

    public boolean isValue3() {
        return value3;
    }

    public void setValue3(boolean value3) {
        this.value3 = value3;
    }

    public boolean isValue5() {
        return value5;
    }

    public void setValue5(boolean value5) {
        this.value5 = value5;
    }
}
