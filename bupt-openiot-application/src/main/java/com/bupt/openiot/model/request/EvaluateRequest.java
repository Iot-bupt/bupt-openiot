package com.bupt.openiot.model.request;

/**
 * Created by dy on 2017/5/24.
 */
public class EvaluateRequest {

    private String maxhigh;
    private String upspeed;
    private String speed;
    private String endurancetime;
    private String consumeoil;
    private String deviceId;
    private String capabilityId;

    public String getMaxhigh() {
        return maxhigh;
    }

    public void setMaxhigh(String maxhigh) {
        this.maxhigh = maxhigh;
    }

    public String getUpspeed() {
        return upspeed;
    }

    public void setUpspeed(String upspeed) {
        this.upspeed = upspeed;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getEndurancetime() {
        return endurancetime;
    }

    public void setEndurancetime(String endurancetime) {
        this.endurancetime = endurancetime;
    }

    public String getConsumeoil() {
        return consumeoil;
    }

    public void setConsumeoil(String consumeoil) {
        this.consumeoil = consumeoil;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getCapabilityId() {
        return capabilityId;
    }

    public void setCapabilityId(String capabilityId) {
        this.capabilityId = capabilityId;
    }

    @Override
    public String toString() {
        return "EvaluateRequest{" +
                "maxhigh='" + maxhigh + '\'' +
                ", upspeed='" + upspeed + '\'' +
                ", speed='" + speed + '\'' +
                ", endurancetime='" + endurancetime + '\'' +
                ", consumeoil='" + consumeoil + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", capabilityId='" + capabilityId + '\'' +
                '}';
    }
}
