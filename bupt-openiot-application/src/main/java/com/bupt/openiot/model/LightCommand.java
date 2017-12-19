package com.bupt.openiot.model;

/**
 * Created by dy on 2017/6/5.
 */
public class LightCommand {

    private String method;

    private PinParams params;

    private Integer timeout;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PinParams getParams() {
        return params;
    }

    public void setParams(PinParams params) {
        this.params = params;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
